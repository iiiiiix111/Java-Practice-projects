import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;

public class Cal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a, b, result;
        String operator;

        // 使用 Lambda 表达式存储操作符和对应的运算逻辑
        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (x, y) -> x + y);
        operations.put("-", (x, y) -> x - y);
        operations.put("*", (x, y) -> x * y);
        operations.put("/", (x, y) -> {
            if (y == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return x / y;
        });

        System.out.println("Welcome to the Calculator!");
        System.out.println("Enter formulas in the format: '2 + 3'. Type 'exit' to quit.");

        while (true) {
            System.out.print("Enter the formula: ");

            // 检测退出命令
            if (in.hasNext("exit")) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            // 检查输入格式
            if (in.hasNextInt()) {
                a = in.nextInt(); // 读取第一个数字
                if (in.hasNext()) {
                    operator = in.next(); // 读取操作符
                    if (in.hasNextInt()) {
                        {
                            b = in.nextInt(); // 读取第二个数字
                            in.nextLine();
                        }
                    } else {
                        System.out.println("Error: Second number is missing or invalid.");
                        in.nextLine(); // 清除当前行
                        continue;
                    }
                } else {
                    System.out.println("Error: Operator is missing.");
                    in.nextLine(); // 清除当前行
                    continue;
                }
            } else {
                System.out.println("Error: First number is missing or invalid.");
                in.nextLine(); // 清除当前行
                continue;
            }

            // 执行运算
            try {
                if (operations.containsKey(operator)) {
                    result = operations.get(operator).apply(a, b); // 使用 Lambda 执行运算
                    System.out.printf("Result: %d %s %d = %d%n", a, operator, b, result);
                } else {
                    System.out.println("Error: Invalid operator.");
                }
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}