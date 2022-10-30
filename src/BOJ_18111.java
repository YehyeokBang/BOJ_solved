import java.io.*;
import java.util.StringTokenizer;

// 마인크래프트
public class BOJ_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 세로 N, 가로 M, 가지고 있는 블록 B
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 현재 땅의 높이를 저장할 배열과 최고, 최저 높이를 저장할 변수
        int[][] land = new int[N][M];
        int max = 0;
        int min = 0;

        // 출력할 최소 시간과 높이
        int time = 2100000000;
        int height = -1;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                land[i][j] = temp;

                if(max < temp) {
                    max = temp;
                }
                if(min > temp) {
                    min = temp;
                }
            }
        }

        // min ~ max 높이까지 모두 계산해보기
        // (쌓기 위해)필요한 블록, 제거해야 할 블록
        int need;
        int remove;

        for(int i = min; i <= max; i++) {
            need = 0;
            remove = 0;

            // 높이 i에 해당하는 땅으로 만들려고 할 때
            // 각 칸마다 블록이 필요한지, 제거해야 하는지 찾기
            for(int row = 0; row < N; row++) {
                for(int col = 0; col < M; col++) {
                    if(i > land[row][col]) {
                        need += i - land[row][col];
                    }
                    if(i < land[row][col]) {
                        remove += land[row][col] - i;
                    }
                }
            }

            // 제거하고 수집한 블록과 가지고 있는 블록을 합쳐서
            // 필요한 블록 수보다 많거나 같으면, 그 높이로 만들 수 있음
            if(need <= remove + B) {
                if(time >= remove * 2 + need) {
                    if(height > i) continue;
                    time = remove * 2 + need;
                    height = i;
                }
            }
        }

        bw.write(String.valueOf(time + " " + height));
        bw.close();
    }
}
