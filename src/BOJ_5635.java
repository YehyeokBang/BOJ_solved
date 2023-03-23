import java.io.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// 생일
public class BOJ_5635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 학생의 수 n 입력
        int n = Integer.parseInt(br.readLine());

        String[][] people = new String[n][2];

        // 학생의 이름과 생일 입력
        for (int i = 0; i < n; i++) {
            // 한 줄 입력
            st = new StringTokenizer(br.readLine());

            // 이름 저장
            people[i][0] = st.nextToken();

            // 생일 -> milliseconds -> String 형변환 저장
            int date = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            people[i][1] = String.valueOf(LocalDate.of(year, month, date).toEpochDay());
        }

        // 생일 기준으로 오름차순 정렬
        Arrays.sort(people, new Comparator<String[]>() {
            @Override
            public int compare(String[] p1, String[] p2) {
                if (Long.parseLong(p1[1]) < Long.parseLong(p2[1])) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });

        // 출력
        bw.write(people[0][0]);
        bw.write("\n");
        bw.write(people[n - 1][0]);
        bw.close();
    }
}