package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordValidatorTest {

    EmployeeTaskManagementSystem system = new EmployeeTaskManagementSystem();

    @Test
    public void testPasswordValid() {// PASSED
        //Positive test case, entering valid password is tested
        String validPassword = "Valid1@Password";
        boolean result = system.isPasswordValid(validPassword);
        assertTrue(result, "The password should be valid");
    }

    @Test
    public void testPasswordInvalid() { //PASSED
        //Negative test case, entering invalid password is tested
        String invalidPassword = "invalidpassword";
        boolean result = system.isPasswordValid(invalidPassword);
        assertFalse(result, "The password should be invalid because it does not contain uppercase, digit, or special character");
    }
}