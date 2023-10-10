package com.facu.restfake.services;


import com.facu.restfake.entities.Product;
import com.facu.restfake.repositories.BaseRepository;
import com.facu.restfake.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  extends BaseServiceImpl<Product, Long> implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public ProductServiceImpl(BaseRepository<Product, Long> baseRepository, ProductoRepository productoRepository) {
        super(baseRepository);
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Product> searchPriceHigherThan(Double minimunPrice) throws Exception {
        try {
            List<Product> products = productoRepository.searchPriceHigherThan(minimunPrice);
            return products;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Product> searchPriceBetween(Double minimumPrice, Double maximumPrice) throws Exception {
        try {
            List<Product> products = productoRepository.searchPriceBetween(minimumPrice, maximumPrice);
            return products;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
