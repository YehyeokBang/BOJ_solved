import java.util.*;
import java.io.*;

// 숨바꼭질 2
public class BOJ_12851 {
    static int N, K;
    static int[] time = new int[100001]; // 어떤 칸을 탐색하는 데 걸리는 시간을 저장할 배열
    static int minTime = 1000000000; // 탐색 최소 시간
    static int count = 0; // 최소 시간으로 탐색할 수 있는 방법의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, K 입력
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // N이 더 크다면 갈 방법은 한 칸씩 뒤로가는 방법밖에 없음
        if (N >= K) {
            System.out.println((N-K) + "\n1");
            return;
        }

        // 탐색
        bfs();

        // 출력
        System.out.println(minTime + "\n" + count);
    }

    // 너비 우선 탐색
    static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(N);
        time[N] = 1;

        // 큐가 빌 때까지
        while (!queue.isEmpty()) {
            int now = queue.poll();

            // now 방문 시간이 최소 시간보다 크면 뒤는 더 볼 필요 없음
            if (minTime < time[now]) return;

            // 이동할 때 경우의 수
            for (int i=0; i<3; i++) {
                int next;

                // X + 1
                if (i == 0) {
                    next = now + 1;
                }
                // X - 1
                else if (i == 1) {
                    next = now - 1;
                }
                // X * 2
                else {
                    next = now * 2;
                }

                // 범위를 넘어가면 다음으로 넘어감
                if (next < 0 || next > 100000) {
                    continue;
                }

                // 탐색 최소 시간 구하고
                // 가장 빠른 시간으로 찾는 방법은 몇 가지인지
                if (next == K) {
                    minTime = time[now];
                    count++;
                }

                // 첫 방문이거나 (time[next] == 0)
                // 이미 방문한 곳이어도 같은 시간에 방문했다면 (time[next] == time[now] + 1)
                // 경우의 수에 추가될 수 있기 때문에 Queue 에 한번 더 넣어줌
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    queue.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }
}