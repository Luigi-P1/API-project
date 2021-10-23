# API-project

### Description
This project designs a simple API based on the northwind database. The project focuses on the applications of data retrieval for specifically the Customers and product tables.
#### URLS for ...
##### ... products
http://localhost:8080/Products/All/SortedBy/ProductID

The url above prints all the products ordered by their ProductID.

http://localhost:8080/products/specificID/{id}    

The url above prints the product with the id specified. (replace "{id} with the ProductID you want to look up")   
If the id given is out of bounds the following is displayed:

{

    "id": 99,
    "productName": "Invalid ID was chosen please try again.",
    "supplierID": null,
    "categoryID": null,
    "quantityPerUnit": "null",
    "unitPrice": null,
    "unitsInStock": null,
    "unitsOnOrder": null,
    "discontinued": null
}

http://localhost:8080/Products/All/GroupBy/Categories

The url above groups all the product by their category id before displaying it.


##### ... Customers

http://localhost:8080/Customers/ThatContains/Name/And/City?name={name}&city={city}

gets customers that have a specific name and are in a specific city.

http://localhost:8080/Customers/ThatContains/Name/Or/City?name={name}&city={city}

gets customers that have a specific name or are in a specific city.

(note: if a user inputs no name or city all customers are returned and if the name and city provided don't yield any results the following is returned:

{

        "id": "null",
        "companyName": "No customer found with these specifications.",
        "contactName": "null",
        "contactTitle": "null",
        "address": "null",
        "city": "null",
        "postalCode": "null",
        "country": "null",
        "phone": "null"

})

http://localhost:8080/Customers/All/AlphabeticalOrder/CompanyNames

gets all customers and arranges the company names in alphabetical order.

http://localhost:8080/Customers/All/GroupBy/Country

groups all customers by their country before returning them.

### Postman

Some tests were carried out using Postman.
i.e. when there were variables at play.
so for the url "http://localhost:8080/Customers/ThatContains/Name/Or/City?name={name}&city={city} "  and "http://localhost:8080/Customers/ThatContains/Name/And/City?name={name}&city={city} "

We checked for when

- the name or city is null, when neither is null,

- one is null

- when one (or both) had data that wasn't present

and for the url "http://localhost:8080/products/specificID/{id} "

We checked when the id is 

- below the allowed limit

- in the allowed limit (being 1-77 inclusive)

- above the limit
