package gr.publicsoft.springbootcrud.controller;

import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private SupplierService service;

    @PostMapping("/addSupplier")
    public Supplier addSupplier(@RequestBody Supplier supplier){return service.saveSupplier(supplier);}

    @PostMapping("/addSuppliers")
    public List<Supplier> addSuppliers(@RequestBody List<Supplier> suppliers){return service.saveSuppliers(suppliers);}

    @GetMapping("/findSuppliers")
    public List<Supplier> findAllSuppliers(){return  service.getSuppliers();}

    @GetMapping("/supplierByVatNumber/{vatNumber}")
    public List<Supplier> findSupplierByVatNumber(@PathVariable String vatNumber){ return  service.searchSupplierByVatNumber(vatNumber);}

    @GetMapping("/supplierByCompanyName/{companyName}")
    public List<Supplier> findSupplierByCompanyName(@PathVariable String companyName){ return  service.searchSupplierByCompanyName(companyName);}

    @DeleteMapping("/delete/{id}")
    public String deleteSupplier(@PathVariable long id){return service.deleteSupplier(id);}

    @PutMapping("/update")
    public Supplier updateSupplier(@RequestBody Supplier supplier) {return service.updateSupplier(supplier);}
}
