package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordCharacterTest {

    EmployeeTaskManagementSystem system = new EmployeeTaskManagementSystem();

    @Test
    public void testPasswordValidWithOnlySpecialCharactersAsSpecialChar() { // PASSED
        //Positive test case
        String validPassword = "V@lid1@Passw0rd!";
        boolean result = system.isPasswordValid(validPassword);
        assertTrue(result, "The password should be valid");
    }

    @Test
    public void testPasswordInvalidWithOnlySpecialCharacters() { // PASSED
        //Negative test case
        String invalidPassword = "@@@@@@";
        boolean result = system.isPasswordValid(invalidPassword);
        assertFalse(result, "The password should be invalid because it only contains special characters");
    }
}
