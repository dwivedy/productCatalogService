Build the application

##requirements -

Apache Maven 3.5.3

Java version: 1.8

##Build App -

mvn clean install -X - in debug mode

##To start the application(Spring boot application)

To start the application we need to run to services

Then running the products service
`java -jar target/target/productCatalogService-0.0.1-SNAPSHOT.jar` - after this command wait for the server to up completely


##Create Product


`http://localhost:5000/products`

`Method: POST`

Request Payload
`{
"name":"apple watch",
"description":"digital watch ",
 "type":"watch",
 "price":135.50
}`

Response 
`{
  "id": 1,
  "name": "apple watch",
  "description": "digital watch ",
  "type": "watch",
  "price": 135.50
}`


##Get findProductByID


`http://localhost:5000/products/{productId}`

`Method: GET`

Response 
`{
  "id": 1,
  "name": "apple watch",
  "description": "digital watch ",
  "type": "watch",
  "price": 135.50
}`

##Update updateProductByID


`http://localhost:5000/products/{productId}`

`Method: PUT`

Request Payload
`{
"name":"apple latest watch",
"description":"digital watch latest collection",
 "type":"watch",
 "price":234.50
}`

Response 
`{
  "id": 1,
  "name": "apple latest watch",
  "description": "digital watch latest collection",
  "type": "watch",
  "price": 234.50
}`

##find product by type ,returns list

`http://localhost:5000/products/type/{productType}`

`http://localhost:5000/products/type/watch`

`Method: GET`

Response Sample
`[
  {
    "id": 1,
    "name": "apple latest watch",
    "description": "digital watch latest collection",
    "type": "watch",
    "price": 234.50
  }
]`

##find product by product name , returns list

`http://localhost:5000/products/name/{productName}`

`http://localhost:5000/products/name/apple latest watch`

`Method: GET`

`Response
[
  {
    "id": 1,
    "name": "apple latest watch",
    "description": "digital watch latest collection",
    "type": "watch",
    "price": 234.50
  }
]`

##Delete ProductByID

`http://localhost:5000/products/{productId}`

`http://localhost:5000/products/1`

`Method: Delete`

Response
`{
  "id": 1,
  "name": "apple latest watch",
  "description": "digital watch latest collection",
  "type": "watch",
  "price": 234.50
}`
