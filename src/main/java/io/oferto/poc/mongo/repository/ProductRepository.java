package io.oferto.poc.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.oferto.poc.mongo.domain.Product;

@Repository
public interface ProductRepository  extends MongoRepository<Product, String> {
}
