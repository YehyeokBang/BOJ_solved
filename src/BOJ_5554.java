import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 심부름 가는 길
public class BOJ_5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 구간 별 이동 시간 입력
        int firstSec = Integer.parseInt(br.readLine());
        int SecondSec = Integer.parseInt(br.readLine());
        int ThirdSec = Integer.parseInt(br.readLine());
        int FourthSec = Integer.parseInt(br.readLine());

        // 시간 계산
        int sum = (firstSec + SecondSec + ThirdSec + FourthSec);
        int resultMin = sum / 60;
        int resultSec = sum - (resultMin * 60);

        // 출력
        System.out.println(resultMin);
        System.out.println(resultSec);
    }
}