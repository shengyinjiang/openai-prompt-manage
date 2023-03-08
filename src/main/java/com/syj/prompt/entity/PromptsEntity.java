package com.syj.prompt.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.syj.prompt.entity.enums.PromptStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author syj
 * @since 2023-03-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("prompts")
public class PromptsEntity extends Model<PromptsEntity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 提示语
     */
    @TableField("prompt")
    private String prompt;

    /**
     * 创建人
     */
    @TableField(value = "create_user_id")
    private String createUserId;

    /**
     * 创建人
     */
    @TableField(value = "create_user_name")
    private String createUserName;

    /**
     * 0:待识别 1:识别中 2:识别结束 3:识别失败
     */
    @TableField("prompt_status")
    private PromptStatusEnum promptStatus;

    /**
     * 识别结果
     */
    @TableField(value = "prompt_result")
    private String promptResult;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    /**
     * 0未删除，1已删除，默认0
     */
    private Integer deleted;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
