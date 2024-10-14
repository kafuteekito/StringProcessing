package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrPrTest
{
    @Test
    void test()
    {
        StringProcessor processor = new StringProcessor();
        // Testing the isStrongPassword method with 5 different passwords
        System.out.println("\n5 examples of Strong password method");
        assertTrue(StringProcessor.isStrongPassword("emaiL!@12"), "Weak password"); // Strong: meets all criteria
        assertFalse(StringProcessor.isStrongPassword("123xDwow"), "Weak password");    // Weak: lacks an uppercase letter and special character
        assertFalse(StringProcessor.isStrongPassword("dR6sjt0eMo6zkX4R"), "Weak password");  // Weak: lacks a special character
        assertTrue(StringProcessor.isStrongPassword("QTX,LrYyMv!sRIR2"), "Weak password"); // Strong: meets all criteria
        assertFalse(StringProcessor.isStrongPassword("-w!920l"), "Weak password"); // Weak: lacks an uppercase letter

        // Testing the calculateDigits method with sentences containing numbers
        System.out.println("\n5 examples of calculate digits method");
        assertEquals(3, StringProcessor.calculateDigits("-w!920"), "Wrong answer"); //Contains 3 digits
        assertEquals(3, StringProcessor.calculateDigits("IPv4 addresses are 32-bit numbers"), "Wrong answer"); // Contains 3 digits
        assertEquals(6, StringProcessor.calculateDigits("s9IZc1fa408xrXb3"),"Wrong answer"); // Contains 6 digits
        assertEquals(10, StringProcessor.calculateDigits("012345 + 6789"),"Wrong answer"); // Contains 10 digits
        assertEquals(3, StringProcessor.calculateDigits("t99a3plk"),"Wrong answer"); // Contains 3 digits

        // Testing the calculateWords method with different sentences
        System.out.println("\n5 examples of calculate words method");
        assertEquals(11, StringProcessor.calculateWords("The secret code they created made no sense, even to them."),"Wrong answer"); // 11 words
        assertEquals(11, StringProcessor.calculateWords("Separation anxiety is what happens when you can't find your phone."),"Wrong answer"); // 11 words
        assertEquals(15, StringProcessor.calculateWords("He found the end of the rainbow and was surprised at what he found there."), "Wrong answer"); // 15 words
        assertEquals(1, StringProcessor.calculateWords("Wow!"),"Wrong answer"); // 1 word
        assertEquals(12, StringProcessor.calculateWords("Cats are good pets, for they are clean and are not noisy."), "Wrong answer"); // 12 words

        // Testing the calculateExpression method with arithmetic expressions
        System.out.println("\n5 examples of calculate expression method");
        assertEquals(56.0, StringProcessor.calculateExpression("11-1+23*2"), "Wrong answer"); // Expected: 56
        assertEquals(9.0, StringProcessor.calculateExpression("11-(1+2)/3*2"), "Wrong answer"); // Expected: 9
        assertEquals(-1.0, StringProcessor.calculateExpression("5-6"), "Wrong answer"); // Expected: -1
        assertEquals(13.4, StringProcessor.calculateExpression("(100-50+2+3+10+2)/5"), "Wrong answer"); // Expected: 13.4
        assertEquals(2.0, StringProcessor.calculateExpression("10-((10*3)/5+2)"), "Wrong answer"); // Expected: 2
    }


}
