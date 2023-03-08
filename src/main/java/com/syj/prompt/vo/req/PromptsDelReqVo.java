package com.syj.prompt.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author syj@yxt.com
 * @since 2023/3/8 17:01
 */
@Data
public class PromptsDelReqVo {

    @ApiModelProperty(value = "提示语ID列表", required = true)
    private List<Long> promptIds;
}
