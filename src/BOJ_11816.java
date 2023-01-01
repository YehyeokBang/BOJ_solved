import java.io.*;

// 8진수, 10진수, 16진수
public class BOJ_11816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // X 입력
        String X = br.readLine();

        // 10진수는 그대로 출력
        if(X.charAt(0) != '0') {
            bw.write(X);
        }
        // 8진수를 10진수로 변환 후 출력
        else if(X.charAt(1) != 'x') {
            bw.write(String.valueOf(Integer.parseInt(X, 8)));
        }
        // 16진수를 10진수로 변환 후 출력
        else {
            bw.write(String.valueOf(Integer.parseInt(X.substring(2), 16)));
        }
        bw.close();
    }
}