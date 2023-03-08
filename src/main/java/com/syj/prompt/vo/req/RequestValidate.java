package com.syj.prompt.vo.req;

/**
 * @author guoshi
 * @Date 2021/3/29
 * @desc
 **/
public interface RequestValidate {
    /**
     * 校验参数
     */
    default void validate(){ }
}
