import java.io.*;
import java.util.*;

// 이중 우선순위 큐
public class BOJ_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> que = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char ch = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);

                // Insert, 숫자와 해당 숫자가 저장된 갯수를 저장함
                if (ch == 'I') {
                    que.put(n, que.getOrDefault(n, 0) + 1);
                }
                // Remove
                else {
                    if (que.size() == 0)
                        continue;

                    // D 1 이면 최댓값 제거, D 2 이면 최솟값 제거
                    int num = n == 1 ? que.lastKey() : que.firstKey();
                    if (que.put(num, que.get(num) - 1) == 1)
                        que.remove(num);
                }
            }
            // 출력
            System.out.println(que.size() == 0 ? "EMPTY" : que.lastKey() + " " + que.firstKey());
        }
    }
}