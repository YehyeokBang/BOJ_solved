import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class BOJ_1697 {
    static int N; // 수빈이 위치
    static int K; // 동생의 위치
    static int[] check = new int[100001]; // 이미 확인한 숫자를 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 위치 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 같은 위치에 있으면 0
        if(N == K) {
            System.out.println(0);
        }
        // 아니면 탐색
        else {
            bfs(N);
        }
    }

    static void bfs(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        check[num] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                // X + 1, 걷기
                if (i == 0) {
                    next = now + 1;
                }
                // X - 1, 걷기
                else if (i == 1) {
                    next = now - 1;
                }
                // X * 2, 순간이동
                else {
                    next = now * 2;
                }

                // 목적지에 도달하면 결과 출력
                if (next == K) {
                    System.out.println(check[now]);
                    return;
                }

                // 다음 수 next 가 범위안에 있고, 방문 이력이 없을 떄 큐에 next 삽입
                if (next >= 0 && next < check.length && check[next] == 0) {
                    queue.add(next);
                    // 다음 위치에는 1초 추가 후 저장 (now + 1)
                    check[next] = check[now] + 1;
                }
            }
        }
    }
}
