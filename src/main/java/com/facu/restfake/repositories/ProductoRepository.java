package com.facu.restfake.repositories;



import com.facu.restfake.entities.Product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends BaseRepository<Product, Long>{
    @Query("SELECT p FROM Product p WHERE p.price > :minimumPrice")
    List<Product> searchPriceHigherThan(@Param("minimumPrice") Double minimumPrice);

    @Query("SELECT p FROM Product p WHERE p.price > :minimumPrice AND p.price < :maximumPrice")
    List<Product> searchPriceBetween(@Param("minimumPrice") Double minimumPrice, @Param("maximumPrice") Double maximumPrice);
}
