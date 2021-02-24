package com.lemon.silence.common.exception;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson.JSON;
import com.lemon.silence.common.dto.ResponseMessageEntity;
import com.lemon.silence.common.dto.ResponseMessageUntils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * spring-cloud-alibaba-sentinel限流异常统一处理信息信息
 *
 * @author zhangxueqi
 * @version 1.0
 * @date 2020/10/20 11:18
 */
@Slf4j
public final class SentinelBlockExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        response.setStatus(200);
        response.setContentType("application/json;charset=utf-8");
        String message;
        if (e instanceof FlowException) {
            message = "限流异常";
        } else if (e instanceof DegradeException) {
            message = "触发降级规则";
        } else if (e instanceof ParamFlowException) {
            message = "触发热点参数规则";
        } else if (e instanceof SystemBlockException) {
            message = "触发系统规则";
        } else if (e instanceof AuthorityException) {
            message = "触发授权规则";
        } else {
            message = "触发其他规则";
        }
        response.getWriter().write(HtmlUtils.htmlEscape(JSON.toJSONString(ResponseMessageUntils.fail(message)), "UTF-8"));
    }

    public static ResponseMessageEntity sentinelExceptionHandler(BlockException e) {
        log.info("Fail to {}", e.getClass().getCanonicalName());
        return ResponseMessageUntils.fail();
    }

}
