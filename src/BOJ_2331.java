import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 반복수열
public class BOJ_2331 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); // 수열의 첫째 항
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(A);

        while (true) {
            int temp = list.get(list.size() - 1);
            int result = 0;

            // 어떤 수의 각 자리에 대해 P 제곱만큼하여 각 자리를 더한 값을 구함.
            while (temp != 0) {
                result += (int) Math.pow(temp % 10, (double) P);
                temp /= 10;
            }

            // result가 이미 list에 포함되어있다면, 그 result가 가리키는 인덱스를 반환.
            if (list.contains(result)) {
                int ans = list.indexOf(result);
                bw.write(ans + "\n");
                break;
            }

            list.add(result);
        }

        // 출력
        bw.flush();
        bw.close();
    }
}
