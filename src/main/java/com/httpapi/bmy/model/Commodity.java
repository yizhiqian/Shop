package com.httpapi.bmy.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Commodity {

    private int id;
    private  String commodity_name;
    private double commodity_nowpricep;
    private String commodity_brand;
    private String commodity_stock;
    private double commodity_oldprice;
    private String commodity_sales;
    private String commodity_main;
    private String commodity_thumbnail;
    private String commodity_attachimg;
    private String commodity_content;



}
