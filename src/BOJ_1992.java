import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

// 쿼드트리
public class BOJ_1992 {
    static  int N; // 영상의 크기, N * N
    static boolean[][] vidio; // 영상 화면
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 영상의 크기
        vidio = new boolean[N][N]; // 영상 화면을 상태를 저장할 2차원 배열

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                if(line[j].equals("1")) {
                    vidio[i][j] = true;
                }
                else {
                    vidio[i][j] = false;
                }
            }
        }

        compression(0, 0, N);

        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 영상 압축
    public static void compression(int row, int col, int size) {
        boolean temp = vidio[row][col];

        // 사이즈가 1이면 그냥 추가
        if(size == 1) {
            if(temp) {
                sb.append("1");
            }
            else {
                sb.append("0");
            }
            return;
        }

        // test는 정해진 사이즈 안에 모든 요소가 같은 값인지 판별
        // true면 같음 => 압축, false면 다름 => 분할 필요
        boolean test = true;
        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(temp != vidio[i][j]) {
                    test = false;
                    break;
                }
            }
        }

        // 분할이 필요하면 괄호 열고 분할 후 괄호 닫기
        if(!test) {
            sb.append("(");
            compression(row, col, size / 2);
            compression(row, col + size / 2, size / 2);
            compression(row + size / 2, col, size / 2);
            compression(row + size / 2, col + size / 2, size / 2);
            sb.append(")");
        }

        // 압축이 가능하면 값을 추가
        else {
            if(temp) {
                sb.append("1");
            }
            else {
                sb.append("0");
            }
        }
    }
}