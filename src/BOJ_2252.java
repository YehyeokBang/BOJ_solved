import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 비교한 정보 받기
        String[] compare = br.readLine().split(" ");

        // 학생 수 n, 키 비교 횟수 m
        int n = Integer.parseInt(compare[0]);
        int m = Integer.parseInt(compare[1]);

        // 위상정렬에 사용할 진입차수 저장 배열
        int[] edgeCount = new int[n + 1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] temp = br.readLine().split(" ");
            graph.get(Integer.parseInt(temp[0])).add(Integer.parseInt(temp[1]));
            edgeCount[Integer.parseInt(temp[1])]++;
        }

        // 위상정렬에 사용할 큐
        Queue<Integer> q = new LinkedList<>();

        // 진입차수가 0인 값 큐에 넣기
        for (int i = 1; i < edgeCount.length; i++) {
            if (edgeCount[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int studentNo = q.poll();

            bw.write(studentNo + " ");

            // 꺼낸 학생 번호의 키 비교한 정보 가져오기
            List<Integer> list = graph.get(studentNo);

            // 키를 비교한 정보의 개수 만큼 반복문 실행
            for (int temp : list) {
                edgeCount[temp]--;
                if (edgeCount[temp] == 0) {
                    q.offer(temp);
                }
            }
        }

        // 출력
        bw.close();
    }
}