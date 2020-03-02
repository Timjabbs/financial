package com.sx.entity.enums;

/**
 * @author : Anui
 * @date : 2020/2/26
 * @time : 14:01
 * @Description :订单类型
 */
public enum OrderType {
    APPLY("申购"),
    REDEEM("赎回");
    private String desc;
    OrderType(String desc){this.desc = desc;}
    public String getDesc(){return desc;}
}
