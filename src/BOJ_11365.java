import java.io.*;

// !밀비 급일
public class BOJ_11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 처음 입력
        String s = br.readLine();

        // "END" 입력하면 종료
        while (!s.equals("END")) {
            bw.write(String.valueOf(new StringBuilder(s).reverse()));
            bw.write("\n");
            s = br.readLine();
        }
        bw.close();
    }
}