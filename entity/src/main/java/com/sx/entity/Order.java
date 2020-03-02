package com.sx.entity;

import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author : Anui
 * @date : 2020/2/26
 * @time : 11:55
 * @Description :订单
 */

@Data
@Entity(name="order_t")
public class Order {
    @Id
    private String orderId;
    //渠道id
    private String chanId;
    private String chanUserId;
    /**
     * @see com.sx.entity.enums.OrderType
     */
    private String orderType;
    private String productId;
    private BigDecimal amount;
    private String outerOrderId;
    /**
     * @see com.sx.entity.enums.OrderStatus
     */
    private String orderStatus;
    private String memo;
    private Date createAt;
    private Date updateAt;

    @Override
    public String toString(){
        return ReflectionToStringBuilder.toString(this);
    }


}
