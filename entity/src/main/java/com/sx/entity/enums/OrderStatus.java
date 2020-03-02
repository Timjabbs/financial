package com.sx.entity.enums;

/**
 * @author : Anui
 * @date : 2020/2/26
 * @time : 14:04
 * @Description :订单状态
 */
public enum OrderStatus {
    INIT("初始化"),
    PROCESS("处理中"),
    SUCCESS("成功"),
    FAIL("失败");
    private String desc;
    OrderStatus(String desc){this.desc = desc;}
    public String getDesc(){return desc;}
}
