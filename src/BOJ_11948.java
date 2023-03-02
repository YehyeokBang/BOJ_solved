import java.io.*;
import java.util.Arrays;

// 과목선택
public class BOJ_11948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 과목 점수 저장 배열 선언
        // 점수 합계 저장 변수
        int[] score1 = new int[4];
        int[] score2 = new int[2];
        int sum = 0;

        // 과탐 과목
        for(int i = 0; i < 4; i++) {
            score1[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(score1);

        // 사탐 과목
        for(int i = 0; i < 2; i++) {
            score2[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(score2);

        // 점수 계산
        for(int i = 1; i < 4; i++) {
            sum += score1[i];
        }
        sum += score2[1];

        // 출력
        bw.write(String.valueOf(sum));
        bw.close();
    }
}