package n2ntechnicalassessment.repository;

import n2ntechnicalassessment.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    @Query(value = "SELECT * FROM products p WHERE p.id = :id", nativeQuery = true)
    Optional <Products> getProductDetailsById (@Param("id") Long id);

}
