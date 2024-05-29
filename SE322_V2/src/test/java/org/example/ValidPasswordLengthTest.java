package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidPasswordLengthTest {

    EmployeeTaskManagementSystem system = new EmployeeTaskManagementSystem();

    @Test
    public void testPasswordValidWithMinimumLength() { // PASSED
        //Positive test case
        String validPassword = "Val1@P";
        boolean result = system.isPasswordValid(validPassword);
        assertTrue(result, "The password should be valid as it meets the minimum length requirement");
    }

    @Test
    public void testPasswordInvalidTooShort() {
        //Negative test case
        String invalidPassword = "Va1@";
        boolean result = system.isPasswordValid(invalidPassword);
        assertFalse(result, "The password should be invalid because it is too short");
    }

}
