package com.lavg.mapstruck_lombok_demo.mapper;

import com.lavg.mapstruck_lombok_demo.dto.GetCategory;
import com.lavg.mapstruck_lombok_demo.entity.Category;
import com.lavg.mapstruck_lombok_demo.repository.CategoryRepository;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//Uso con Spring Boot
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
@Mapper()
//public abstract class CategoryMapper {
public interface CategoryMapper{

    public CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);


    //Solo si tiene Spring
    //@Autowired
    //private CategoryRepository categoryRepository;

    @Mappings({
            @Mapping(source = "id", target = "categoryId"),
            @Mapping(source = "name", target = "categoryName")
    })
    abstract GetCategory toGetCategory(Category category);


    @InheritInverseConfiguration
     Category toEntity(GetCategory getCategory);
    /*    if(getCategory == null) return null;

    Category category = categoryRepository.findById(getCategory.getCategoryId())
            .orElse(null);

    if (category == null) return null;

    category.setId(getCategory.getCategoryId());
    category.setName(getCategory.getCategoryName());

    return category;
    }*/

    //abstract List<GetCategory> toGetCategoryList(List<Category> categoryList);
    List<GetCategory> toGetCategoryList(List<Category> categoryList);

    //abstract List<Category> toEntityList(List<GetCategory> getCategoryList);
    List<Category> toEntityList(List<GetCategory> getCategoryList);


}
