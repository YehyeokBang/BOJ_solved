import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 배열 A와 B의 사이즈를 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        int bSize = Integer.parseInt(st.nextToken());

        // 처음부터 하나의 배열을 사용해 값을 저장하고 정렬할 계획
        int[] array = new int[aSize + bSize];
        int index = 0; // A, B 배열의 값을 넣을 때 사용하는 공통 인덱스 변수

        // 배열 A의 값 넣기
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            array[index++] = Integer.parseInt(st.nextToken());
        }

        // 배열 B의 값 넣기
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            array[index++] = Integer.parseInt(st.nextToken());
        }

        // 오름차순 정렬
        Arrays.sort(array);

        // 출력
        for (int i : array) {
            bw.write(String.valueOf(i));
            bw.write(" ");
        }
        bw.close();
    }
}