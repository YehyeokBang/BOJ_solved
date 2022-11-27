import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 붙임성 좋은 총총이
public class BOJ_26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        HashMap<String,String> map = new HashMap<String,String>();

        // 총총이는 꼭 등장하니 미리 넣어두고 춤을 추는 사람의 수에도 미리 추가
        int count = 1;
        map.put("ChongChong", " ");
        for(int i = 0; i < N; i++) {
            // human1, human2 입력
            st = new StringTokenizer(br.readLine(), " ");
            String h1 = st.nextToken();
            String h2 = st.nextToken();

            // 총총이가 숙주임
            if(h1.equals("ChongChong") && !map.containsKey(h2)) {
                count++;
                map.put(h2, "");
                continue;
            }
            if (h2.equals("ChongChong") && !map.containsKey(h1)) {
                count++;
                map.put(h1, "");
                continue;
            }

            // 춤을 추고 있는 사람과 아닌 사람이 만났을 때,
            // 춤은 중독성이 강하기 때문에 아닌 사람에게 춤 전파
            if(map.containsKey(h1) && !map.containsKey(h2)) {
                count++;
                map.put(h2, "");
            }
            else if (map.containsKey(h2) && !map.containsKey(h1)) {
                count++;
                map.put(h1, "");
            }
        }
        // 출력
        System.out.println(count);
    }
}