import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// 베스트셀러
public class BOJ_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력, 하루 동안 팔린 책의 개수
        int N = Integer.parseInt(br.readLine());

        // 하루 동안 팔린 책의 제목과, 판매량을 저장할 해시맵
        HashMap<String,Integer> map = new HashMap<String,Integer>();

        // 팔린 책 제목 입력
        String s = "";
        for(int i = 0; i < N; i++) {
            s = br.readLine();

            // 만약 이미 팔린 적이 있는 책이라면, 팔린 횟수 + 1
            if(map.containsKey(s)) {
                map.replace(s, map.get(s) + 1);
            }
            // 아니라면, 새롭게 추가
            else {
                map.put(s, 1);
            }
        }

        // 가장 많이 팔린 횟수, 가장 많이 팔린 책이 여러 개일 수 있음
        int max = 0;
        for(String bookName : map.keySet()) {
            max = Math.max(max, map.get(bookName));
        }

        // 사전 순으로 정렬
        ArrayList<String> bookArray = new ArrayList<>(map.keySet());
        Collections.sort(bookArray);

        // 가장 많이 팔린 책, 판매량이 같으면 제목이 사전 순으로 앞선 책의 제목을 출력
        for(String bookName : bookArray) {
            // 이미 사전 순으로 정렬되어 있음, 가장 먼저 조건에 충족하는 책 제목 출력
            if(map.get(bookName) == max) {
                bw.write(bookName);
                break;
            }
        }
        bw.close();
    }
}