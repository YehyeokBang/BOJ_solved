import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 빗물
public class BOJ_14719 {
    static int h, w;
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 세로 h, 가로 w 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        height = new int[w];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for(int i = 1; i < w - 1; i++) {
            int left = 0;
            int right = 0;

            for(int j = 0; j < i; j++) {
                left = Math.max(height[j], left);
            }

            for(int j = i + 1; j < w; j++) {
                right = Math.max(height[j], right);
            }

            if(height[i] < left && height[i] < right) {
                result += Math.min(left, right) - height[i];
            }
        }

        // 출력
        System.out.println(result);
    }
}
