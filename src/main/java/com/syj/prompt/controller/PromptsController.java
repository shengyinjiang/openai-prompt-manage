package com.syj.prompt.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.syj.prompt.entity.PromptsEntity;
import com.syj.prompt.entity.enums.PromptStatusEnum;
import com.syj.prompt.repository.MPPromptsRepository;
import com.syj.prompt.vo.req.PromptsAddReqVo;
import com.syj.prompt.vo.req.PromptsDelReqVo;
import com.syj.prompt.vo.req.PromptsListReqVo;
import com.syj.prompt.vo.req.PromptsUpdateVo;
import com.syj.prompt.vo.res.PromptsListResVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * opai提示语管理控制类
 *
 * @author syj@yxt.com
 * @since 2023/3/8 16:56
 */
@RestController
@RequestMapping("/prompts")
@Api(value = "prompts相关管理接口", tags = {"prompts相关管理接口"})
@Slf4j
public class PromptsController {

    @Autowired
    private MPPromptsRepository mpPromptsRepository;


    @PutMapping("/add")
    @ApiOperation(value = "添加chatgpt指令", notes = "添加chatgpt指令")
    @ResponseStatus(HttpStatus.OK)
    public void addPrompt(@RequestBody PromptsAddReqVo reqVo) {
        List<PromptsEntity> entities = new ArrayList<>();
        if (reqVo.getPrompts() != null) {
            for (String prompt : reqVo.getPrompts()) {
                PromptsEntity entity = new PromptsEntity();
                entity.setPrompt(prompt);
                entity.setCreateUserId(reqVo.getCreateUserId());
                entity.setCreateUserName(reqVo.getCreateUserName());
                entity.setPromptStatus(PromptStatusEnum.PENDING);
                entities.add(entity);
            }
        }
        if (!CollectionUtils.isEmpty(entities)) {
            mpPromptsRepository.saveBatch(entities);
        }
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除chatgpt指令", notes = "删除chatgpt指令")
    @ResponseStatus(HttpStatus.OK)
    public void deletePrompt(@RequestBody PromptsDelReqVo reqVo) {
        List<PromptsEntity> entities = new ArrayList<>();
        if (reqVo.getPromptIds() != null) {
            for (Long promptId : reqVo.getPromptIds()) {
                PromptsEntity entity = new PromptsEntity();
                entity.setId(promptId);
                entity.setDeleted(1);
                mpPromptsRepository.updateById(entity);
            }
        }
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新chatgpt指令结果", notes = "更新chatgpt指令结果")
    @ResponseStatus(HttpStatus.OK)
    public void updatePrompt(@RequestBody PromptsUpdateVo reqVo) {
        List<PromptsEntity> entities = new ArrayList<>();
        if (reqVo.getPromptId() != null) {
            PromptsEntity entity = new PromptsEntity();
            entity.setId(reqVo.getPromptId());
            entity.setPromptResult(reqVo.getPromptResult());
            entity.setPromptStatus(PromptStatusEnum.COMPLETED);
            mpPromptsRepository.updateById(entity);
            
            mpPromptsRepository.sendDingdingMsg(reqVo.getPromptId());
        }
    }

    @PostMapping("/list")
    @ApiOperation(value = "分页获取chatgpt指令列表", notes = "分页获取chatgpt指令列表")
    @ResponseStatus(HttpStatus.OK)
    public Page<PromptsListResVo> listPrompt(@RequestBody PromptsListReqVo reqVo) {
        Page<PromptsEntity> pageable = new Page<>(reqVo.getCurrent(), reqVo.getLimit(), true);
        LambdaQueryWrapper<PromptsEntity> queryWrapper = Wrappers.lambdaQuery(PromptsEntity.class);
        if (StringUtils.hasText(reqVo.getCreateUserId())) {
            queryWrapper.eq(PromptsEntity::getCreateUserId, reqVo.getCreateUserId());
        }
        if (StringUtils.hasText(reqVo.getCreateUserName())) {
            queryWrapper.eq(PromptsEntity::getCreateUserName, reqVo.getCreateUserName());
        }
        if (reqVo.getPromptStatus() != null) {
            queryWrapper.eq(PromptsEntity::getPromptStatus, PromptStatusEnum.match(reqVo.getPromptStatus()));
        }
        if (reqVo.getPromptId() != null) {
            queryWrapper.eq(PromptsEntity::getId, reqVo.getPromptId());
        }
        queryWrapper.eq(PromptsEntity::getDeleted, 0);
        Page<PromptsEntity> page = mpPromptsRepository.page(pageable, queryWrapper);
        Page<PromptsListResVo> result = new Page<>();
        result.setTotal(page.getTotal()).setSize(page.getSize()).setPages(page.getPages()).setCurrent(page.getCurrent())
                .setRecords(page.getRecords().stream().map(l -> {
                    PromptsListResVo vo = new PromptsListResVo();
                    BeanUtils.copyProperties(l, vo);
                    return vo;
                }).collect(Collectors.toList()));
        
        if (page.getRecords() != null && reqVo.getNeedUpdateStatus() == 1) {
            for (PromptsEntity entity : page.getRecords()) {
                entity.setPromptStatus(PromptStatusEnum.PROCESSING);
                entity.setUpdateTime(LocalDateTime.now());
            }
            mpPromptsRepository.saveOrUpdateBatch(page.getRecords());
        }
        return result;
    }

    @GetMapping("/detail")
    @ApiOperation(value = "获取chatgpt指令详情", notes = "获取chatgpt指令详情")
    @ResponseStatus(HttpStatus.OK)
    public PromptsListResVo detail(@RequestParam(name = "promptId") Long promptId) {
        PromptsEntity entity =  mpPromptsRepository.getById(promptId);
        PromptsListResVo vo = new PromptsListResVo();
        BeanUtils.copyProperties(entity, vo);
        
        return vo;
    }

}
