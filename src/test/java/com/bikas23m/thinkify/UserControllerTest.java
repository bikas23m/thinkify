package com.bikas23m.thinkify;

import com.bikas23m.thinkify.controller.UserController;
import com.bikas23m.thinkify.entity.User;
import com.bikas23m.thinkify.service.UserService;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void saveUser_validUser_returnsCreatedMessage() {
        // Create a valid User object
        User user = new User("Abhishek",'M', 22);

        // Mock UserService behavior
        Mockito.when(userService.createUser(user)).thenReturn(user);

        // Call the controller method
        ResponseEntity<User> response = userController.saveUser(user);

        // Verify response and service call
        Assertions.assertThat(response.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        Assertions.assertThat(response.getBody())
                        .isEqualTo(user);
        Mockito.verify(userService).createUser(user);
    }
}
