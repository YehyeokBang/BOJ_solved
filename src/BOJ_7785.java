import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

// 회사에 있는 사람
public class BOJ_7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 출입 기록의 수
        int n = Integer.parseInt(br.readLine());

        // 출입 기록
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                map.put(name, status);
            } else {
                map.remove(name);
            }
        }

        // 사전 순의 역순으로 출력하기
        StringBuilder sb = new StringBuilder();
        map.keySet().stream().sorted(Comparator.reverseOrder()).forEach(key -> sb.append(key).append("\n"));
        System.out.println(sb);
    }
}