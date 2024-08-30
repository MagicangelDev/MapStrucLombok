package com.lavg.mapstruck_lombok_demo.repository;

import com.lavg.mapstruck_lombok_demo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
