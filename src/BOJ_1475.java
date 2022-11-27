import java.io.*;

// 방 번호
public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 방 번호 N 입력
        String[] N = br.readLine().split("");

        int[] set = new int[9];
        for(String x : N) {
            // 6과 9는 같이 사용 가능, 9가 필요해도 6의 개수를 늘림
            if(Integer.parseInt(x) == 9) {
                set[6]++;
            }
            // 나머지는 그대로 필요한 개수 파악
            else {
                set[Integer.parseInt(x)]++;
            }
        }

        // 필요한 세트의 개수
        int needSet = 0;
        for(int i = 0; i <= 8; i++) {
            // 6과 9는 같이 사용 가능, 9가 필요해도 6의 개수를 늘렸음
            if(i == 6) {
                set[i] = set[i] / 2 + set[i] % 2;
            }
            // 필요한 세트의 최솟값 알아내기
            if(needSet < set[i]) {
                needSet = set[i];
            }
        }

        // 출력
        bw.write(String.valueOf(needSet));
        bw.close();
    }
}
