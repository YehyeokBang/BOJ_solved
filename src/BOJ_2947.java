import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무조각
public class BOJ_2947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        do {
            for (int i = 0; i < 4; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;

                    for (int j = 0; j < 5; j++) {
                        System.out.print(arr[j] + " ");
                    }
                    System.out.println();
                }
            }

        } while (arr[0] != 1 || arr[1] != 2 || arr[2] != 3 || arr[3] != 4 || arr[4] != 5);
    }
}
