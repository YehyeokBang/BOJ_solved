import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// N번째 큰 수
public class BOJ_2693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스의 개수 T 입력
        int T = Integer.parseInt(br.readLine());

        // 테스트 케이스의 개수 만큼 배열 입력 받기
        for(int tc = 0; tc < T; tc++) {
            // 해당 테스트에서 사용할 배열 선언
            int[] array = new int[10];

            // 원소 10개 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            // 오름차순 정렬
            Arrays.sort(array);

            // 해당 배열에서 3번째로 큰 값을 적어두기,
            // 10개 배열을 오름차순 정렬했으니 인덱스 9가 가장 큼
            // (9, 8, 7) 3번째로 큰 수는 인덱스 7
            bw.write(String.valueOf(array[7]));
            bw.write("\n");
        }

        // 출력
        bw.close();
    }
}