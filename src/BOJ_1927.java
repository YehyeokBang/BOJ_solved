import java.io.*;
import java.util.PriorityQueue;

// 최소 힙
public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // 우선순위 큐

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 0을 입력 받았을 경우 큐에서 최솟값을 출력함
            // 큐가 비어있을 경우 0을 출력함
            if (num == 0) {
                sb.append(priorityQueue.size() == 0 ? 0 : priorityQueue.poll()).append('\n');
            }
            // 0이 아닌 정수를 입력 받았을 경우 큐에 추가함
            else {
                priorityQueue.add(num);
            }
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
