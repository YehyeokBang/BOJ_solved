import java.io.*;
import java.util.*;

// 문자열 집합
public class BOJ_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N, M 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 문자열 집합 S를 저장할 해시맵
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        // 포함된 문자열 개수
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (map.containsKey(br.readLine())) count++;
        }

        // 출력
        System.out.print(count);
    }
}
