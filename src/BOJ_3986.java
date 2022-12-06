import java.io.*;
import java.util.Stack;

// 좋은 단어
public class BOJ_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 단어의 수
        int N = Integer.parseInt(br.readLine());

        // 좋은 단어의 개수
        int count = 0;
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for(int j = 0; j < input.length; j++) {
                // 스택이 비어있으면 그냥 삽입
                if(stack.isEmpty()) {
                    stack.add(input[j]);
                }
                else {
                    // 스택의 top과 같은 알파벳이면 pop, 연결
                    if(stack.peek().equals(input[j])) {
                        stack.pop();
                    }
                    // 다르면 다시 넣기
                    else {
                        stack.add(input[j]);
                    }
                }
                // 스택이 비어있으면, 문제 없이 잘 연결된 것
                if(j == input.length - 1 && stack.isEmpty()) {
                    count++;
                }
            }
        }
        // 출력
        bw.write(String.valueOf(count));
        bw.close();
    }
}
