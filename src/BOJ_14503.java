import java.io.*;
import java.util.StringTokenizer;

// 로봇 청소기
public class BOJ_14503 {
    static int N, M; // 가로, 세로 길이
    // 0: 북, 1: 동, 2: 남, 3: 서
    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { -1, 0, 1, 0 };
    static int[][] room; // 방의 정보
    static boolean[][] check; // 탐색 여부


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N, M 입력
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st.hasMoreTokens();

        // 배열 초기화
        room = new int[N][M];
        check = new boolean[N][M];

        // 현재 로봇 청소기의 위치, 방향 입력
        st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        // 0: 북, 1: 동, 2: 남, 3: 서
        int direction = Integer.parseInt(st.nextToken());
        st.hasMoreTokens();

        // 방 정보 입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방 청소하기
        cleanMyRoom(y, x, direction);

        // 청소하는 칸의 개수 출력
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(check[i][j]) {
                    count++;
                }
            }
        }
        bw.write(String.valueOf(count));
        bw.close();
    }

    // 청소하기
    static void cleanMyRoom(int y, int x, int direction) {
        // 현재 위치를 청소
        check[y][x] = true;

        // 네 방향 탐색 2.청소할 공간 없으면 회전하고 왼쪽 탐색 방식
        for(int i = 0; i < 4; i++) {
            direction += 3;
            direction %= 4;

            int xPos = x + dx[direction];
            int yPos = y + dy[direction];

            // 1.왼쪽 방향에 아직 청소하지 않은 공간이 존재할 경우
            if(room[yPos][xPos] == 0 && !check[yPos][xPos]) {
                cleanMyRoom(yPos, xPos, direction);
                return;
            }
            else {
                // 3.네 방향 모두 청소가 되어있거나 벽인 경우 방향 유지 및 후진
                if(i == 3) {
                    // 방향을 기준으로 후진 좌표 결정
                    xPos = x + dx[(direction + 2) % 4];
                    yPos = y + dy[(direction + 2) % 4];

                    // 4.후진이 불가능한 경우 작동 멈춤
                    if (room[yPos][xPos] != 0) {
                        return;
                    }
                    // 후진 탐색
                    cleanMyRoom(yPos, xPos, direction);
                }
            }
        }
    }
}