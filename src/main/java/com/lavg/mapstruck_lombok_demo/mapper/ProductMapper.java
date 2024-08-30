package com.lavg.mapstruck_lombok_demo.mapper;

import com.lavg.mapstruck_lombok_demo.dto.GetProduct;
import com.lavg.mapstruck_lombok_demo.entity.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

//Uso con SPRING BOOT
/*@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})*/
@Mapper(uses = {CategoryMapper.class})
public interface ProductMapper {

    public ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "creationDate", target = "creationDate",
            dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(source ="name" , target = "productName"),
            @Mapping(source ="id" , target = "productId"),
            @Mapping(source ="price" , target = "price", numberFormat = "$0.00")


    })

    GetProduct toGetDTO(Product product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "creationDate", ignore = true)
    })
    Product toEntity (GetProduct getProduct);

    List<GetProduct> toGetProductList(List<Product> productList);

    List<Product> toEntityList(List<GetProduct> getProductList);


}
