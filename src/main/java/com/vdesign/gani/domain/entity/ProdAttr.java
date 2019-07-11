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
 * @Date 2019/7/11 11:02
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prod_attr")
@Entity
public class ProdAttr {
    @Id
    private String id;
    private Integer type;
    private String prodId;
    private String attrId;
    private String attrName;
    private String sattrId;
    private String sattrName;
    private String sPath;
}
