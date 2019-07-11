package com.vdesign.gani.domain.repository;

import com.vdesign.gani.domain.entity.ProdAttr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/10 16:35
 * @Version 1.0
 **/
@Repository
public interface ProdAttrRepository extends JpaRepository<ProdAttr, String> {
}
