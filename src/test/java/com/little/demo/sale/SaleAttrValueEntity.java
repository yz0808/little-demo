package com.little.demo.sale;

import lombok.Data;

/**
 * @Author yangzhong
 * @Date 2021-01-26 17:28
 * @Description 描述
 */
@Data
public class SaleAttrValueEntity {
    private Integer id;
    private String name;

    public SaleAttrValueEntity() {
    }

    public SaleAttrValueEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
