package com.facu.restfake.services;


import com.facu.restfake.entities.Product;

import java.util.List;


public interface ProductoService extends BaseService<Product,Long> {
    List<Product> searchPriceHigherThan(Double minimunPrice) throws Exception;
    List<Product> searchPriceBetween(Double minimumPrice, Double maximumPrice) throws Exception;
}


