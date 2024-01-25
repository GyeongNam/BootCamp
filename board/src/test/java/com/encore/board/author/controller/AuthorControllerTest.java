package com.encore.board.author.controller;

import com.encore.board.author.dto.AuthorDetailResDto;
import com.encore.board.author.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;

/*
 @WebMvcTest(AuthorController.class)
 를 이용하여 Controller 계층을 테스트을 테스트 모든 스프링 빈을 생성하고 주입하지는 않는다.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    public AuthorService authorService;

    @Test
//    @WithMockUser security 의존성 추가 필요
    void authorDetailTest() throws Exception {

        AuthorDetailResDto authorDetailResDto = new AuthorDetailResDto();
        authorDetailResDto.setName("test");
        authorDetailResDto.setEmail("test@naver.com");
        authorDetailResDto.setEmail("sadqwexdq");


        Mockito.when(authorService.findAuthorDetail(1L)).thenReturn(authorDetailResDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/author/30/circle/dto"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.name",authorDetailResDto.getName()));
    }
}
