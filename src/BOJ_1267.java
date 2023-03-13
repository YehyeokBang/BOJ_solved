import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 영식과 민신의 요금
        int yFee = 0;
        int mFee = 0;

        // 통화의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 통화시간 N개 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());

            // 초당 요금 계산 + 기본 요금
            yFee += (time / 30) * 10 + 10;
            mFee += (time / 60) * 15 + 15;
        }

        // 결과 출력
        if(yFee > mFee) {
            System.out.print("M " + mFee);
        }
        else if(yFee < mFee) {
            System.out.print("Y " + yFee);
        }
        else {
            System.out.print("Y M " + yFee);
        }
    }
}