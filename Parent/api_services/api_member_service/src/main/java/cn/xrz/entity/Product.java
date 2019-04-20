package cn.xrz.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author XRZ
 * @date 2019-04-20
 * @Description : 商品实体类
 */
@Data
public class Product implements Serializable {

    private Integer id;
    private String name;   //名称
    private double price;  //价格
    private Integer store; //库存

    public Product(){}

    public Product(Integer id, String name, double price, Integer store) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.store = store;
    }
}
