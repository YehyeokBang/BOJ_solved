import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 너의 평점은
public class BOJ_25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str[] = new String[20];
        double totalSum = 0;
        double scoreSum = 0;

        // A+ ~ P 평점과 점수를 배열에 저장
        String gradeList[] = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0", "F", "P"};
        double gradeScore[] = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0, 0.0, 0.0};

        // 20개의 과목명, 학점, 등급에 대한 정보를 입력받음
        for (int i = 0; i < 20; i++) {
            str[i] = br.readLine();
            StringTokenizer st = new StringTokenizer(str[i], " ");
            st.nextToken(); // 과목 이름은 필요 없으므로 버림
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            // 입력받은 등급에 따라 총점과 학점을 계산
            for (int j = 0; j < 10; j++) {
                if (grade.equals(gradeList[j])) {
                    totalSum += score * gradeScore[j];
                    if (j != 9) {
                        scoreSum += score;
                    }
                }
            }
        }

        // 총점을 학점으로 나누어 평균을 구함
        double average = totalSum / scoreSum;
        System.out.printf("%.6f\n", average);
    }
}