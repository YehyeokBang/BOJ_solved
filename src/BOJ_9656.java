import java.io.*;

public class BOJ_9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 돌의 개수가 짝수인 경우 SY, 홀수인 경우 CY
        if (Integer.parseInt(br.readLine()) % 2 == 0) System.out.println("SK");
        else System.out.print("CY");
    }
}