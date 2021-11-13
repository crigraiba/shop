package com.example.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Product;

@Repository
public interface IProductRepository extends MongoRepository<Product, UUID> {
}
