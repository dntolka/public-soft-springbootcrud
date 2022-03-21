package gr.publicsoft.springbootcrud.service;

import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository repository;

    public Supplier saveSupplier(Supplier supplier){return repository.save(supplier);}

    public List<Supplier> saveSuppliers(List<Supplier> suppliers){return (List<Supplier>) repository.saveAll(suppliers);}

    public List<Supplier> getSuppliers(){ return repository.findAll();}

    public List<Supplier> searchSupplierByVatNumber(String vatNumber){return repository.findByVatNumber(vatNumber);}

    public List<Supplier> searchSupplierByCompanyName(String companyName){return repository.findByCompanyName(companyName);}

    public String deleteSupplier(long id){
        repository.deleteById(id);
        return "supplier " +id+ " removed!!!";
    }

    public Supplier updateSupplier(Supplier supplier){
        Supplier existingSupplier = repository.findById(supplier.getId()).orElse(null);
        existingSupplier.setCompanyName(supplier.getCompanyName());
        existingSupplier.setFirstName(supplier.getFirstName());
        existingSupplier.setLastName(supplier.getLastName());
        existingSupplier.setVatNumber(supplier.getVatNumber());
        existingSupplier.setIrsOffice(supplier.getIrsOffice());
        existingSupplier.setAddress(supplier.getAddress());
        existingSupplier.setZipCode(supplier.getZipCode());
        existingSupplier.setCity(supplier.getCity());
        existingSupplier.setCountry(supplier.getCountry());

        return repository.save(existingSupplier);
    }
}
