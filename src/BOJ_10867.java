import java.io.*;
import java.util.*;

// 중복 빼고 정렬하기
public class BOJ_10867 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 중복 제거
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> list = new ArrayList<>(set);

        // 정렬
        list.sort(Integer::compareTo);

        // 출력
        for(int i = 0; i < list.size(); i++) {
            bw.write(String.valueOf(list.get(i)));
            bw.write(' ');
        }
        bw.close();
    }
}