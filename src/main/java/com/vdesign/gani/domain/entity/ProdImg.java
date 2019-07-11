package com.vdesign.gani.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prod_img")
@Entity
public class ProdImg implements Serializable {
    @Id
    private String id;
    private String productId;
    private String groupanme;
    private String path;
    private Integer seq;
    private Date updatetime;
}