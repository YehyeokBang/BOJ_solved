import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 분수 합
public class BOJ_1735 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numeratorA = Integer.parseInt(st.nextToken());
        int denominatorA = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int numeratorB = Integer.parseInt(st.nextToken());
        int denominatorB = Integer.parseInt(st.nextToken());

        int nA = numeratorA * denominatorB;
        int nB = denominatorA * numeratorB;
        int dSum = nA + nB;
        int dTimes = denominatorA * denominatorB;

        int f = dSum > dTimes ? gcd(dSum, dTimes) : gcd(dTimes, dSum);

        System.out.println(dSum / f + " " + dTimes / f);
    }

    static int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }
}
