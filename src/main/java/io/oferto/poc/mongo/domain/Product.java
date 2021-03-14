package io.oferto.poc.mongo.domain;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Document(collection="Product")
@ApiModel(description = "Class representing a product")
public class Product implements Serializable {
	private static final long serialVersionUID = -386834374224992611L;

	public Product() {	
	}
	
	public Product(String code, String description, float price) {
		super();
		
		this.code = code;
		this.description = description;
		this.price = price;
	}

	@Id	
    @ApiModelProperty(notes = "Unique identifier of the product. No two products can have the same id.", example = "5fcd2aa7fab8d47f261d1aa2", required = true, position = 0)
	private String id;
	
	@NotBlank(message = "Code is mandatory")
    @ApiModelProperty(notes = "Unique product code. No two products can have the same code.", example = "PRO01", required = true, position = 1)
	private String code;
	
	@Size(max = 255)
    @ApiModelProperty(notes = "Product description", example = "Banana", required = false, position = 2)
	private String description;
    
    @Min(value = 0, message = "Price should not be less than 0")
    @ApiModelProperty(notes = "Product price in euro", example = "10.5", required = true, position = 3)    
	private Float price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", code=" + code + ", description=" + description + ", price=" + price + "]";
	}
}
