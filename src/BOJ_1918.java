import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위 표기식
public class BOJ_1918 {
    public static void main(String[] args) throws IOException {
        // 중위 표기식 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String infix = br.readLine();

        // 후위 표기식 출력
        System.out.println(infixToPostfix(infix));
    }

    // 중위 표기식 -> 후위 표기식
    static String infixToPostfix(String infix) {
        // 후위 표기식 저장할 StringBuilder 객체
        StringBuilder postfix = new StringBuilder();
        // 연산자 저장할 Stack 객체
        Stack<Character> stack = new Stack<>();

        // 중위 표기식 문자를 하나씩 읽어서 처리
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // 알파벳이면 후위 표기식에 바로 추가
            // 여는 괄호면 스택에 추가
            // 닫는 괄호면 여는 괄호가 나올 때까지 스택에서 pop
            // 연산자면 스택에서 우선순위가 높거나 같은 연산자가 나올 때까지 pop
            // 스택이 비어있으면 연산자 push
            if (Character.isAlphabetic(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // 스택에 남아있는 연산자 모두 pop
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    // 연산자 우선순위 반환
    static int getPriority(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return 0;
        }
    }

}