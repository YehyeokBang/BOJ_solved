import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

// 시리얼 번호
public class BOJ_1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 기타의 개수 N 입력
        int N = Integer.parseInt(br.readLine());
        String[] serials = new String[N];

        for(int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }

        Arrays.sort(serials, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) { // 길이가 같을 때
                    if(func1(s1, s2) == 0) { // 숫자의 합이 같을 때
                        return s1.compareTo(s2); // 사전순으로
                    }
                    else { // 모든 숫자의 합 순으로, 숫자만 더함
                        return func1(s1, s2);

                    }
                }
                else { // 길이가 짧은 게 먼저
                    if(s1.length() < s2.length()) {
                        return -1;
                    }
                    else {
                        return 1;
                    }
                }
            }
        });

        // 출력
        for(int i = 0; i < N; i++) {
            bw.write(String.valueOf(serials[i]));
            bw.write("\n");
        }
        bw.close();
    }

    // 문자열 2개를 입력받고 각 문자열에 존재하는 숫자들을 더한 값을 비교하는 메서드
    static int func1(String s1, String s2) {
        int sum1 = 0;
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) - 48 > 0 && s1.charAt(i) - 48 <= 9) {
                sum1 += s1.charAt(i) - 48;
            }
        }

        int sum2 = 0;
        for(int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i) - 48 > 0 && s2.charAt(i) - 48 <= 9) {
                sum2 += s2.charAt(i) - 48;
            }
        }

        return Integer.compare(sum1, sum2);
    }
}