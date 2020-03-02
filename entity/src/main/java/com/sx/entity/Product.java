package com.sx.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : Anui
 * @date : 2020/2/26
 * @time : 11:55
 * @Description : 产品
 */
@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;
    /**
     * @see com.sx.entity.enums.ProductStatus
     */
    @Column(name = "status")
    private String status;
    //起投金额
    @Column(name = "threshold_amount")
    private BigDecimal thresholdAmount;

    //投资步长
    @Column(name = "step_amount")
    private BigDecimal stepAmount;
    //锁定期
    @Column(name = "lock_term")
    private Integer lockTerm;

    //收益率，因为要与其他数相乘，所以使用BigDecimal
    @Column(name = "reward_rate")
    private BigDecimal rewardRate;

    @Column(name = "memo")
    private String memo;

    @Column(name = "creat_at")
    private Date createAt;
    @Column(name = "update_at")
    private Date updateAt;
    @Column(name = "creat_user")
    private String createUser;
    @Column(name = "update_user")
    private String updateUser;

    public static void main(String[] args){
        System.out.println(new Product());
    }

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }
}
