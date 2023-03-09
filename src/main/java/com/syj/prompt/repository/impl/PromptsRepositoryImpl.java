package com.syj.prompt.repository.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.syj.prompt.entity.PromptsEntity;
import com.syj.prompt.mapper.IPromptsMapper;
import com.syj.prompt.repository.MPPromptsRepository;
import com.syj.prompt.util.OkHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2021-03-07
 */
@Service
@Slf4j
public class PromptsRepositoryImpl extends ServiceImpl<IPromptsMapper, PromptsEntity> implements MPPromptsRepository {

    /**
     * 发送钉钉消息
     *
     * @param promptId
     */
    @Override
    @Async
    public void sendDingdingMsg(Long promptId) {
        PromptsEntity promptsEntity = this.getById(promptId);

        // 使用OKHttp发送钉钉消息
        String url = "https://oapi.dingtalk.com/robot/send?access_token=fb863a77b629b890827ed3b5f98aec6add550176e98faf94de5a8724873cd498";
        String prompt = promptsEntity.getPrompt();
        if (prompt.length() > 42) {
            prompt = prompt.substring(0, 42);
        }
        StringBuilder sb = new StringBuilder("### 【").append(prompt + "】 ### \n\n");
        sb.append("> 点击查看【").append("http://www.yxt.com?promptId=" + promptId).append("】\n\n");
        Map<String, Object> markdownMap = new HashMap<>();
        markdownMap.put("title", "chatgpt来消息啦");
        markdownMap.put("text", sb.toString());


        Map<String, Object> map = new HashMap<>();
        map.put("msgtype", "markdown");
        map.put("markdown", markdownMap);
        // fastjson map集合转json字符串
        String jsonStr = JSON.toJSONString(map);
        String result = OkHttpUtil.postJsonParams(url, jsonStr);
        log.info("chagpt钉钉消息发送结果：" + result);
    }
}
