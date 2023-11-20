import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 뒤집힌 덧셈
public class BOJ_1357 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");


        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        bw.write(Rex(Rex(X) + Rex(Y)) + "");
        bw.flush();
    }

    static int Rex(int num){
        StringBuilder sb = new StringBuilder(num +"");
        sb.reverse();		//바꾸기
        return Integer.parseInt(sb.toString());
    }
}
