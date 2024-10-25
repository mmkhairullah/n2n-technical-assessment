package n2ntechnicalassessment.service;

import lombok.RequiredArgsConstructor;
import n2ntechnicalassessment.dto.PhoneModelsAndAttributesDTO;
import n2ntechnicalassessment.entity.Customers;
import n2ntechnicalassessment.entity.Products;
import n2ntechnicalassessment.converter.CustomerConverter;
import n2ntechnicalassessment.repository.CardsRepository;
import n2ntechnicalassessment.repository.CustomerRepository;
import n2ntechnicalassessment.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookStoreService {

//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    @Autowired
//    private CustomerConverter customerConverter;
//
//    public List<CustomerResDTO> getListOfAllCustomers() {
//
//        List<Customers> allCust = customerRepository.getAllCustomerList();
////        log.info(allCust.toString());
//        return customerConverter.custEtitytoDTO(allCust);
//
//    }
//
//    public List<CustomerResDTO> getCustomerDetails(String customerIdNumber) {
//
//        List<Customers> custDetails = customerRepository.getCustomerDetails(customerIdNumber);
//        return customerConverter.custEtitytoDTO(custDetails);
//
//    }
//
//
//    public List<CustomerResDTO> addNewCustomerDetails(List<CustomerReqDTO> customerReqDTO) {
//        List<Customers> customersList = new ArrayList<>();
//
//        List<Customers> customersDetails = new ArrayList<>();
//        List<Products> customersProduct = new ArrayList<>();
//
//        for (CustomerReqDTO customerReqDTOz : customerReqDTO) {
//            Customers customer = customerConverter.convertToEntity(customerReqDTOz);
//            customersList.add(customer);
//        }
//
//        for (Customers customerProducts : customersList) {
//            Products products = new Products();
//            products.setId(customerProducts.getProducts().getId());
//            products.setBookTitle(customerProducts.getProducts().getBookTitle());
//            products.setBookQuantity(customerProducts.getProducts().getBookQuantity());
//            products.setBookPrice(customerProducts.getProducts().getBookPrice());
//            customersProduct.add(products);
//
//            List<Products> savedCustomersProducts = productRepository.saveAll(customersProduct);
//        }
//
//        for (Products x : customersProduct) {
//            log.info(String.valueOf(x.getId()));
//            log.info(String.valueOf(x.getBookPrice()));
//            log.info(String.valueOf(x.getBookTitle()));
//            log.info(String.valueOf(x.getBookQuantity()));
//        }
//
//        for (Customers customerDetails : customersList) {
//
//            Customers customer = new Customers();
//            customer.setIdNumber(customerDetails.getIdNumber());
//            customer.setIdType(customerDetails.getIdType());
//            customer.setFirstName(customerDetails.getFirstName());
//            customer.setLastName(customerDetails.getLastName());
//            customer.setMobileNumber(customerDetails.getMobileNumber());
//            customer.setOfficeNumber(customerDetails.getOfficeNumber());
//            customer.setEmail(customerDetails.getEmail());
//            customer.setFamilyMember(customerDetails.getFamilyMember());
//            customer.setDateJoined(customerDetails.getDateJoined());
//
//            customer.setProducts(customerDetails.getProducts());
//
//            customersDetails.add(customer);
//        }
//
//        // Save the customer to the database
//        List<Customers> savedCustomers = customerRepository.saveAll(customersDetails);
//
//        List<CustomerResDTO> customerResDTOList = new ArrayList<>();
//        for (Customers savedCustomer : savedCustomers) {
//            CustomerResDTO customerResDTO = customerConverter.convertToResDTO(savedCustomer);
//            customerResDTOList.add(customerResDTO);
//        }
//
//        return customerResDTOList;
//    }
//
//    public CustomerResDTO updateCustomerDetails(CustomerResDTO updatedCustomer, Long id) {
//
//        Optional<Customers> optionalCustomer = customerRepository.findById(id);
//
//        if (optionalCustomer.isPresent()) {
//            Customers customer = optionalCustomer.get();
//            customer.setEmail(updatedCustomer.getEmail());
//            customer.setIdType(updatedCustomer.getIdType());
//            customer.setIdNumber(updatedCustomer.getIdNumber());
//            customer.setFirstName(updatedCustomer.getFirstName());
//            customer.setLastName(updatedCustomer.getLastName());
//            customer.setMobileNumber(updatedCustomer.getMobileNumber());
//            customer.setOfficeNumber(updatedCustomer.getOfficeNumber());
//            customer.setFamilyMember(updatedCustomer.getFamilyMember());
//            customer.setDateJoined(updatedCustomer.getDateJoined());
//            Customers savedCustomer = customerRepository.save(customer);
//
//            return customerConverter.convertToResDTO(savedCustomer);
//        } else {
////            Customers failedCustomer = new Customers();
////            return customerConverter.convertToResDTO(failedCustomer);
//            throw new RuntimeException("Customer not found for id: " + id);
//        }
//    }
//
//    public String deleteCustomerDetails(Long id) {
//
////        log.info(String.valueOf(id));
//        customerRepository.deleteById(id);
//        return "ID Deleted Successfully : " + id;
//
//    }
//
//    public String deleteCustomerDetailsByIdNumber(String customerIdNumber) {
//
////        log.info(customerIdNumber);
//        customerRepository.deleteCustomerDetailsByIdNumber(customerIdNumber);
//        return "Customer Id Number Deleted Successfully : " + customerIdNumber;
//
//    }
//
//    public List<String> getAllPhoneModelandAttributes(String phoneModels, String attributes) {
//
//        List<PhoneModelsAndAttributesDTO> phoneNattributes = new ArrayList<>();
//
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("iPhone 14 Pro Max", "6.7 inches", "OLED", "HEAVY"));
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("iPhone 14 Pro", "6.1 inches", "OLED", "MEDIUM"));
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("iPhone 13 Pro Max", "6.7 inches", "OLED", "HEAVY"));
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("iPhone 13 Pro", "6.1 inches", "OLED", "MEDIUM"));
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("iPhone 13", "6.1 inches", "OLED", "LIGHT"));
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("iPhone 12", "6.1 inches", "OLED", "LIGHT"));
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("iPhone 11", "6.1 inches", "LCD", "LIGHT"));
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("Samsung Galaxy S21", "6.2 inches", "OLED", "LIGHT"));
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("Samsung Galaxy S22", "6.1 inches", "AMOLED", "LIGHT"));
//        phoneNattributes.add(new PhoneModelsAndAttributesDTO("Samsung Galaxy S22 Plus", "6.6 inches", "AMOLED", "MEDIUM"));
//
//        List<String> matchingModels = new ArrayList<>();
//
//        for (PhoneModelsAndAttributesDTO phoneModel : phoneNattributes) {
//            if (phoneModel.getDisplaySize().equals(attributes) || phoneModel.getDisplayType().equals(attributes) || phoneModel.getWeight().equals(attributes) || phoneModel.getModel().equals(phoneModels)) {
//                if (!matchingModels.contains(phoneModel.getModel())) {
//                    matchingModels.add(phoneModel.getModel());
//                }
//                log.info("This is phone model with this attributes + ," + phoneModel.getModel());
//            }
//        }
//
//        if (matchingModels.isEmpty()) {
//            matchingModels.add("NO MATCH");
//        }
//
//        return matchingModels;
//    }


}
