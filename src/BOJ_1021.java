import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 회전하는 큐
public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 큐의 크기 N과 뽑아내려고 하는 수의 개수 M 입력
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 덱 선언
        LinkedList<Integer> deque = new LinkedList<Integer>();

        // 2, 3번 연산 횟수 누적 합 변수
        int count = 0;

        // 1부터 N까지 덱에 담아둔다.
        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] seq = new int[M];	// 뽑고자 하는 수를 담은 배열

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++) {
            // 덱에서 뽑고자 하는 숫자의 위치(index) 찾기
            int target_idx = deque.indexOf(seq[i]);
            int half_idx;

            if(deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            }
            else {
                half_idx = deque.size() / 2;
            }

            // 중간 지점 또는 중간 지점보다 원소의 위치가 앞에 있을 경우
            if(target_idx <= half_idx) {
                // idx 보다 앞에 있는 원소들을 모두 뒤로 보낸다. (2번 연산)
                for(int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    count++;
                }
            }
            else {	// 중간 지점보다 원소의 위치가 뒤에 있는 경우
                // idx를 포함한 뒤에 있는 원소들을 모두 앞으로 보낸다. (3번 연산)
                for(int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    count++;
                }
            }
            deque.pollFirst();	// 연산이 끝나면 맨 앞 원소를 삭제
        }
        // 출력
        System.out.println(count);
    }
}