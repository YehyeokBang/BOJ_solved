import java.io.*;
import java.util.StringTokenizer;

// 문자열
public class BOJ_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // A, B 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String A = st.nextToken();
        String B = st.nextToken();

        int result = A.length(); // A와 다 다른 경우 A의 길이가 결과임, 최댓값

        for(int i = 0; i < B.length() - A.length() + 1; i++) {
            int count = 0;
            for(int j = 0; j < A.length(); j++) {
                // 문자가 다르면 count 증가
                if(A.charAt(j) != B.charAt(i + j)) {
                    count++;
                }
            }
            // 최솟값을 계속 저장
            result = Math.min(count, result);
        }
        // 출력
        bw.write(String.valueOf(result));
        bw.close();
    }
}
