import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

// 나는야 포켓몬 마스터 이다솜
public class BOJ_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> dict = new HashMap<>();
        HashMap<Integer, String> number = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String poketmon = br.readLine();
            dict.put(poketmon, i);
            number.put(i, poketmon);
        }

        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            // 입력받은 문제가 포켓몬이면 그 포켓몬의 번호를 구함
            if(dict.containsKey(command)) {
                sb.append(dict.get(command)).append("\n");
            }
            // 아니라면 그 번호의 포켓몬을 구함
            else if(number.containsKey(Integer.parseInt(command))) {
                sb.append(number.get(Integer.parseInt(command))).append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.close();
    }
}
