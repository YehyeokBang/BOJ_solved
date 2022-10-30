import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

// 집합
public class BOJ_11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        HashMap<Integer,String> map = new HashMap<Integer,String>();

        int M = Integer.parseInt(br.readLine()); // 연산의 수
        String command = "";
        int x = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            command = st.nextToken();
            try {
                x = Integer.parseInt(st.nextToken());
            }
            catch (Exception e) {
                x = 0;
            }

            switch (command) {
                case "add":
                    if(!map.containsKey(x)) {
                        map.put(x, "");
                    }
                    break;

                case "remove":
                    if(map.containsKey(x)) {
                        map.remove(x);
                    }
                    break;

                case "check":
                    if(map.containsKey(x)) {
                        sb.append("1\n");
                    }
                    else {
                        sb.append("0\n");
                    }
                    break;

                case "toggle":
                    if(map.containsKey(x)) {
                        map.remove(x);
                    }
                    else {
                        map.put(x, "");
                    }
                    break;

                case "all":
                    for(int j = 1; j <= 20; j++) {
                        map.put(j, "");
                    }
                    break;

                case "empty":
                    for(int j = 1; j <= 20; j++) {
                        map.remove(j);
                    }
                    break;
            }
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }
}