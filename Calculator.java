import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Input:");
            String input = scanner.nextLine();
            int result = evaluateExpression(input);
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int evaluateExpression(String expression) throws Exception {
        String[] tokens = expression.split("\\s+");

        if (tokens.length != 3 && tokens.length != 5) {
            throw new IllegalArgumentException("Invalid number of operands and operators.");
        }

        int a = validateAndParse(tokens[0]);
        int b = validateAndParse(tokens[2]);
        int c = tokens.length == 5 ? validateAndParse(tokens[4]) : 0;

        char operator = tokens[1].charAt(0);
        switch (operator) {
            case '+':
                return a + b + c;
            case '-':
                return tokens.length == 3 ? a - b : a - b + c;
            case '*':
                return a * b - c;
            case '/':
                return a / b * c;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private static int validateAndParse(String token) throws Exception {
        int number = Integer.parseInt(token);
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Numbers must be between 1 and 10 inclusive.");
        }
        return number;
    }
}
