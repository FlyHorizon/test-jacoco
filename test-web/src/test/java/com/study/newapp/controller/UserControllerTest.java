package com.study.newapp.controller;

import com.study.newapp.client.UserClient;
import com.study.newapp.model.pojo.UserInfoCom;
import com.study.newapp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Mock
    private UserClient userClient;

    @Test
    void testGetUserInfo() {
        UserInfoCom mockUser = new UserInfoCom();
        mockUser.setUserId(1);
        mockUser.setUsrName("TestUser");

        when(userService.getUserInfo(1)).thenReturn(mockUser);

        UserInfoCom result = userController.getUserInfo(1);

        assertNotNull(result);
        assertEquals(1, result.getUserId());
        assertEquals("TestUser", result.getUsrName());
        verify(userService, times(1)).getUserInfo(1);
    }

    @Test
    void testGetUserName() {
        when(userService.getUserName(1)).thenReturn("Admin");
        when(userService.getUserName(2)).thenReturn("Guest");
        when(userService.getUserName(99)).thenReturn("User_99");

        assertEquals("Admin", userController.getUserName(1));
        assertEquals("Guest", userController.getUserName(2));
        assertEquals("User_99", userController.getUserName(99));
    }

    @Test
    void testValidateUser_Valid() {
        when(userService.validateUser(1, "admin")).thenReturn(true);

        boolean result = userController.validateUser(1, "admin");

        assertTrue(result);
        verify(userService, times(1)).validateUser(1, "admin");
    }

    @Test
    void testValidateUser_Invalid() {
        when(userService.validateUser(null, "admin")).thenReturn(false);
        when(userService.validateUser(-1, "admin")).thenReturn(false);
        when(userService.validateUser(1, "")).thenReturn(false);

        assertFalse(userController.validateUser(null, "admin"));
        assertFalse(userController.validateUser(-1, "admin"));
        assertFalse(userController.validateUser(1, ""));
    }

    @Test
    void testCalculateScore() {
        when(userService.calculateScore(80, 90, 70)).thenReturn(80);

        int result = userController.calculateScore(80, 90, 70);

        assertEquals(80, result);
        verify(userService, times(1)).calculateScore(80, 90, 70);
    }

    @Test
    void testCommitOne_Id1() {
        UserInfoCom mockUser = new UserInfoCom();
        mockUser.setUserId(1);

        when(userClient.getUser(1)).thenReturn(mockUser);

        UserInfoCom result = userController.getUserInfoByFeignCommitOne(1);

        assertNotNull(result);
        assertEquals(1, result.getUserId());
        verify(userClient, times(1)).getUser(1);
    }

    @Test
    void testCommitOne_IdNot1() {
        UserInfoCom mockUser = new UserInfoCom();
        mockUser.setUserId(2);

        when(userClient.getUser(2)).thenReturn(mockUser);

        UserInfoCom result = userController.getUserInfoByFeignCommitOne(2);

        assertNotNull(result);
        assertEquals(2, result.getUserId());
        verify(userClient, times(1)).getUser(2);
    }

    @Test
    void testCommitTwo_Id12() {
        UserInfoCom mockUser = new UserInfoCom();
        mockUser.setUserId(1);

        when(userClient.getUser(1)).thenReturn(mockUser);
        when(userClient.getUser(2)).thenReturn(mockUser);

        UserInfoCom result1 = userController.getUserInfoByFeignCommitTwo(1);
        UserInfoCom result2 = userController.getUserInfoByFeignCommitTwo(2);

        assertNotNull(result1);
        assertNotNull(result2);
        verify(userClient, times(1)).getUser(1);
        verify(userClient, times(1)).getUser(2);
    }

    @Test
    void testCommitTwo_IdOther() {
        UserInfoCom mockUser = new UserInfoCom();
        mockUser.setUserId(99);

        when(userClient.getUser(99)).thenReturn(mockUser);

        UserInfoCom result = userController.getUserInfoByFeignCommitTwo(99);

        assertNotNull(result);
        assertEquals(99, result.getUserId());
        verify(userClient, times(1)).getUser(99);
    }
}
