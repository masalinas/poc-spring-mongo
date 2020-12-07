package io.oferto.poc.mongo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.oferto.poc.mongo.domain.Product;
import io.oferto.poc.mongo.repository.ProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@Api(value = "Set of endpoints for CRUD Product operations")
public class ProductController {
	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value = "Get all products", nickname = "getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts() {
		try {
		    /*List<Product> products = new ArrayList<Product>();

		    productRepository.findAll().forEach(products::add);

		    if (products.isEmpty()) {
		      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		    }*/

			List<Product> products = productRepository.findAll();
					
		    return new ResponseEntity<>(products, HttpStatus.OK);
		  } catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		  }
	}
	
	@ApiOperation(value = "Get product by Id", nickname = "getProductById")
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@ApiParam(value="Id of the Product") @PathVariable("id") String id) {
		Optional<Product> productData = productRepository.findById(id);

		if (productData.isPresent()) {
		    return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@ApiOperation(value = "Create a product", nickname = "createProduct")
	@PostMapping("/products")
    @ApiResponses({
        @ApiResponse(code = 400, message = "Bad Request"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
	public ResponseEntity<Product> createProduct(@ApiParam(value="Product entity") @Valid @RequestBody Product product) {
		try {
		    Product _product = productRepository.save(new Product(product.getCode(), product.getDescription(), product.getPrice()));
		    return new ResponseEntity<>(_product, HttpStatus.CREATED);
		} catch (Exception e) {
		    return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}	    
	}
	
	@ApiOperation(value = "Update a product", nickname = "updateProduct")
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@ApiParam(value="Id of the Product") @PathVariable("id") String id, @ApiParam(value="Product entity") @RequestBody Product product) {
		Optional<Product> productData = productRepository.findById(id);

		if (productData.isPresent()) {
			Product _product = productData.get();
			
			_product.setCode(product.getCode());
			_product.setDescription(product.getDescription());
			_product.setPrice(product.getPrice());
			
			return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		    
	}
	
	@ApiOperation(value = "Remove a product", nickname = "deleteProduct")
	@DeleteMapping("/products/{id}")
    @ApiResponses({
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
	public ResponseEntity<HttpStatus> deleteProduct(@ApiParam(value="Id of the Product") @PathVariable("id") String id) {
		try {
			productRepository.deleteById(id);
			
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	    
	}
	
	@ApiOperation(value = "Patch a product", nickname = "pathProduct")
	@PatchMapping("/products/{id}")
	public ResponseEntity<Product> pathProduct(@ApiParam(value="Id of the Product") @PathVariable("id") String id, @ApiParam(value="Product patch") @RequestBody Product patch) {
		try {			
			Optional<Product> productData = productRepository.findById(id);

			if (productData.isPresent()) {
				Product _product = productData.get();
				
				if (patch.getCode() != null) {
					_product.setCode(patch.getCode());
				}
				
				if (patch.getDescription() != null) {
					_product.setDescription(patch.getDescription());
				}
				
				if (patch.getPrice() != null) {
					_product.setPrice(patch.getPrice());
				}
				
				return new ResponseEntity<>(productRepository.save(_product), HttpStatus.OK);			
			}
					
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
		    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}	    
	}
}
