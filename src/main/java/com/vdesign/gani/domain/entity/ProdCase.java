package com.vdesign.gani.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/10 16:20
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prod_case")
@Entity
public class ProdCase {
    @Id
    private String id;
    private String prodId;
    private String caseId;
}
