package com.syj.prompt.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author syj@yxt.com
 * @since 2023/3/8 17:01
 */
@Data
public class PromptsUpdateVo {


    @ApiModelProperty(value = "提示语Id", required = true)
    private Long promptId;

    @ApiModelProperty(value = "提示语返回结果", required = true)
    private String promptResult;
}
