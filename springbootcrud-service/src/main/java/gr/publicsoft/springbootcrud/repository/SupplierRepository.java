package gr.publicsoft.springbootcrud.repository;

import gr.publicsoft.springbootcrud.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    List<Supplier> findByVatNumber(String vatNumber);
    List<Supplier> findByCompanyName(String companyName);
}
