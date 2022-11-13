import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class BOJ_7576 {
    static int N; // 상자의 가로 칸의 수
    static int M; // 상자의 가로 칸의 수
    static int box[][]; // 토마토 저장할 상자
    static int date[][]; // 토마토를 저장시킨 날짜를 저장
    static int minDate; // 최소 날짜
    static Queue<Node> queue = new LinkedList<Node>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        date = new int[N][M];

        // 토마토 상태 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.valueOf(st.nextToken());
                // 익은 토마토 좌표를 Node 객체를 이용해서 큐에 넣기
                if (box[i][j] == 1) {
                    Node node = new Node(i, j);
                    queue.offer(node);
                }
            }
        }

        // 너비 우선 탐색
        bfs();

        // 토마토가 다 익었는지 확인
        check();

        // 출력
        bw.write(String.valueOf(minDate));
        bw.close();
    }

    // 토마토가 다 익었는지 확인하고
    // 다 익었으면 최소 날짜, 다 안익었으면 -1 리턴
    private static void check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 안익은 토마토 존재
                if (date[i][j] == 0 && box[i][j] == 0) {
                    minDate = -1;
                    return;
                }
                // 다 익음
                else {
                    minDate = Math.max(minDate, date[i][j]);
                }
            }
        }
    }

    // 너비 우선 탐색, 토마토 익히기
    private static void bfs() {
        int i = 0;
        int j = 0;
        Node node = null;

        // 큐가 빈 상태일 때까지 반복
        while (queue.isEmpty() == false) {
            // 익은 토마토의 좌표를 알아내고
            node = queue.poll();
            i = node.x;
            j = node.y;

            // 익은 토마토 상자에 저장
            box[i][j] = 1;

            // 위에 있는 토마토를 익힐 수 있으면 왼쪽 자리의 좌표를 Node 객체를 이용해 큐에 저장
            // 추가로 익히는 퍼져 나갈수록 날짜를 하루 씩 더해서 저장
            if (i > 0 && box[i - 1][j] == 0 && date[i - 1][j] == 0) {
                date[i - 1][j] = date[i][j] + 1; // 현재 좌표의 기준 일에 하루를 더해서 익혀질 토마토 자리에 저장
                Node next = new Node(i - 1, j);
                queue.offer(next);
            }
            // 아래
            if (i < N - 1 && box[i + 1][j] == 0 && date[i + 1][j] == 0) {
                date[i + 1][j] = date[i][j] + 1;
                Node next = new Node(i + 1, j);
                queue.offer(next);
            }
            // 왼쪽
            if (j > 0 && box[i][j - 1] == 0 && date[i][j - 1] == 0) {
                date[i][j - 1] = date[i][j] + 1;
                Node next = new Node(i, j - 1);
                queue.offer(next);
            }
            // 오른쪽
            if (j < M - 1 && box[i][j + 1] == 0 && date[i][j + 1] == 0) {
                date[i][j + 1] = date[i][j] + 1;
                Node next = new Node(i, j + 1);
                queue.offer(next);
            }
        }
    }

    // 좌표 저장 클래스
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}