package org.example;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class IsOkTest {
    @Test
    public void isOKPositive() { // this takes too long - SHOULD BE FIXED
        Manager manager = new Manager("1", "Manager", "manager@office.com","123",  "Manager");
        boolean result = manager.isOk(1);

        assertEquals(true, result);

    }

    @Test
    public void isOKNegative() { // this takes too long - SHOULD BE FIXED
        Manager manager = new Manager("1", "Manager", "manager@office.com","123",  "Manager");
        boolean result = manager.isOk(2);

        assertNotEquals(false, result);
    }

}
