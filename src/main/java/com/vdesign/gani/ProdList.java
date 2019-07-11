package com.vdesign.gani;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description
 * @Author Jiang
 * @Date 2019/7/10 9:38
 * @Version 1.0
 **/
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProdList {
    private List<Prod> data;
    private String msg;
    private Integer status;
}
