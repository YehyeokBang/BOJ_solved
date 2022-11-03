import java.io.*;
import java.util.*;

// 좌표 압축
public class BOJ_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 좌표 개수
        int[] num = new int[N]; // 좌표 저장
        Map<Integer, Integer> map = new HashMap<>(); // 좌표 순서 알아내기

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            num[i] = temp;
            map.put(temp, 0);
        }

        List<Integer> keyList = new ArrayList<>(map.keySet());
        keyList.sort(Integer::compareTo);

        // 순서 알아내기
        int rank = 0;
        for(Integer i : keyList) {
            if(map.containsKey(i)) {
                map.put(i, rank++);
            }
        }

        // 결과 알아내기
        for(int i = 0; i < N; i++) {
            if(map.containsKey(num[i])) {
                sb.append(map.get(num[i]));
                if(i != N - 1) {
                    sb.append(" ");
                }
            }
        }

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
