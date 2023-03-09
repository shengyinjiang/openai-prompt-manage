package com.syj.prompt.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author syj@yxt.com
 * @since 2023/3/8 17:01
 */
@Data
public class PromptsListReqVo extends AbstractReqVo{

    @ApiModelProperty(value = "提示语ID")
    private Long promptId;
    
    @ApiModelProperty(value = "创建人ID")
    private String createUserId;

    @ApiModelProperty(value = "创建人")
    private String createUserName;
    
    @ApiModelProperty(value = "0:待识别 1:识别中 2:识别结束 3:识别失败")
    private Integer promptStatus;
    
    @ApiModelProperty(value = "是否需要更新状态 0:否 1:是", required = true)
    private Integer needUpdateStatus = 0;

}
