package com.lemon.silence.test;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author silence
 */
@Slf4j
@RestController
@Api(tags = "新功能测试接口")
@RequestMapping(path = "/lemon/api/test")
public class TestController {

    @Autowired
    private TestService testService;
}
