import java.io.*;

// 재귀함수가 뭔가요?
public class BOJ_17478 {
    static int N;
    static StringBuilder sb = new StringBuilder("");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        N = Integer.parseInt(br.readLine());

        // 재귀함수 호출
        function(N);

        // 출력
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        bw.write(String.valueOf(sb));
        bw.close();
    }

    static void function(int n) {
        String temp = "";
        for(int i = 0; i < N - n; i++) {
            temp += "____";
        }
        sb.append(temp);
        sb.append("\"재귀함수가 뭔가요?\"\n");
        if(n == 0) {
            sb.append(temp).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            sb.append(temp).append("라고 답변하였지.\n");
        }
        else {
            sb.append(temp).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            sb.append(temp).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            sb.append(temp).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
            function(n - 1);
            sb.append(temp).append("라고 답변하였지.\n");
        }
    }
}