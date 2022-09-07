package com.example.demofinaltemp.service;

import com.example.demofinaltemp.enums.UserErrorResult;
import com.example.demofinaltemp.exception.UserException;
import com.example.demofinaltemp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @InjectMocks
    UserServiceImpl userService;
    @Mock
    UserRepository userRepository;

    private final String name = "tester";
    private final String loginId = "testId";
    private final String password = "testPw";

    @BeforeEach
    void init(){

    }

    @Test
    @DisplayName("회원 가입 시 닉네임이 같으면 실패해야 한다.")
    void nickname_duplicated() {
        //given
        doReturn(true).when(userRepository).existsByLoginId(loginId);

        //when
        final UserException resultError = assertThrows(UserException.class,
                () -> userService.duplicateCheck(loginId));

        //then
        assertThat(resultError.getErrorResult()).isEqualTo(UserErrorResult.DUPLICATE_USER_ID);
    }

    @Test
    @DisplayName("회원 가입 시 중복되는 닉네임이 없으면 성공한다.")
    void nickname_not_duplicated() {
        //given
        doReturn(false).when(userRepository).existsByLoginId(loginId);

        //expected
        assertDoesNotThrow(() -> userService.duplicateCheck(loginId));

    }

}
