# Ecommerce_Api

Hit Url :

## USER API :

Sign up :

URL : (post mapping)  http://localhost:8080/user/signup 
pass to data in this format -                                                                                                                       
{
        "firstName": "allu",
        "lastName": "Shubham",
        "email": "allu@gmail.com",
        "password": "allu0303"
}                                                                                                                                            

Sign In :
URL: (PostMapping)  http://localhost:8080/user/signIn                                                                                                           

hit jsoJSONn in this format:                                                                                                                    
{
    "email":"allu@gmail.com",
    "password":"allu0303"
}                                                                                                                                             

Result :                                                                                                                            

{
    "status": "success",
    "token": "a458429b6-7f72-4c91-be3c-d1625658c2cf"
}                                                                                                                                                         

Get ALL USER at all :
GetMapping (url) http://localhost:8080/user/all ? token = passTheToken                                                                                
Note: need Token in Request param
Example: http://localhost:8080/user/all?token=e8d2b831-5c9e-4e28-a66c-83220ff88022                                                                            

## Category controller :                                                                                                                                    

Add Category 
PostMapping : (URL) http://localhost:8080/category/create                                                                                                     
JSON data format:
{
    "categoryName":"women's",
    "description": "clothes",
    "imageUrl": "N/A...."
}                                                                                                                                                                  

Update Category :

PutMapping (URL) http://localhost:8080/category/update/ PASSCATEGORYID                                                                               
JSON i.e.
{
    "categoryName": "women",
    "description": "Nike",
    "imageUrl": "N/A...."
}                                                                                                                                                                         

GET CATEGORY :

GetMapping : (url) http://localhost:8080/category/ 
## PRODUCT SECTION

ADD data                                                                                                                                                  
PostMapping (URL ) : http://localhost:8080/product/add                                                                                              
JSON :
{
        "id": 11,
        "name": "pink_black",
        "imageURL": "Na",
        "price": 6.0,
        "description": "Nikke",
        "categoryId": 1
}

GET DATA 
GetMapping (url) : http://localhost:8080/product/                                                                                                        

UPDATE DATA
PutMapping  (URL) http://localhost:8080/product/update/pass product id                                                                                    
JSON :
{
        "id": 2,
        "name": "shoes",
        "imageURL": "na",
        "price": 600.0,
        "description": "Nikke",
        "categoryId": 1
}

## wishlist

PostMapping (url) http://localhost:8080/wishlist/add? token= pass to token                                                                                
Example: http://localhost:8080/wishlist/add?token=a28429b6-7f72-4c91-be3c-d1625658c2cf                                                    

JSON                                                                                                                   
{
     "id":1,
    "name":"Lenovo..",
    "imageURL":".....",
    "price":900,
    "description": "N/A...",
    "categoryId":1
}

GetMapping (url) http://localhost:8080/wishlist/ pass token

## CART
 ADD DATA
PostMapping (url) http://localhost:8080/cart/add?token=pass token                                                                                
EXAMPLE : http://localhost:8080/cart/add?token=a28429b6-7f72-4c91-be3c-d1625658c2cf                                                                               
JSON                                                                                                       
{
    "productId":1,
    "quantity":1
}

GET DATA
GetMaping(url) http://localhost:8080/cart/?token=pass token
EXAMPLE : http://localhost:8080/cart/?token=edbd50c9-1cb2-457b-bb74-603c43ffb26b

DELETE TOKEN
DeleteMaping(url) http://localhost:8080/cart/delete/pass Cart id ?token=pass token
EXAMPLE:  http://localhost:8080/cart/delete/2?token=edbd50c9-1cb2-457b-bb74-603c43ffb26b

Update Cart 
PutMaping(url)http://localhost:8080/cart/update/pass cart id ?token=pass token

Example: http://localhost:8080/cart/update/2?token=edbd50c9-1cb2-457b-bb74-603c43ffb26b  

JSON                                                                                                                                                         
{
    "id":2,
    "productId":1,
    "quantity":10
}



**
