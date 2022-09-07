package com.example.demofinaltemp.controller;

import com.example.demofinaltemp.config.GlobalExceptionHandler;
import com.example.demofinaltemp.enums.UserErrorResult;
import com.example.demofinaltemp.exception.UserException;
import com.example.demofinaltemp.service.UserService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureRestDocs
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    public static final String LOGIN_ID = "userId";
    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;
    private Gson gson;
    private MockMvc mockMvc;

    @BeforeEach
    void init(){
        gson = new Gson();
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();

    }

    @Test
    @DisplayName("아이디 체크 시 중복되는 아이디가 있는 경우 409 CONFLICT")
    void if_duplicated_then_throw() throws Exception {
        //given

        doThrow(new UserException(UserErrorResult.DUPLICATE_USER_ID)).when(userService).duplicateCheck(LOGIN_ID);
        final String url = "/valid-id";

        //when
        final ResultActions resultActions = mockMvc.perform(
                get(url)
                .contentType(APPLICATION_JSON)
                .content(LOGIN_ID)
        );

        //then
        resultActions
                .andExpect(status().isConflict())
                .andExpect(jsonPath("code", is(UserErrorResult.DUPLICATE_USER_ID.getName())))
                .andExpect(jsonPath("message", is(UserErrorResult.DUPLICATE_USER_ID.getMessage())));

    }
    
    @Test
    @DisplayName("아이디 체크 시 중복되는 아이디가 없으면 201 CREATED")
    void id_non_duplicated_then_created() throws Exception {
        //given
        final String url = "/valid-id";
        doNothing().when(userService).duplicateCheck(any(String.class));

        //when
        ResultActions resultActions = mockMvc.perform(get(url)
                .contentType(APPLICATION_JSON)
                .content(LOGIN_ID)
        );

        //then
        resultActions
                .andExpect(status().isCreated());
    }

}