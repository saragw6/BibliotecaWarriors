package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {

    public User testUser;
    @Before
    public void setup (){
        testUser = new User("Joe Smith", "was@sad.xon", "123-231-2341", "1234");

    }
    @Test
    public void EmailTest(){
        assertTrue(testUser.setEmail("was2@dsa.com"));
        assertFalse(testUser.setEmail("was2@.com"));



    }

    @Test
    public void PhoneTest(){
        assertFalse(testUser.setPhone("92-123-0912"));
    }

    @Test
    public void CheckPasswordTest(){
        Boolean incorrectPassword = testUser.checkPassword("1233");
        assertFalse(incorrectPassword);
    }

    @Test
    public void LibraryID(){
        testUser.setLibraryID("124-678-0987");
        assertNotEquals(testUser.getLibraryID(), "322-093-1029");
    }

    @Test
    public void Name(){
        assertNotEquals(testUser.getName(), "Mina Loy");
    }



}
