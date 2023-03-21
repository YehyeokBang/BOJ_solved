import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 과일의 개수, 스네이크버드의 초기 길이 값 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int fruit = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        // 과일의 높이를 저장할 배열 선언 및 초기화
        int[] heights = new int[fruit];

        // 과일의 개수만큼 높이를 입력 및 저장
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < fruit; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // 높이 정보 오름차순 정렬
        Arrays.sort(heights);

        for (int height : heights) {
            // 스네이크버드의 길이가 과일이 있는 높이보다 길거나 같으면
            // 과일을 먹으면서 길이 1만큼 증가
            if (length >= height) {
                length++;
            } else { // 더 이상 과일을 먹을 수 없으면 종료 = 늘어날 수 있는 최대 길이
                break;
            }
        }

        // 출력
        System.out.println(length);
    }
}