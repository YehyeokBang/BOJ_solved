import java.io.*;
import java.util.Stack;

// 단어 뒤집기 2
public class BOJ_17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        // 문자열 S 입력
        String[] S = br.readLine().split("");

        boolean tag = false;
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < S.length; i++) {
            // tag를 이용해서 '<>' 유무를 판별
            if(S[i].equals("<")) {
                tag = true;
            }
            else if(S[i].equals(">")) {
                tag = false;
                sb.append(S[i]);
                continue;
            }

            // 부분 문자열 도중 공백 문자가 나오면 다른 단어임
            if(!tag && S[i].equals(" ")) {
                while(!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(" ");
                continue;
            }

            // 부분 문자열은 스택에 넣음
            if(!tag) {
                stack.add(S[i]);
            }
            // 태그를 만나면 스택에 넣어둔 부분 문자열 꺼내고(리버스)
            // 태그를 추가함
            else if (tag) {
                while(!stack.empty()) {
                    sb.append(stack.pop());
                }
                sb.append(S[i]);
            }
        }
        // 혹시 스택에 남아있는 부분 출력
        while(!stack.empty()) {
            sb.append(stack.pop());
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
