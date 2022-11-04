import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

// 이진 검색 트리
public class BOJ_5639 {
    static Integer[] tree = new Integer[10001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int index = 0; // 처음 입력 받을 때 사용하는 인덱스

        // EOF로 입력의 끝을 알려야 함, WINDOW : Ctrl + D
        String input;
        while((input = br.readLine()) != null) {
            tree[index++] = Integer.parseInt(input);
        }

        postorder(0, index - 1);

        // 출력
        bw.write(String.valueOf(sb));
        bw.close();
    }

    /*
        이진 검색 트리에서 왼쪽은 자신의 크기보다 작은 노드들만 있고,
        오른쪽은 자신의 크기보다 큰 노드들만 있음 (문제 기준으로 중복은 없음)
        => 제일 앞은 부모 노드로 하고 차례대로 보다가 부모보다 큰 노드를
           발견하면 오른쪽 노드임
     */
    static public void postorder(int n, int end) {
        if(n > end) {
            return;
        }

        int mid = n + 1;
        while (mid <= end && tree[mid] < tree[n]) {
            mid++;
        }

        postorder(n + 1, mid - 1);
        postorder(mid, end);
        sb.append(tree[n]).append("\n");
    }
}
