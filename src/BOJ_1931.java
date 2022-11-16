import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 회의실 배정
public class BOJ_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 회의 개수
        int N = Integer.parseInt(br.readLine());

        // 회의 시간 [][0]: 시작 시간, [][1]: 종료 시간
        int[][] meeting = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meeting[i][0] = start;
            meeting[i][1] = end;
        }

        // 회의 시간 정렬
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 종료 시간이 같으면, 빠르게 시작하는 회의순으로 정렬
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                // 아니면 먼저 종료하는 회의순으로 정렬
                else {
                    return o1[1] - o2[1];
                }
            }
        });

        int count = 0; // 최대 사용할 수 있는 회의 수
        int time = 0; // 최근 회의 종료 시간

        // 겹치지 않고 빨리 끝내야 많은 회의를 할 수 있음
        for(int i = 0; i < N; i++) {
            // 최근 종료된 시간이거나 그보다 더 지난 시간이면 회의 시작 가능
            if(time <= meeting[i][0]) {
                // 시작 가능한 회의의 종료시간을 time 에 저장 및 count 증가
                time = meeting[i][1];
                count++;
            }
        }

        // 출력
        bw.write(String.valueOf(count));
        bw.close();
    }
}
