package n2ntechnicalassessment.repository;

import n2ntechnicalassessment.entity.Customers;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Long> {

    @Query(value = "SELECT * FROM customers c", nativeQuery = true)
    List<Customers> getAllCustomerList();

    @Query(value = "SELECT * FROM customers c WHERE c.id_number = :customerIdNumber", nativeQuery = true)
    List<Customers> getCustomerDetails (@Param("customerIdNumber") String customerId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM customers c WHERE c.id_number = :customerIdNumber", nativeQuery = true)
    void deleteCustomerDetailsByIdNumber (@Param("customerIdNumber") String customerId);

}
