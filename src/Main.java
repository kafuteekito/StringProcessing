public class Main {
    public static void main(String[] args) {
        // Testing the isStrongPassword method with 5 different passwords
        System.out.println("\n5 examples of Strong password method");
        StringProcessor.isStrongPassword("emaiL!@12");  // Weak: lacks a digit
        StringProcessor.isStrongPassword("123xDwow");    // Weak: lacks an uppercase letter and special character
        StringProcessor.isStrongPassword("dR6sjt0eMo6zkX4R");  // Strong: meets all criteria
        StringProcessor.isStrongPassword("QTX,LrYyMv!sRIR2"); // Strong: meets all criteria
        StringProcessor.isStrongPassword("-w!920l");      // Weak: lacks an uppercase letter

        // Testing the calculateDigits method with sentences containing numbers
        System.out.println("\n5 examples of calculate digits method");
        StringProcessor.calculateDigits("-w!920"); // Contains 3 digits
        StringProcessor.calculateDigits("IPv4 addresses are 32-bit numbers"); // Contains 2 digits
        StringProcessor.calculateDigits("s9IZc1fa408xrXb3"); // Contains 5 digits
        StringProcessor.calculateDigits("012345 + 6789"); // Contains 10 digits
        StringProcessor.calculateDigits("t99a3plk"); // Contains 3 digits

        // Testing the calculateWords method with different sentences
        System.out.println("\n5 examples of calculate words method");
        StringProcessor.calculateWords("The secret code they created made no sense, even to them."); // 15 words
        StringProcessor.calculateWords("Separation anxiety is what happens when you can't find your phone."); // 15 words
        StringProcessor.calculateWords("He found the end of the rainbow and was surprised at what he found there."); // 17 words
        StringProcessor.calculateWords("Wow!"); // 1 word
        StringProcessor.calculateWords("Cats are good pets, for they are clean and are not noisy."); // 14 words

        // Testing the calculateExpression method with arithmetic expressions
        System.out.println("\n5 examples of calculate expression method");
        System.out.println(StringProcessor.calculateExpression("11-1+23*2")); // Expected: 57
        System.out.println(StringProcessor.calculateExpression("11-(1+2)/3*2")); // Expected: 10.333...
        System.out.println(StringProcessor.calculateExpression("5-6")); // Expected: -1
        System.out.println(StringProcessor.calculateExpression("100-50+2+3+10+2")); // Expected: 67
        System.out.println(StringProcessor.calculateExpression("10-((10*3)/5+2)")); // Expected: 4
    }
}