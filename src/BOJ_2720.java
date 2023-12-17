import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 세탁소 사장 동혁
public class BOJ_2720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 케이스 수
        int t = Integer.parseInt(br.readLine());
        int quarter = 25;  //쿼터 0.25$
        int dime = 10;  //다임 0.10$
        int nickel = 5;  //니켈 0.05$
        int penny = 1;  //페니 0.01$

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());
            sb.append(c / quarter).append(" ");
            c %= quarter;
            sb.append(c / dime).append(" ");
            c %= dime;
            sb.append(c / nickel).append(" ");
            c %= nickel;
            sb.append(c / penny).append("\n");
        }
        System.out.print(sb);
    }
}
