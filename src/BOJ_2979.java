import java.io.*;
import java.util.StringTokenizer;

// 트럭 주차
public class BOJ_2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());	// 1대
        int b = Integer.parseInt(st.nextToken());	// 2대
        int c = Integer.parseInt(st.nextToken());	// 3대

        int min = 101;
        int max = 0;
        int[][] truck = new int[3][2];
        int[] arr = new int[100];
        int fee = 0;

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            truck[i][0] = start;
            truck[i][1] = end;

            // 해당 시간에 들어온 트럭 체크
            for(int j = start; j < end; j++) {
                arr[j]++;
            }
        }

        // 가장 먼저, 가장 늦게 나간 트럭의 시간 찾기
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 2; j++) {
                if(truck[i][j] < min)	min = truck[i][j];
                if(truck[i][j] > max)	max = truck[i][j];
            }
        }

        // 주차 요금구하기 해당 시간에 주차  트럭이 1대면 대당 A원, 2대면 대당 B원, 3대명 대당 C원
        for(int i = min; i < max; i++) {
            fee += (arr[i] == 1) ? arr[i] * a : 0;
            fee += (arr[i] == 2) ? arr[i] * b : 0;
            fee += (arr[i] == 3) ? arr[i] * c : 0;
        }

        System.out.println(fee);
    }
}