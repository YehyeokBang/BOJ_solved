import java.io.*;

// 아!
public class BOJ_4999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String maxAh = br.readLine(); // 가장 길게 낼 수 있는 "아!"의 길이
        String wantDoctor = br.readLine(); // 의사가 원하는 "아!"의 길이

        if(maxAh.length() >= wantDoctor.length()) {
            bw.write("go");
        }
        else {
            bw.write("no");
        }
        bw.close();
    }
}
