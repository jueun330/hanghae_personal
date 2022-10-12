package com.sparta.memberpost;

import com.sparta.memberpost.domain.member.MemberController;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;

import static javax.swing.UIManager.get;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


//Mockito의 Mock 객체를 사용하기 위한 어노테이션으로 Test class 위에 작성
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MemberPostApplicationTests {

    @Test
    void contextLoads() {
    }

    //@Mock 객체를 주입할 주체 객체로 선언
    @InjectMocks
    private MemberController memberController;

    private MockMvc mvc;

    @BeforeEach
    void initEach() {
        this.mvc = standaloneSetup(memberController).addFilter(new CharacterEncodingFilter("UTF-8", true)).build();
    }

    @Test
    @Order(0)
    @DisplayName("테스트 정상 시작 알림")
    public void startTest() {
        System.out.println("Test 실행");
    }

    @Nested
    @DisplayName("메서드 : Post , URI : /user/login")
    class PostUserLoginTest {

        @Test
        @Order(1)
        @DisplayName("Case : Red")
        public void getHttpStatusOkTestCaseRed() throws Exception {

            MvcResult mvcResult = mvc.perform(post("/signup"))
                    .andExpect((ResultMatcher) content().contentType(MediaType.APPLICATION_JSON_UTF8))
                    .andDo(print())
//                    .andExpect(jsonPath("statusCode", "999").exists())
//                    .andExpect(jsonPath("statusMsg", "알수없는 서버 내부 에러 발생 , dladlsgur3334@gmail.com 으로 연락 부탁드립니다.").exists())
                    .andExpect(status().isInternalServerError())
                    .andReturn();

            MockHttpServletResponse response = mvcResult.getResponse();
            System.out.printf("response = ", response.getContentAsString());
        }
    }
}
