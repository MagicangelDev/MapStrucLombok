package com.lavg.mapstruck_lombok_demo.test;

import com.lavg.mapstruck_lombok_demo.dto.GetProduct;
import com.lavg.mapstruck_lombok_demo.entity.Product;
import com.lavg.mapstruck_lombok_demo.mapper.ProductMapper;
import com.lavg.mapstruck_lombok_demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class InitiDatabase {

    @Autowired
    private ProductRepository productRepository;

    /*Solo si es con spring
    @Autowired
    private ProductMapper productMapper;*/
    private ProductMapper productMapper = ProductMapper.INSTANCE;





    @Bean
    public CommandLineRunner testProductMapperCommand(){
        return  args -> {

            List<Product> products = productRepository.findAll();
            System.out.println("PRODUCTS");
            products.forEach(System.out::println);

            System.out.println("GET PRODUCTS");
            List<GetProduct> getProductList = productMapper.toGetProductList(products);
            getProductList.forEach(System.out::println);

            System.out.println("MAPPED PRODUCTS");
            List<Product> mappedProducts = productMapper.toEntityList(getProductList);
            mappedProducts.forEach(System.out::println);
        };
    }
}
