import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 수도요금
public class BOJ_10707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine()); // X사의 1리터당 요금
        int b = Integer.parseInt(br.readLine()); // Y사의 기본요금
        int c = Integer.parseInt(br.readLine()); // Y사의 요금이 기본 요금이 되는 사용량의 상한
        int d = Integer.parseInt(br.readLine()); // Y사의 1리터당 추가요금
        int p = Integer.parseInt(br.readLine()); // 집에서 사용하는 한 달간 수도의 양

        // X사의 수도요금
        int x = a * p;

        // 비교 결과 출력
        if (c >= p) System.out.print(Math.min(x, b));
        else System.out.print(Math.min(x, b + (p - c) * d));
    }
}