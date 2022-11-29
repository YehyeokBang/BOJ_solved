import java.io.*;
import java.util.Stack;

// 쇠막대기
public class BOJ_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 괄호 표현 입력
        String input = br.readLine();

        int count = 0; // 잘려진 조각의 개수
        char before = ')'; // '()' 쌍으로 레이저를 구분하기 위해 이전 괄호를 저장
        Stack<Character> stack = new Stack<>();
        // 괄호 하나씩 확인
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            // 여는 괄호라면, 스택에 삽입
            if(c == '(') {
                stack.add(c);
            }
            // 아니라면 작업
            else {
                stack.pop();
                // 이전 괄호가 '('라면 지금 겹쳐있는 막대기 개수만큼 자른 막대기가 나옴
                if(before == '(') {
                    count += stack.size();
                }
                // 아니라면 그냥 막대기 하나 끝 지점임
                else {
                    count++;
                }
            }
            // 이전 괄호 저장
            before = c;
        }

        // 출력
        bw.write(String.valueOf(count));
        bw.close();
    }
}