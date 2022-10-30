import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

// 리모컨
public class BOJ_1107 {
    static int N; // 이동하려는 채널
    static int M; // 고장난 버튼의 개수
    static int minCount = 1000000;
    static HashMap<Integer,String> brokenButton = new HashMap<Integer,String>(); // 고장난 버튼을 저장해둘 맵

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 고장난 버튼이 없으면 그대로 누르면 됨
        if(M == 0) {
            String len = Integer.toString(N);
            minCount = len.length();
        }
        else { // 고장난 버튼이 있으면 고장난 버튼 입력받기
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<M; i++) {
                brokenButton.put(Integer.parseInt(st.nextToken()), "");
            }
        }

        // 가장 적은 수로 눌러서 채널로 갈 수 있는 방법을 찾기, 다 찾아봄
        for(int i=0; i<=1000000; i++) {
            String len = Integer.toString(i); // +, - 외의 숫자 버튼도 누른 횟수임
            if(checker(i)) { // 고장난 버튼을 누르진 않는지 판별
                if(minCount > counter(i) + len.length()) {
                    minCount = counter(i) + len.length();
                }
            }
            else {
                continue;
            }
        }

        // 기본 채널이 100이기 때문에 더욱 적게 눌러서 움직일 수도 있는 경우
        if(counter(100) < minCount) {
            minCount = counter(100);
        }

        bw.write(String.valueOf(minCount));
        bw.close();
    }
    // 지금 누르려는 버튼이 고장난 버튼이 아닌지 판별하는 메소드 true면 사용 가능한 버튼
    static boolean checker(int n) {
        // 첫 케이스인 0인 경우 0이면 while문에 들어갈 수 없기때문에 따로 체크
        if(n == 0) {
            if(brokenButton.containsKey(0)) {
                return false;
            }
        }
        int temp = n;
        while(temp > 0) {
            if(brokenButton.containsKey(temp % 10)) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    // + 또는 - 를 사용할 때 몇 번 눌러야 하는지 계산해주는 메소드
    static int counter(int n) {
        return Math.abs(N - n);
    }
}