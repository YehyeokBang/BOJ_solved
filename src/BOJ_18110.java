import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n 입력
        int n = Integer.parseInt(br.readLine());
        int[] values = new int[n];

        // 앞뒤로 자를 인원 수
        int slice = (int) Math.round(n * 0.15);

        // 값 입력
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(values);

        int sum = Arrays.stream(values, slice, n - slice).sum();

        int average = (int) Math.round((double) sum / (n - slice * 2));

        System.out.println(average);
    }
}