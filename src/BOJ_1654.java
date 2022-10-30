import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

// 랜선 자르기
public class BOJ_1654 {
    static int K; // 가지고 있는 랜선의 개수
    static long N; // 필요한 랜선의 개수
    static long[] lan; // 가지고 있는 랜선의 개수
    static long before; // 이전 mid 길이

    // 탐색에 사용
    static long top = 0;
    static long mid = 0;
    static long bottom = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫째줄 입력
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        // 가지고 있는 랜선의 개수 K, 필요한 랜선의 개수 N
        K = Integer.parseInt(st.nextToken());
        N = Long.parseLong(st.nextToken());

        lan = new long[K]; // 랜선의 길이 저장
        for(int i=0; i<K; i++) {
            // temp를 중간에 사용해서 비교 후 가장 큰 값 구함
            long temp = Long.parseLong(br.readLine());
            lan[i] = temp;

            // 가장 긴 랜선의 길이
            if(top < temp) {
                top = temp;
            }
        }
        top++;
        mid = top / 2; // 초기 mid는 top의 절반

        cut(mid);

        bw.write(String.valueOf(mid - 1));
        bw.close();
    }

    public static void cut(long m) {
        // 무한 반복 막기, 전에 사용한 mid로 또 cut(mid)를 사용하는 경우
        if(before == m) {
            return;
        }
        before = m; // 사용한 mid 값 before에 저장
        long take = 0; // mid값으로 랜선을 잘라 가져갈 랜선의 개수

        // mid 값으로 가지고 있는 랜선들을 모두 자르면 몇 개가 나오는지
        for(int i=0; i<K; i++) {
            if(lan[i] < m) {
                continue;
            }
            take += lan[i] / m;
        }

        if(N == 1) {
            mid = top;
            return;
        }

        // 정확히 맞추지 못했다면 탐색하기
        if(take >= N) {
            bottom = mid + 1;
            mid = (mid + 1 + top) / 2;
            cut(mid);
        }
        else if(take < N) {
            top = mid;
            mid = (bottom + mid) / 2;
            cut(mid);
        }
    }
}