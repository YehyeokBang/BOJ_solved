import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

// 단지번호붙이기
public class BOJ_2667 {
    static int N; // 지도의 크기
    static int[][] map; // 지도
    static boolean[][] visited; // dfs 방문 여부
    static int town_count = 0; // 단지 수
    static int house_count = 0; // 단지 내 집의 수
    static StringBuilder sb = new StringBuilder(); // 단지 내 집의 수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        // 단지 내 집의 수 저장할 리스트
        LinkedList<Integer> house = new LinkedList<>();

        // 지도 입력받기
        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        // 지도를 탐색하며, 단지와 단지별 집의 수를 알아냄
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    if(!visited[i][j]) {
                        dfs(i, j);
                        // 한 단지를 탐색할 때마다 단지 수 증가
                        town_count++;
                        // dfs로 단지 내 집의 수를 알아낸 후 리스트에 저장
                        house.add(house_count);
                        // 다른 단지를 알아내기 위해 0으로 초기화
                        house_count = 0;
                    }
                }
            }
        }
        // 각 단지별 집의 수를 오름차순으로 정렬
        Collections.sort(house);
        while(house.size() != 0) {
            sb.append(house.removeFirst());
            // 마지막이 아니면 줄바꿈 문자
            if(house.size() != 0) {
                sb.append('\n');
            }
        }

        // 출력
        bw.write(String.valueOf(town_count));
        bw.write("\n");
        bw.write(String.valueOf(sb));
        bw.close();
    }

    // 위, 아래, 좌, 우로 붙어있는 집이 있다면 탐색하며 단지와 단지 내 집의 수를 알아내는 방식
    static void dfs(int row, int col) {
        // 집을 방문하면 단지 내 집의 수 증가 + 방문 표시
        house_count++;
        visited[row][col] = true;

        // 위
        if(row - 1 >= 0) {
            if(map[row - 1][col] == 1 && !visited[row - 1][col]) {
                dfs(row - 1, col);
            }
        }
        // 아래
        if(row + 1 < N) {
            if(map[row + 1][col] == 1 && !visited[row + 1][col]) {
                dfs(row + 1, col);
            }
        }
        // 좌
        if(col - 1 >= 0) {
            if(map[row][col - 1] == 1 && !visited[row][col - 1]) {
                dfs(row, col - 1);
            }
        }
        // 우
        if(col + 1 < N) {
            if(map[row][col + 1] == 1 && !visited[row][col + 1]) {
                dfs(row, col + 1);
            }
        }
    }
}