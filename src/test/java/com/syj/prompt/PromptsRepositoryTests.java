package com.syj.prompt;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.syj.prompt.entity.PromptsEntity;
import com.syj.prompt.repository.MPPromptsRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Erwin Feng
 * @since 2021-03-08
 */
@Component
@Slf4j
public class PromptsRepositoryTests extends MybatisPlusExampleApplicationTests {
    @Autowired
    private MPPromptsRepository mpPromptsRepository;

    @Test
    public void testQuery() {
        List<PromptsEntity> promptsEntityList = mpPromptsRepository.list();
        for (PromptsEntity promptsEntity : promptsEntityList) {
            log.info(promptsEntity.toString());
        }
    }

    @Test
    public void testUpdate() {
        LambdaQueryWrapper<PromptsEntity> goodsQueryWrapper = new LambdaQueryWrapper<PromptsEntity>().eq(PromptsEntity::getCreateUserName, "syj");
        List<PromptsEntity> promptsEntityList = mpPromptsRepository.list(goodsQueryWrapper);
        PromptsEntity promptsEntity = promptsEntityList.get(0);
        promptsEntity.setCreateUserName("ljj");
        mpPromptsRepository.updateById(promptsEntity);
    }

    @Test
    void testQueryTime() {
        LambdaQueryWrapper<PromptsEntity> queryWrapper = new LambdaQueryWrapper<PromptsEntity>()
                .lt(PromptsEntity::getCreateTime, LocalDateTime.parse("2021-04-08 10:00:00")) // where create_time < 2021-04-08 10:00:00
                .gt(PromptsEntity::getCreateTime, LocalDateTime.parse("2021-04-09 10:00:00")) // where create_time > 2021-04-09 10:00:00
                ;
        List<PromptsEntity> list = mpPromptsRepository.list(queryWrapper);
    }

}
