package com.syj.prompt.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author guoshi
 * @Date 2021/3/24
 * @desc 请求参数接收基础类
 **/
@Data
public class AbstractReqVo implements RequestValidate{

    @ApiModelProperty(value = "每页大小,默认20")
    protected Integer limit = 20;

    @ApiModelProperty(value = "当前页码,默认1")
    protected Integer current = 1;

    @ApiModelProperty(value = "排序字段名, 无排序可不传")
    private String orderBy;

    @ApiModelProperty(value = "正序:asc,倒序:desc，默认desc, 无排序可不传")
    private String direction;


}
