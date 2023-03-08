package com.syj.prompt.repository.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syj.prompt.entity.PromptsEntity;
import com.syj.prompt.mapper.IPromptsMapper;
import com.syj.prompt.repository.MPPromptsRepository;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-03-07
 */
@Service
public class PromptsRepositoryImpl extends ServiceImpl<IPromptsMapper, PromptsEntity> implements MPPromptsRepository {

}
