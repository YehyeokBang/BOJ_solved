import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 날짜 계산
public class BOJ_1476 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int e=1,s=1,m=1;
        int E = Integer.parseInt(st.nextToken()); // 지구
        int S = Integer.parseInt(st.nextToken()); // 태양
        int M = Integer.parseInt(st.nextToken()); // 달

        for(int year = 1; ; year++) {
            if(e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            e+=1;
            s+=1;
            m+=1;

            // 조건
            if(e == 16) {
                e=1;
            }
            if(s == 29) {
                s=1;
            }
            if(m == 20) {
                m=1;
            }
        }
    }
}