package com.study.newapp.service;

import com.study.newapp.model.pojo.UserInfoCom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    void testGetUserInfo() {
        UserInfoCom result = userService.getUserInfo(1);

        assertNotNull(result);
        assertEquals(1, result.getUserId());
        assertEquals("User_1", result.getUsrName());
    }

    @Test
    void testGetUserName_Id1() {
        assertEquals("Admin", userService.getUserName(1));
    }

    @Test
    void testGetUserName_Id2() {
        assertEquals("Guest", userService.getUserName(2));
    }

    @Test
    void testGetUserName_IdOther() {
        assertEquals("User_99", userService.getUserName(99));
    }

    @Test
    void testGetUserName_NullId() {
        assertEquals("Invalid ID", userService.getUserName(null));
    }

    @Test
    void testGetUserName_NegativeId() {
        assertEquals("Invalid ID", userService.getUserName(-1));
    }

    @Test
    void testValidateUser_Valid() {
        assertTrue(userService.validateUser(1, "admin"));
        assertTrue(userService.validateUser(100, "user"));
    }

    @Test
    void testValidateUser_NullId() {
        assertFalse(userService.validateUser(null, "admin"));
    }

    @Test
    void testValidateUser_NullName() {
        assertFalse(userService.validateUser(1, null));
    }

    @Test
    void testValidateUser_NegativeId() {
        assertFalse(userService.validateUser(-1, "admin"));
    }

    @Test
    void testValidateUser_EmptyName() {
        assertFalse(userService.validateUser(1, ""));
    }

    @Test
    void testCalculateScore_ThreeScores() {
        assertEquals(80, userService.calculateScore(80, 90, 70));
    }

    @Test
    void testCalculateScore_OneScore() {
        assertEquals(85, userService.calculateScore(85));
    }

    @Test
    void testCalculateScore_ZeroScores() {
        assertEquals(0, userService.calculateScore(0, 0, 0));
    }

    @Test
    void testCalculateScore_Null() {
        assertEquals(0, userService.calculateScore(null));
    }
}
