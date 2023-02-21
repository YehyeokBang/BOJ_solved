import java.io.*;

// 책 페이지
public class BOJ_1019 {
    static int count = 1;
    static int page[] = new int[10];;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1부터 N까지가 아닌 A부터 B까지 각 숫자가 몇 번 나오는 지 카운트
        int B = Integer.parseInt(br.readLine());
        int A = 1;

        while(A <= B) {
            // B를 9로 맞추기, 맞추는 과정에서 지나온 수도 카운트
            while(B % 10 != 9 && A <= B) {
                cal(B);
                B--;
            }

            // A를 0으로 맞추기, 맞추는 과정에서 지나온 수도 카운트
            while(A % 10 != 0 && A <= B) {
                cal(A);
                A++;
            }

            // 모든 페이지의 수를 다 카운트하면 종료
            if(A > B) {
                break;
            }

            // 아직 남았다면 다시 반복
            A /= 10;
            B /= 10;

            for(int i = 0; i < 10; i++) {
                page[i] += (B - A + 1) * count;
            }

            count *= 10;
        }

        // 출력
        for(int i = 0; i < 10; i++) {
            System.out.print(page[i]+" ");
        }
    }

    public static void cal(int cur) {
        while(0 < cur) {
            page[cur % 10] += count;
            cur /= 10;
        }
    }
}