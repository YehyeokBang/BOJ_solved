import java.io.*;
import java.util.Stack;

// 후위 표기식2
public class BOJ_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 피연산자의 개수 입력
        int N = Integer.parseInt(br.readLine());

        // 후위 표기식 입력
        String[] input = br.readLine().split("");

        // 피연산자 입력
        Double[] operand = new Double[N];
        for(int i = 0; i < N; i++) {
            operand[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < input.length; i++) {
            // 연산자인 경우
            if(input[i].equals("+") || input[i].equals("-") || input[i].equals("*") || input[i].equals("/")) {
                double op2 = stack.pop();
                double op1 = stack.pop();

                if(input[i].equals("+")) {
                    stack.add(op1 + op2);
                }
                if(input[i].equals("-")) {
                    stack.add(op1 - op2);
                }
                if(input[i].equals("*")) {
                    stack.add(op1 * op2);
                }
                if(input[i].equals("/")) {
                    stack.add(op1 / op2);
                }
            }
            // 피연산자인 경우
            else {
                char num = input[i].charAt(0);
                stack.add(operand[num-65]);
            }
        }

        // 출력
        bw.write(String.format("%.2f", stack.pop()));
        bw.close();
    }
}
