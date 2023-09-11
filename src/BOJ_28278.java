import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_28278 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수를 저장하는 스택
        Stack<Integer> stack = new Stack<>();

        // 명령 개수 입력
        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 명령 개수만큼 반복
        for (int i = 0; i < count; i++) {
            // 명령 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int x = 0;
            if (command == 1) x = Integer.parseInt(st.nextToken());

            // 명령에 따른 처리
            int result = -1;
            try {
                switch (command) {
                    case 1 -> stack.push(x); // 정수 X를 스택에 넣는다.
                    case 2 -> result = stack.pop(); // 스택에서 가장 위에 있는 정수를 뺀다.
                    case 3 -> result = stack.size(); // 스택에 들어있는 정수의 개수를 출력한다.
                    case 4 -> result = stack.isEmpty() ? 1 : 0; // 스택이 비어있으면 1, 아니면 0을 출력한다.
                    case 5 -> result = stack.peek(); // 스택에서 가장 위에 있는 정수를 출력한다.
                }

                if (command != 1) sb.append(result).append("\n");
            } catch (Exception e) {
                // 스택이 비어있는 경우
                sb.append(result).append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb);
    }
}