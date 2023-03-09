package com.syj.prompt.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author syj
 * @since 2023/3/8 17:01
 */
@Data
public class PromptsAddReqVo {

    @ApiModelProperty(value = "创建人ID", required = true)
    private String createUserId;
    
    @ApiModelProperty(value = "创建人", required = true)
    private String createUserName;

    @ApiModelProperty(value = "提示语列表", required = true)
    private List<String> prompts;
}
