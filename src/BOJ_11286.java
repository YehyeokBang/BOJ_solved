import java.io.*;
import java.util.PriorityQueue;

// 절댓값 힙
public class BOJ_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        PriorityQueue<AbsNum> queue = new PriorityQueue<>();

        // 연산
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(queue.poll().getNum()).append("\n");
                }
            }
            else {
                queue.add(new AbsNum(num));
            }
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 우선순위 큐안에 절댓값이 작은 순으로 정렬되어 구성되며 절댓값이 같은 경우
    // 원래의 값이 더 작은 수가 우선임
    static class AbsNum implements Comparable<AbsNum> {
        private int num;

        public AbsNum(int num) {
            this.num = num;
        }

        public int getNum() {
            return this.num;
        }

        public int getAbsNum() {
            return Math.abs(this.num);
        }

        @Override
        public int compareTo(AbsNum absNum) {
            // 절댓값 비교, 이 절댓값이 더 큰 경우 후순위
            if (Math.abs(this.num) > absNum.getAbsNum()) {
                return 1;
            }
            // 이 절댓값이 더 작은 경우 우선순위
            else if (Math.abs(this.num) < absNum.getAbsNum()) {
                return -1;
            }
            // 만약 절댓값이 같은 경우
            else {
                // 이 값이 더 큰 경우 후순위
                if(this.num > absNum.getNum()) {
                    return 1;
                }
                // 이 값이 더 작은 경우 우선순위
                else if(this.num < absNum.getNum()) {
                    return -1;
                }
                // 같으면 동일한 순위
                return 0;
            }
        }
    }
}