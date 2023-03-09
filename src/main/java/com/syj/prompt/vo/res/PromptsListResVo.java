package com.syj.prompt.vo.res;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.syj.prompt.entity.enums.PromptStatusEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author syj
 * @since 2023/3/8 17:36
 */
@Data
public class PromptsListResVo {


    @ApiModelProperty(value = "主键ID")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;


    @ApiModelProperty(value = "提示语")
    private String prompt;


    @ApiModelProperty(value = "创建人ID")
    private String createUserId;

    @ApiModelProperty(value = "创建人")
    private String createUserName;


    @ApiModelProperty(value = "状态描述 0:待识别 1:识别中 2:识别结束 3:识别失败")
    private PromptStatusEnum promptStatus;

    @ApiModelProperty(value = "chagpt识别结果")
    private String promptResult;


    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;


    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}
