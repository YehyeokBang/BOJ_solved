import java.io.*;
import java.util.StringTokenizer;

// 중간고사 채점
public class BOJ_15702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        StringTokenizer st;

        // 문제의 개수: N, 응시자의 수: M
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 문제의 배점
        st = new StringTokenizer(br.readLine(), " ");
        int[] scores = new int[N];
        for(int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        // 학생 번호, 총 점수
        int studentNo = 0;
        int score = 0;

        // 입력받음과 동시에 점수 계산으로 가장 높은 점수를 얻은 학생 알아내기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <= N; j++) {
                // NoSuchElementException 방지
                if(!st.hasMoreTokens()) {
                    break;
                }
                int tempStudentNo = Integer.parseInt(st.nextToken());
                int tempScore = 0;
                // 각 시험을 맞춘 경우 점수에 추가
                for(int test = 0; test < N; test++) {
                    if(st.nextToken().equals("O")) {
                        tempScore += scores[test];
                    }
                }
                // 가장 높은 점수를 받은 학생
                if(score < tempScore) {
                    studentNo = tempStudentNo;
                    score = tempScore;
                }
                // 만약 가장 높은 점수를 받은 학생이 여러 명일 경우, 수험번호 작은 순
                else if(score == tempScore) {
                    studentNo = studentNo < tempStudentNo ? studentNo : tempStudentNo;
                    // 모든 학생이 시험을 0점 받은 경우 방지
                    if(studentNo == 0 && score == 0) {
                        studentNo = tempStudentNo;
                    }
                }
            }
        }

        // 출력
        sb.append(studentNo).append(" ").append(score);
        bw.write(String.valueOf(sb));
        bw.close();
    }
}