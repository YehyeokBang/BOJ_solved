import java.io.*;

// 사토르 마방진
public class BOJ_20112 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 단어의 길이, 즉 가로, 세로 길이
        int N = Integer.parseInt(br.readLine());

        // words에 모든 단어 저장
        String[][] words = new String[N][N];
        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split(""); // 한 단어(한 줄) 입력
            for(int j = 0; j < N; j++) {
                words[i][j] = line[j];
            }
        }

        // 사토르 마방진 판별
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                // 사토르 마방진이 아니면 NO 출력 후 종료
                if(!words[i][j].equals(words[j][i])) {
                    bw.write("NO");
                    bw.close();
                    return;
                }
            }
        }
        // 사토르 마방진이면 YES 출력
        bw.write("YES");
        bw.close();
    }
}