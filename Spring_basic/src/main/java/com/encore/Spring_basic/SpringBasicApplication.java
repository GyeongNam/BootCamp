package com.encore.Spring_basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/*
주로 서블릿 기반의 구성 요소를 스캔하고,
자동으로 등록하려면 아래 어노테이션 저장
webServlet, webFilter, webListener 등의 어노테이션 스캔
 */
@ServletComponentScan
@SpringBootApplication
public class SpringBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBasicApplication.class, args);
	}

}
