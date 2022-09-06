package com.example.demofinaltemp.repository;

import com.example.demofinaltemp.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.Entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    @DisplayName("회원 저장 로직 성공 테스트")
    void save_success() {
        //given
        final User user = new User();

        //when
        User save = userRepository.save(user);

        //then
        assertNotNull(save);
        assertThat(save.getId()).isNotNull();
    }

}