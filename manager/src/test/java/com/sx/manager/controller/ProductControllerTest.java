package com.sx.manager.controller;

import com.sx.entity.Product;
import com.sx.entity.enums.ProductStatus;
import com.sx.util.RestUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Anui
 * @date : 2020/3/4
 * @time : 17:00
 * @Description :
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    private static RestTemplate rest = new RestTemplate();

    @Value("http://localhost:${local.server.port}/manager")
    private String baseUrl;

    private static List<Product> normals = new ArrayList<>();

    @BeforeClass
    public static void init(){
        Product p1 = new Product("T001","灵活宝1号", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10), BigDecimal.valueOf(1), BigDecimal.valueOf(3.42));
        Product p2 = new Product("T002","活期盈-金色人生", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10), BigDecimal.valueOf(0), BigDecimal.valueOf(3.28));
        Product p3 = new Product("T003","朝朝盈-聚财", ProductStatus.AUDITING.name(), BigDecimal.valueOf(100), BigDecimal.valueOf(10), BigDecimal.valueOf(3.86));
        normals.add(p1);
        normals.add(p2);
        normals.add(p3);
    }

    @Test
    public void create(){
        normals.forEach(product -> {
            Product result = RestUtil.postJSON(rest,baseUrl+"/products", product, Product.class);
            Assert.notNull(result.getCreateAt(),"插入失败");
        });
    }
}
