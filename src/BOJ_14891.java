import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14891 {
    static int[][] gears = new int[4][8]; // 기어 정보 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 기어 입력
        for(int i = 0; i < 4; i++) {
            String line = br.readLine();
            for(int j = 0; j <8 ; j++) {
                gears[i][j] = line.charAt(j) - '0';
            }
        }

        StringTokenizer st;
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            // 회전 톱니 바퀴 번호, 회전 방향 입력
            int index = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            gearOperation(index, direction);
        }

        // 점수 계산 및 출력
        int total = 0;
        for(int i = 0; i < 4; i++) {
            total += Math.pow(2, i) * gears[i][0];
        }
        System.out.println(total);
    }

    static void gearOperation(int index, int direction) {
        // 왼쪽 (0 ~ index - 1)
        leftSide(index-1, -direction);
        // 오른쪽 (index + 1 ~ 3)
        rightSide(index + 1, -direction);
        rotation(index,direction);
    }

    static void leftSide(int index, int direction) {
        if(index < 0) {
            return;
        }
        if(gears[index][2] == gears[index + 1][6]) {
            return;
        }
        leftSide(index - 1, -direction);
        rotation(index, direction);
    }

    static void rightSide(int index, int direction) {
        if(index > 3) {
            return;
        }
        if(gears[index][6] == gears[index - 1][2]) {
            return;
        }
        rightSide(index + 1, -direction);
        rotation(index,direction);
    }

    // 톱니바퀴 회전 메소드
    static void rotation(int index, int direction) {
        if(direction == 1) {
            int tmp = gears[index][7];
            for(int i = 7; i > 0; i--) {
                gears[index][i] = gears[index][i - 1];
            }
            gears[index][0] = tmp;
        } else {
            int tmp = gears[index][0];
            for(int i = 0; i < 7; i++) {
                gears[index][i] = gears[index][i + 1];
            }
            gears[index][7] = tmp;
        }
    }
}