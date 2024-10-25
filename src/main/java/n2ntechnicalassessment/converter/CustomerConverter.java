package n2ntechnicalassessment.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerConverter {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    public List<CustomerResDTO> custEtitytoDTO (List<Customers> custDetails) {
//
//        List<CustomerResDTO> result = new ArrayList<>();
//        for (Customers customer : custDetails) {
//            CustomerResDTO customerResDTO = new CustomerResDTO();
//
//            Products products = productRepository.getProductDetailsById(customer.getProducts().getId()).orElse(null);
//            ProductResDTO productResDTO = new ProductResDTO();
//            if (products != null) {
//                productResDTO.setBookPrice(products.getBookPrice());
//                productResDTO.setBookTitle(products.getBookTitle());
//                productResDTO.setBookQuantity(products.getBookQuantity());
//            }
//
//            customerResDTO.setIdType(customer.getIdType());
//            customerResDTO.setIdNumber(customer.getIdNumber());
//            customerResDTO.setFirstName(customer.getFirstName());
//            customerResDTO.setLastName(customer.getLastName());
//            customerResDTO.setEmail(customer.getEmail());
//            customerResDTO.setDateJoined(customer.getDateJoined());
//            customerResDTO.setFamilyMember(customer.getFamilyMember());
//            customerResDTO.setMobileNumber(customer.getMobileNumber());
//            customerResDTO.setOfficeNumber(customer.getOfficeNumber());
//            customerResDTO.setProductsId(customer.getProducts().getId());
//
//            customerResDTO.setProductResDTO(productResDTO);
//
//            result.add(customerResDTO);
//        }
//
//        return result;
//    }
//
//    public CustomerResDTO convertToResDTO(Customers customer) {
//        CustomerResDTO customerResDTO = new CustomerResDTO();
//
//        customerResDTO.setIdType(customer.getIdType());
//        customerResDTO.setIdNumber(customer.getIdNumber());
//        customerResDTO.setFirstName(customer.getFirstName());
//        customerResDTO.setLastName(customer.getLastName());
//        customerResDTO.setEmail(customer.getEmail());
//        customerResDTO.setDateJoined(customer.getDateJoined());
//        customerResDTO.setFamilyMember(customer.getFamilyMember());
//        customerResDTO.setMobileNumber(customer.getMobileNumber());
//        customerResDTO.setOfficeNumber(customer.getOfficeNumber());
//        customerResDTO.setProductsId(customer.getProducts().getId());
//
//        Products products = productRepository.getProductDetailsById(customer.getProducts().getId()).orElse(null);
//        ProductResDTO productResDTO = new ProductResDTO();
//        if (products != null) {
//            productResDTO.setBookPrice(products.getBookPrice());
//            productResDTO.setBookTitle(products.getBookTitle());
//            productResDTO.setBookQuantity(products.getBookQuantity());
//        }
//        customerResDTO.setProductResDTO(productResDTO);
//
//        return customerResDTO;
//    }
//
//    public Customers convertToEntity(CustomerReqDTO dto) {
//
//        Customers customer = new Customers();
//
//        customer.setEmail(dto.getEmail());
//        customer.setIdType(dto.getIdType());
//        customer.setIdNumber(dto.getIdNumber());
//        customer.setFirstName(dto.getFirstName());
//        customer.setLastName(dto.getLastName());
//        customer.setMobileNumber(dto.getMobileNumber());
//        customer.setOfficeNumber(dto.getOfficeNumber());
//        customer.setFamilyMember(dto.getFamilyMember());
//        customer.setDateJoined(dto.getDateJoined());
//
//        Products product = convertProductToEntity(dto.getProductReqDTO());
//        customer.setProducts(product);
//
//        return customer;
//    }
//
//    private Products convertProductToEntity(ProductReqDTO productReqDTO) {
//
//        Products product = new Products();
//
//        product.setId(productReqDTO.getId());
//        product.setBookTitle(productReqDTO.getBookTitle());
//        product.setBookQuantity(productReqDTO.getBookQuantity());
//        product.setBookPrice(productReqDTO.getBookPrice());
//
//        return product;
//    }

}
