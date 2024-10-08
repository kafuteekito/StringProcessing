import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class StringProcessor {

    // Method to check if a password is strong based on certain criteria
    public static boolean isStrongPassword(String password) {
        int n = password.length();
        boolean hasLower = false, hasUpper = false, hasDigit = false, specialChar = false;

        // Set of special characters that are valid for the password
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

        // Check each character in the password for the criteria
        for (char i : password.toCharArray()) {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }

        // Strength of password
        System.out.print("Strength of password " + password + " is: ");
        if (hasDigit && hasLower && hasUpper && specialChar && (n >= 8)) {
            System.out.println("Strong");
            return true;
        }
        System.out.println("Weak");
        return false;
    }

    // Method to count the number of digits in a given sentence
    public static int calculateDigits(String sentence) {
        int n = 0; // Counter for digits
        for (int i = 0; i < sentence.length(); i++) {
            // Check if the character is a digit (ASCII 48-57)
            if (sentence.charAt(i) >= 48 && sentence.charAt(i) <= 57)
                n++;
        }
        System.out.println("Total number of Digits in (" + sentence + ") = " + n);
        return n;
    }

    // Method to count the number of words in a given sentence
    public static int calculateWords(String sentence) {
        // Split the sentence by whitespace and count the resulting words
        int countWords = sentence.split("\\s").length;
        System.out.println("Total number of words in (" + sentence + ") = " + countWords);
        return countWords;
    }

    // Method to evaluate a mathematical expression represented as a string
    public static double calculateExpression(String expression) {
        char[] tokens = expression.toCharArray();

        // Stacks to store operands and operators
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();

        // Iterate through each character in the expression
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue; // Skip spaces

            // If the character is a digit or a decimal point, parse the number
            if ((tokens[i] >= '0' && tokens[i] <= '9') || tokens[i] == '.') {
                StringBuilder sb = new StringBuilder();
                // Collect digits and the decimal point
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sb.append(tokens[i]);
                    i++;
                }
                // Push the parsed number onto the values stack
                values.push(Double.parseDouble(sb.toString()));
                i--; // Adjust for the extra increment
            } else if (tokens[i] == '(') {
                // Push '(' onto the operators stack
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                // Pop and apply operators until '(' is encountered
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); // Pop the '('
            } else if (tokens[i] == '+' || tokens[i] == '-'
                    || tokens[i] == '*' || tokens[i] == '/') {
                // Pop and apply operators with higher precedence
                while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                // Push the current operator onto the operators stack
                operators.push(tokens[i]);
            }
        }

        // Process any remaining operators in the stack
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        // The result is the only remaining element in the values stack
        System.out.println("Expression: " + expression + " = " );
        return values.pop();
    }

    // Function to check if operator1 has higher precedence than operator2
    private static boolean hasPrecedence(char operator1, char operator2) {
        // '(' has the lowest precedence
        if (operator2 == '(' || operator2 == ')')
            return false;
        // Higher precedence for '*' and '/' than '+' and '-'
        return (operator1 != '*' && operator1 != '/') || (operator2 != '+' && operator2 != '-');
    }

    // Function to apply the operator to two operands
    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Cannot divide by zero");
                return a / b;
        }
        return 0;
    }
}