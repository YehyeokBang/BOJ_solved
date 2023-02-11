import java.io.*;

// 별 찍기 - 20
public class BOJ_10995 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // N 만큼 반복
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // i가 홀수일 경우 앞에 띄우기
                if(i % 2 == 1) {
                    System.out.print(" ");
                }
                System.out.print("*");
                // i가 짝수일 경우 뒤에 띄우기
                if(i % 2 == 0) {
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
    }
}