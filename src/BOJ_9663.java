import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ_9663 {
    public static int[] arr;
    public static int N; // 체스판의 크기 N * N
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        // 탐색
        nQueen(0);

        // 출력
        System.out.println(count);
    }

    public static void nQueen(int depth) {
        // 모든 원소를 다 채운 상태면 count 증가 및 return
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 재귀호출
            if (Possibility(depth)) {
                nQueen(depth + 1);
            }
        }

    }

    // 놓을 위치가 다른 퀸으로부터 위협받는지 검사
    public static boolean Possibility(int col) {
        for (int i = 0; i < col; i++) {
            // 같은 행에 위치할 경우
            if (arr[col] == arr[i]) {
                return false;
            }

            // 대각선상에 위치할 경우
            else if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
                return false;
            }
        }

        // 위 조건에 모두 해당하지 않는 경우 return true
        return true;
    }
}