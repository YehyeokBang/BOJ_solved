import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

// 수 정렬하기 3
public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 수의 개수 입력 및 배열 초기화
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        // 수 입력
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(arr);

        // 출력
        for(int i = 0; i < N; i++){
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}