import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 새로읽기
public class BOJ_10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[][] arr = new String[5][15];

        // 입력 받기
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.substring(j, j+1);
            }
        }

        // 출력
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] != null) {
                    System.out.print(arr[j][i]);
                }
            }
        }
    }
}
