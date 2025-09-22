import java.util.*;

public class InfixPostfixEvaluator {

    private static int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
    }

    private static boolean isOperator(String token) { //mengemblikan true apabila operator matematika -+*/
        return "+-*/".contains(token);
    }

    public static String toPostfix(String infix) {
        Stack<String> operatorStack = new Stack<>();
        StringBuilder output = new StringBuilder();
        String[] tokens = infix.trim().split("\\s+");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                output.append(token).append(" ");
            } else if (isOperator(token)) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                    output.append(operatorStack.pop()).append(" ");
                }
                operatorStack.push(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    output.append(operatorStack.pop()).append(" ");
                }
                operatorStack.pop();
            }
        }

        while (!operatorStack.isEmpty()) {
            output.append(operatorStack.pop()).append(" ");
        }

        return output.toString().trim();
    }
    public static int evaluatePostfix(String postfix) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.matches("\\d+")) {
                stack.push(Integer.parseInt(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> 0;
                };
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Masukkan ekspresi infix (gunakan spasi antar elemen, contoh: 3 + 4 * 2 / ( 1 - 5 )):");
        String infix = scanner.nextLine();

        String postfix = toPostfix(infix);
        int result = evaluatePostfix(postfix);

        System.out.println("Postfix: " + postfix);
        System.out.println("Hasil Evaluasi: " + result);
    }
}
