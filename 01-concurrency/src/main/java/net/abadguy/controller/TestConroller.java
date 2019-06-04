package net.abadguy.controller;

import lombok.extern.slf4j.Slf4j;
import net.abadguy.example.thread.local.RequestHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName:
 * @Description:
 * @date: 2019/6/112:20
 */
@RestController
@Slf4j
public class TestConroller {

    @GetMapping("/test")
    public String test(){
        log.info("调用测试接口");
        return "test";
    }

    @GetMapping("/threadLocal/test")
    public Long test2(){
        return RequestHolder.getId();
    }

}
