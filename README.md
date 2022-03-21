DESPOINA NTOLKA

I implemented the backend part of Supplier.

1] First, I made some changes in the "application.properites" file:
	
	spring.datasource.username=root
	spring.datasource.password=root12345
	spring.jpa.hibernate.ddl-auto=update
	spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect
	spring.jpa.open-in-view=false
	spring.jpa.show-sql = true 
	
2] Then in the model "Supplier", I created my own table "Suppliers", which is in the database    	"springbootcrud" using the annotation : @Table(name = "Suppliers") . Also, I deleted the     	existing table "Supplier" in liquibase.

3] In folder springbootcrud-service/src/main/gr.publicsoft.springbootcrud/repository I created a Reposiroty Interface so as to perform crud operations on Model "Supplier", and tt is called "SupplierRepository". Also, it is an extension of JpaRepository<Supplier, Long>, so as to use JpaRepository’s methods: save(), findById(), findAll(), deleteById()… without implementing these methods.

I also defined custom finder methods:
– findByVatNumber(String vatNumber): returns the supplier with the given vatNumber.
– findByCompanyName(String companyName): returns the supplier with the given companyName.

4] I created a package service, and there a class "SupplierService". I defined a private variable "SupplierRepository" and created some functions using the methods above. 

5] Finally, I created a controller that provides APIs for creating, reading, updating and deleting Suppliers, named "SupplierController" in the package "controller".

@RestController annotation is used to define a controller and to indicate that the return value of the methods should be be bound to the web response body.

@Autowired is to inject SupplierRepository bean to local variable.

6] In order to test , I send curl requests using : http://localhost:8080/"function_in_controller"

For example,

(POST) http://localhost:8080/addSupplier

Body -> raw (JSON) -> {
			"companyName": "paldo",
			"firstName": "despoina",
			"lastName": "ntolka",
			"vatNumber": "12345",
			"irsOffice": "232",
			"address": "plateia66",
			"zipCode": "73131",
			"city": "chania",
			"country": "greece"
		       }

(GET) http://localhost:8080/findSuppliers
(GET) http://localhost:8080/supplierByVatNumber/{vatNumber}
(GET) http://localhost:8080/supplierByCompanyName/{companyName}

(DELETE) http://localhost:8080/delete/{id}

(PUT) http://localhost:8080/update

Body -> raw (JSON) -> {
			"id": ,
			"companyName": "paldo_new",
			"firstName": "despoina",
			"lastName": "ntolka",
			"vatNumber": "12345",
			"irsOffice": "232",
			"address": "plateia66",
			"zipCode": "73131",
			"city": "chania",
			"country": "greece"
		       }
