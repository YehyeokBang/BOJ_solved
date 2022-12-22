import java.io.*;
import java.util.StringTokenizer;

// 치킨치킨치킨
public class BOJ_16439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 회원의 수
        int M = Integer.parseInt(st.nextToken()); // 치킨 종류의 수

        // 치킨 선호도 입력
        int[][] preference = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                preference[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0; // 만족도 합
        int max = 0; // 만족도 합의 최댓값

        // 한 가지 종류의 치킨만 시킬 때
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                sum += preference[j][i];
            }
            if(max < sum) {
                max = sum;
            }
            sum = 0;
        }

        sum = 0;
        // 두 가지 종류의 치킨을 시킬 때
        for(int i = 0; i < M; i++) {
            for(int j = i + 1; j < M; j++) {
                for(int k = 0; k < N; k++) {
                    sum += Math.max(preference[k][i], preference[k][j]);
                }
                if(max < sum) {
                    max = sum;
                }
                sum = 0;
            }
        }

        sum = 0;
        // 세 가지 종류의 치킨을 시킬 때
        for(int i = 0; i < M; i++) {
            for(int j = i + 1; j < M; j++) {
                for(int k = j + 1; k < M; k++) {
                    for(int l = 0; l < N; l++) {
                        sum += Math.max(preference[l][i], Math.max(preference[l][j], preference[l][k]));
                    }
                    if(max < sum) {
                        max = sum;
                    }
                    sum = 0;
                }
            }
        }

        // 출력
        bw.write(String.valueOf(max));
        bw.close();
    }
}