package com.syj.prompt.entity.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import lombok.Getter;

/**
 * @author syj
 * @since 2023-03-08
 */
@Getter
public enum PromptStatusEnum implements IEnum<Integer> {
    PENDING(0, "待识别"),
    PROCESSING(1, "识别中"),
    COMPLETED(2, "识别成功"),
    FAILED(3, "识别失败"),
    ;

    private final Integer value;

    private final String desc;

    PromptStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
