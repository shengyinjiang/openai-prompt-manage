package com.syj.prompt.repository;

import com.syj.prompt.entity.PromptsEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-03-07
 */
public interface MPPromptsRepository extends IService<PromptsEntity> {

    void sendDingdingMsg(Long promptId);
}
