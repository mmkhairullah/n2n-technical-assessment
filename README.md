Etiqa - Technial Assessment - Java Developer - January 2024

1. Task : API must be Restful JSON. API must demonstrate POST, GET, PUT, and DELETE

@GetMapping("bookstore/customer/all") -- get all customer with all books they bought with payload
- Parameter / payload : none

@PostMapping("bookstore/{customerIdNumber}") -- get customer details based on customer id
- Parameter / payload :
  1. customerIdNumber 

@PostMapping("bookstore/add/customer") -- add new customer details with payload
- Parameter / payload :
  1. {
      "idType": "string",
      "idNumber": "string",
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "mobileNumber": "string",
      "officeNumber": "string",
      "familyMember": 0,
      "dateJoined": "2024-01-10T09:25:08.667Z",
      "productsId": 0,
      "productResDTO": {
        "bookTitle": "string",
        "bookPrice": "string",
        "bookQuantity": 0
      }
    }
@PutMapping("bookstore/update/{id}") -- update customer details with payload
- Parameter / payload :
  1. Id
  2. {
      "idType": "string",
      "idNumber": "string",
      "firstName": "string",
      "lastName": "string",
      "email": "string",
      "mobileNumber": "string",
      "officeNumber": "string",
      "familyMember": 0,
      "dateJoined": "2024-01-10T09:25:08.667Z",
      "productsId": 0,
      "productResDTO": {
        "bookTitle": "string",
        "bookPrice": "string",
        "bookQuantity": 0
      }
    }

@DeleteMapping("bookstore/delete/customer/{customerIdNumber}") -- delete customer using customer id number from db
- Parameter / payload :
  1. customerIdNumber 

@DeleteMapping("bookstore/delete/id/{id}") --delete customer using id from db
- Parameter / payload :
  1. id
