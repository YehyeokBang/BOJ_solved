import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 숫자 야구
public class BOJ_2503 {
    static int N;
    static boolean[] check = new boolean[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 123; i < 1000; i++) {
            String input = Integer.toString(i);

            if (input.charAt(0) == '0' || input.charAt(1) == '0' || input.charAt(2) == '0') {
                continue;
            }

            if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2)) {
                continue;
            }
            check[i] = true;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int req = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for (int ans = 123; ans <= 987; ans++) {
                if (check[ans]) {
                    int ns = 0;
                    int nb = 0;

                    for (int first = 0; first < 3; first++) {
                        char req_split = Integer.toString(req)
                                .charAt(first);

                        for (int second = 0; second < 3; second++) {
                            char ans_split = Integer.toString(ans)
                                    .charAt(second);

                            if (req_split == ans_split && first == second) {
                                ns++;
                            }
                            else if (req_split == ans_split) {
                                nb++;
                            }
                        }
                    }

                    check[ans] = ns == strike && nb == ball;
                }
            }
        }


        int resultCount = 0;
        for (int i = 123; i < 1000; i++) {
            if (check[i]) {
                resultCount++;
            }
        }

        System.out.println(resultCount);
    }
}
