import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the calculator! ");
        while (true) {
            System.out.println("Enter the formula or type the 'exit' to quit: ");
            //检查是否退出
            if (in.hasNext("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            String input = in.nextLine();
            String[] parts = input.split(" ");
            int result=0;
            if (parts.length != 3)//判断格式是否符合标准
            {
                System.out.println("Invalid format.");
            }

            //读取字符串并拆分
            else {
                try {
                    int a = Integer.parseInt(parts[0]);//得到操作数
                    String operator = parts[1];//得到操作符
                    int b = Integer.parseInt(parts[2]);//得到操作数


                    switch (operator) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        case "/":
                                result = a / b;
                            break;

                        default:
                            System.out.println("Error: Invalid operator.");//不符合预期的运算符
                            continue;
                    }

                    System.out.println("= " + result);
                }
                catch (NumberFormatException a)
                {
                    System.out.println("Error: Invalid number format.");//字符串转换到数字时
                    // 不符合数字格式
                }
                catch (ArithmeticException e)
                {
                    System.out.println("Error: Division by zero is invalid.");//处理运算异常例如：a/0
                }
            }
        }
        in.close();
    }
}
