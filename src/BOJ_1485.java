import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 정사각형
public class BOJ_1485 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        StringTokenizer st;

        // 테스트 케이스의 개수 입력
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            ArrayList<Point> pointList = new ArrayList<>();
            for(int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pointList.add(new Point(x, y));
            }

            // 가로 2, 세로 2, 대각선 2
            double[] dist = new double[6];
            int count = 0;
            for(int i = 0; i < 3; i++) {
                for(int j = i + 1; j < 4; j++) {
                    dist[count++] = calcDist(pointList.get(i), pointList.get(j));
                }
            }

            // 정사각형 여부
            boolean isSquare = true;

            // 정사각형이면 변의 길이를 오름차순 정렬하면 앞에 4개의 값은 4개의 변이 되고
            // 뒤의 2개의 값은 대각선이 될 것이다.
            Arrays.sort(dist);

            // 4개의 변중 하나라도 다르면 정사각형 X
            for (int j=1; j<4; j++) {
                if (dist[0] != dist[j]) {
                    isSquare = false;
                }
            }

            // 대각선의 길이가 같지 않으면 정사각형 X
            if (dist[4]!=dist[5]) {
                isSquare = false;
            }

            // 결과
            if (isSquare) {
                bw.write(1 + "\n");
            }
            else {
                bw.write(0 + "\n");
            }
        }
        // 출력
        bw.flush();
        bw.close();
    }

    static double calcDist(Point point1, Point point2) {
        int dx = point1.x - point2.x;
        int dy = point1.y - point2.y;
        return Math.sqrt(Math.pow(dx, 2)+Math.pow(dy, 2));
    }
}

// 점을 표현하는 객체
class Point {
    int x;
    int y;

    public Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}