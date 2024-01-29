package com.encore.board.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
@Slf4j 를 통해 logBack 로그라이브러리 사용가능
 */
@Slf4j
@RestController
public class LogTestController {
    /*
    @Slf4j를 사용하지 않고, 직접 라이브러리 import에 로거 생성가능
     */
    // private  static final Logger loger = LoggerFactory.getLogger("logger");

    @GetMapping("/log/test1")
    public String testMethod1(){
        log.debug("디버그 로그입니다.");
        log.info("인포 로그입니다.");
        log.error("에러 로그입니다.");
        return "ok";
    }
}
