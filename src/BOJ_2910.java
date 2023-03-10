import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 빈도 정렬
public class BOJ_2910 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 메시지의 길이 N과 C가 주어짐
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // LinkedHashMap<숫자, 빈도>
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

        // 숫자 입력 및 빈도 계산
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken()); // 입력한 숫자

            if(hashMap.containsKey(num)) { // 이미 입력받은 숫자일 경우 빈도 추가
                hashMap.put(num, hashMap.get(num) + 1);
            }
            else { // 아닐 경우 해시맵에 추가
                hashMap.put(num, 1);
            }
        }

        // key 모두 배열에 저장
        ArrayList<Integer> keys = new ArrayList<Integer>(hashMap.keySet());

        // 기준에 따라 정렬
        keys.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(hashMap.get(o2), hashMap.get(o1));
            }
        });

        // Iterator 이용해 출력
        for (Integer element : keys) {
            for (int i = 0; i < hashMap.get(element); i++) {
                System.out.print(element + " ");
            }
        }
    }
}