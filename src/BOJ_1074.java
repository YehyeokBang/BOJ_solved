import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

// Z
public class BOJ_1074 {
    static int count = 0; // 몇 번째 방문?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int size = (int)Math.pow(2, N); // 한 변의 길이
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        z(r, c, size);

        bw.write(String.valueOf(count));
        bw.close();
    }

    // 분할 정복 z, 먼저 4등분으로 나누고 원하는 칸이 있는 사분면을 알아냄
    public static void z(int row, int col, int size) {
        if(size == 1) {
            return;
        }
        if(row < size / 2 && col < size / 2) {
            z(row, col, size / 2);
        }
        else if(row < size / 2 && col >= size / 2) {
            count += size * size / 4;
            z(row, col - (size / 2), size / 2);
        }
        else if(row >= size / 2 && col < size / 2) {
            count += (size * size / 4) * 2;
            z(row - (size / 2), col, size / 2);
        }
        else {
            count += (size * size / 4) * 3;
            z(row - (size / 2), col - (size / 2), size / 2);
        }
    }
}