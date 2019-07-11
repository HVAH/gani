package com.vdesign.gani.domain.repository;

import com.vdesign.gani.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/10 16:35
 * @Version 1.0
 **/
@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
}
