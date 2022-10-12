package com.little.demo.sale;

import lombok.Data;

import java.util.List;

/**
 * @Author yangzhong
 * @Date 2021-01-26 17:27
 * @Description 描述
 */
@Data
public class SaleAttrEntity {
    private Integer id;

    private String name;

    private List<SaleAttrValueEntity> saleAttrValueEntityList;
}
