# ecommerce_backend

**
### How to run in local

src/main/resources/application.properties.
Change the Application Properties (E.g. username/password of DB) present in resources/application.properties according to your local mysql-server.
Example:
 spring.datasource.url=jdbc:mysql://localhost:3306/DATABASE_NAME  Note : First create databas in MY_SQL (database name :ecommerce )
 spring.datasource.username=root                                                                              
 spring.datasource.password=root                                      
 spring.jpa.hibernate.ddl-auto=update                                                                                                                                                 
 spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver                                                           



To run the application, automaticaly created all table;
example :
1-user
2 - category
3 - product
4 - cart
5 - wishlist

## show on

Hit Url :

## USER API :

Sign up :

url : (postMapping)  http://localhost:8080/user/signup 
pass to data this formate -                                                                                                                       
{
        "firstName": "ramram",
        "lastName": "Patel",
        "email": "ram@gmail.com",
        "password": "ram0929"
}                                                                                                                                            

Sign In :
url: (PostMapping)  http://localhost:8080/user/signIn                                                                                                           

hit josn farmet:                                                                                                                    
{
    "email":"ram@gmail.com",
    "password":"ram0929"
}                                                                                                                                             

Result :                                                                                                                            

{
    "status": "success",
    "token": "a28429b6-7f72-4c91-be3c-d1625658c2cf"
}                                                                                                                                                         

Get ALL USER :
GetMapping (url) http://localhost:8080/user/all ? token = pass to token                                                                                 
Note : need Token
Example : http://localhost:8080/user/all?token=e8d2b831-5c9e-4e28-a66c-83220ff88022                                                                            

## Category controller :                                                                                                                                    

Add Catgory 
PostMapping : (url) http://localhost:8080/category/create                                                                                                     
json data formate:
{
    "categoryName":"men's",
    "description": "cloths",
    "imageUrl":"no...."
}                                                                                                                                                                  

Update Gatgory :

PutMapping (url) http://localhost:8080/category/update/ PASS CATEGORY ID                                                                               
JOSN
{
    "categoryName":"women",
    "description": "nike",
    "imageUrl":"no...."
}                                                                                                                                                                         

GET CATGORY :

GetMapping : (url) http://localhost:8080/category/ 
## PRODUCT SECTION

ADD data                                                                                                                                                  
PostMapping (url ) : http://localhost:8080/product/add                                                                                              
JSON :
{
        "id": 1,
        "name": "pen_black",
        "imageURL": "Na",
        "price": 6.0,
        "description": "nke",
        "categoryId": 2
}

GET DATA 
GetMapping (url) : http://localhost:8080/product/                                                                                                        

UPDATE DATA
PutMapping  (url) http://localhost:8080/product/update/pass product id                                                                                    
JSON :
{
        "id": 1,
        "name": "shose",
        "imageURL": "na",
        "price": 600.0,
        "description": "nke",
        "categoryId": 1
}

## wishlist

PostMapping (url) http://localhost:8080/wishlist/add ? token= pass to token                                                                                
Example : http://localhost:8080/wishlist/add?token=a28429b6-7f72-4c91-be3c-d1625658c2cf                                                    

JSON                                                                                                                   
{
     "id":1,
    "name":"lenvo..",
    "imageURL":".....",
    "price":900,
    "description":"e...",
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
EXAMPLE :  http://localhost:8080/cart/delete/2?token=edbd50c9-1cb2-457b-bb74-603c43ffb26b

Update Cart 
PutMaping(url)http://localhost:8080/cart/update/pass cart id ?token=pass token

Eaxmple : http://localhost:8080/cart/update/2?token=edbd50c9-1cb2-457b-bb74-603c43ffb26b  

JSON                                                                                                                                                         
{
    "id":2,
    "productId":1,
    "quantity":10
}



**
