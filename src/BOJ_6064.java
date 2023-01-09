import java.io.*;
import java.util.StringTokenizer;

// 카잉 달력
public class BOJ_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 테스트 횟수, T 입력
        int T = Integer.parseInt(br.readLine());

        for(int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            // 나머지가 0이 나오는 것을 방지하기 위해 x, y 값에서 1씩 빼줌
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            boolean check = false; // <x:y>가 유효하지 않은 경우 false

            for (int i = x; i < (N * M); i += M) {
                if (i % N == y) {
                    bw.write(String.valueOf(i + 1)); // 뺐던 1을 다시 더해줌
                    bw.write("\n");
                    check = true; // <x:y>가 유효함
                    break;
                }
            }

            // 유효하지 않은 경우 -1 출력
            if(!check) {
                bw.write("-1\n");
            }
        }
        bw.close();
    }
}