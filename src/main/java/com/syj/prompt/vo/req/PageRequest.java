package com.syj.prompt.vo.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author syj@yxt.com
 * @since 2023/3/8 17:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {
    private long current;
    private long size;
    private String orderBy;
    private String direction;
}
