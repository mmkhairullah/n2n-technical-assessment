package n2ntechnicalassessment.controller;

import n2ntechnicalassessment.dto.ResponseDTO;
import n2ntechnicalassessment.service.BookStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@Validated
@Controller
@RestController
@RequestMapping(path = "/bookstore")
public class BookStoreController extends BaseController {
//
//    @Autowired
//    private BookStoreService bookStoreService;
//
//    @GetMapping("/customer/all")
//    public ResponseDTO<List<CustomerResDTO>> getAllCustomersDetails() {
//        return createResponse(HttpStatus.OK, bookStoreService.getListOfAllCustomers());
//    }
//
//    @PostMapping("/{customerIdNumber}")
//    public ResponseDTO<List<CustomerResDTO>> getCustomerDetails(@PathVariable String customerIdNumber) {
//        return createResponse(HttpStatus.OK, bookStoreService.getCustomerDetails(customerIdNumber));
//    }
//
//    @PostMapping("/add/customer")
//    public ResponseDTO<List<CustomerResDTO>> addNewCustomerDetails(@RequestBody List<CustomerReqDTO> customerReqDTO) {
//        return createResponse(HttpStatus.OK, bookStoreService.addNewCustomerDetails(customerReqDTO));
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseDTO<CustomerResDTO> updateCustomerDetails(@RequestBody CustomerResDTO updatedCustomer, @PathVariable Long id) {
//        return createResponse(HttpStatus.OK, bookStoreService.updateCustomerDetails(updatedCustomer, id));
//    }
//
//    @DeleteMapping("/delete/id/{id}")
//    public ResponseDTO<String> deleteCustomerDetails(@PathVariable Long id) {
//        return createResponse(HttpStatus.OK, bookStoreService.deleteCustomerDetails(id));
//    }
//
//    @DeleteMapping("/delete/customerId/{customerIdNumber}")
//    public ResponseDTO<String> deleteCustomerDetailsByIdNumber(@PathVariable String customerIdNumber) {
//        return createResponse(HttpStatus.OK, bookStoreService.deleteCustomerDetailsByIdNumber(customerIdNumber));
//    }
//
//    @GetMapping("/phoneModel/{phoneModels}/{attributes}")
//    public ResponseDTO<List<String>> getAllPhoneModelandAttributes(@PathVariable String phoneModels, @PathVariable String attributes) {
//        return createResponse(HttpStatus.OK, bookStoreService.getAllPhoneModelandAttributes(phoneModels, attributes));
//    }
//
//
//
//    // TODO : how to use JWT token to sign in in Java Spring Boot
//
//    // also implement session in here

}
