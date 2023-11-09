package com.masai.ecomm.service;

import static com.masai.ecomm.config.MessageStrings.USER_CREATED;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.ecomm.config.MessageStrings;
import com.masai.ecomm.dto.ResponseDto;
import com.masai.ecomm.dto.SignInDto;
import com.masai.ecomm.dto.SignInResponseDto;
import com.masai.ecomm.dto.SignupDto;
import com.masai.ecomm.enums.ResponseStatus;
import com.masai.ecomm.exception.AuthenticationFailException;
import com.masai.ecomm.exception.CustomException;
import com.masai.ecomm.model.AuthenticationToken;
import com.masai.ecomm.model.User;
import com.masai.ecomm.repository.UserRepository;
import com.masai.ecomm.utils.Helper;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	AuthenticationService authenticationService;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	public ResponseDto signUp(SignupDto signupDto) throws CustomException {
		// Check to see if the current email address has already been registered.
		if (Helper.notNull(userRepository.findByEmail(signupDto.getEmail()))) {
			// If the email address has been registered then throw an exception.
			throw new CustomException("User already exists");
		}
		// first encrypt the password
		String encryptedPassword = signupDto.getPassword();
		try {
			encryptedPassword = hashPassword(signupDto.getPassword());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
		}

		User user = new User(signupDto.getFirstName(), signupDto.getLastName(), signupDto.getEmail(),
				encryptedPassword);

		User createdUser;
		try {
			// save the User
			createdUser = userRepository.save(user);
			// generate token for user
			final AuthenticationToken authenticationToken = new AuthenticationToken(createdUser);
			// save token in database
			authenticationService.saveConfirmationToken(authenticationToken);
			// success in creating
			return new ResponseDto(ResponseStatus.success.toString(), USER_CREATED);
		} catch (Exception e) {
			// handle signup error
			throw new CustomException(e.getMessage());
		}
	}

	public SignInResponseDto signIn(SignInDto signInDto) throws CustomException {
		// first find User by email
		User user = userRepository.findByEmail(signInDto.getEmail());
		if (!Helper.notNull(user)) {
			throw new AuthenticationFailException("user not present");
		}
		try {
			// check if password is right
			if (!user.getPassword().equals(hashPassword(signInDto.getPassword()))) {
				// passowrd doesnot match
				throw new AuthenticationFailException(MessageStrings.WRONG_PASSWORD);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			logger.error("hashing password failed {}", e.getMessage());
			throw new CustomException(e.getMessage());
		}

		AuthenticationToken token = authenticationService.getToken(user);

		if (!Helper.notNull(token)) {
			// token not present
			throw new CustomException("token not present");
		}

		return new SignInResponseDto("success", token.getToken());
	}

	String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password.getBytes());
		byte[] digest = md.digest();

		String myHash = bytesToHex(digest);

		return myHash;
	}

	public static String bytesToHex(byte[] bytes) {
		StringBuilder hexString = new StringBuilder(2 * bytes.length);
		for (byte b : bytes) {
			hexString.append(String.format("%02X", b));
		}
		return hexString.toString();
	}
}
