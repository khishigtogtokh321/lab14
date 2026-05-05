package sict.edu.mn.lab12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sict.edu.mn.lab12.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
