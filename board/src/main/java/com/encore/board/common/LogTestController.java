package com.encore.board.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


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

    @GetMapping("userinfo/test")
    public String userinfoTest(HttpServletRequest request){

        String email1 = request.getSession().getAttribute("email").toString();

        SecurityContext securityContext = (SecurityContext) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        String email2 = securityContext.getAuthentication().getName();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email3 = authentication.getName();

        log.info("email : "+ email1);
        log.info("email : "+ email2);
        log.info("email : "+ email3);

        return null;
    }
}
