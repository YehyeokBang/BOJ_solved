import java.io.*;

// 문자와 문자열
public class BOJ_27886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(s.charAt(Integer.parseInt(br.readLine()) - 1));
    }
}