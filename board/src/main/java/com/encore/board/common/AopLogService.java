package com.encore.board.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class AopLogService {

    /*
    aop 에 대상이 되는 controller, service 등을 정의
    @Pointcut("execution(* com.encore.board..controller..*.*(..))")
     */

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    public void controllerPointCut(){

    }

    // 방식 1
//    @Before("controllerPointCut()")
//    public void beforeController(JoinPoint joinPoint){
//        log.info("Before Controller");
//        /*
//        메서드가 실행되기 전에 인증, 입력값 검증등을 수행하는 용도로 사용하는 사전단계
//         */
//        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//
//        /*
//        json 형태로 사용자의 요청을 조립하기 위한 로직
//         */
//        ObjectMapper objectMapper = new ObjectMapper();
//        ObjectNode objectNode = objectMapper.createObjectNode();
//        objectNode.put("Method Name",joinPoint.getSignature().getName());
//        objectNode.put("CRUD Name", httpServletRequest.getMethod());
//        Map<String, String[]> paramMap = httpServletRequest.getParameterMap();
//        ObjectNode objectNodeDetail = objectMapper.valueToTree(paramMap);
//        objectNode.set("user inputs", objectNodeDetail);
//        log.info("user request info" + objectNode);
//    }
//
//    @After("controllerPointCut()")
//    public void afterController(){
//        log.info("end Controller");
//    }


    // 방식 2
    @Around("controllerPointCut()")
    public Object controllerLogger(ProceedingJoinPoint proceedingJoinPoint){ // joinPoint 란 aop 대상으로 하는 컨트롤러의 특정 메서드를 의미

        // log.info("request method"+ proceedingJoinPoint.getSignature().toString());
        /*
        사용자의 요청값을 json 형태로 출력하기 위해 HttpServletRequest 객체를 꺼내는 로직
         */
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        /*
        json 형태로 사용자의 요청을 조립하기 위한 로직
         */
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("Method Name",proceedingJoinPoint.getSignature().getName());
        objectNode.put("CRUD Name", httpServletRequest.getMethod());
        Map<String, String[]> paramMap = httpServletRequest.getParameterMap();
        ObjectNode objectNodeDetail = objectMapper.valueToTree(paramMap);
        objectNode.set("user inputs", objectNodeDetail);
        log.info("user request info" + objectNode);


        try {
            return proceedingJoinPoint.proceed();
        }catch (Throwable e){
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
