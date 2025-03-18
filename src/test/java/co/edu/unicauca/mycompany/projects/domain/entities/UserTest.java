/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package co.edu.unicauca.mycompany.projects.domain.entities;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author spart
 */
public class UserTest {
    
    public UserTest(){
        
    }
    
    @Test
    void testCompanyConstructorAndGetters() {
        User userTest = new User("1234", "example@example.com", "password");
        
        assertThat(userTest.getUserId()).isEqualTo("1234");
        assertThat(userTest.getUserEmail()).isEqualTo("example@example.com");
        assertThat(userTest.getUserPassword()).isEqualTo("password");

    }

    @Test
    void testSetters() {
        User user = new User("", "", "");

        user.setUserId("123456");
        user.setUserEmail("user@example.com");
        user.setUserPassword("securepassword");

        assertThat(user.getUserId()).isEqualTo("123456");
        assertThat(user.getUserEmail()).isEqualTo("user@example.com");
        assertThat(user.getUserPassword()).isEqualTo("securepassword");
    }
}
