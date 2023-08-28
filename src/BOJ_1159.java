import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 농구 경기
public class BOJ_1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 인원 수 입력
        int n = Integer.parseInt(br.readLine());

        // 선수 이름의 첫 글자와 첫 글자의 개수를 저장할 맵
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            // 선수 이름의 첫 글자를 key로 가지는 값이 없으면 1로 초기화
            if (!map.containsKey(name.charAt(0))) {
                map.put(name.charAt(0), 1);
            } else {
                // 선수 이름의 첫 글자를 key로 가지는 값이 있으면 1 증가
                map.put(name.charAt(0), map.get(name.charAt(0)) + 1);
            }
        }

        // 선수 이름의 첫 글자를 저장할 리스트
        List<Character> list = new ArrayList<>();

        for (char key : map.keySet()) {
            // 선수 이름의 첫 글자의 개수가 5 이상이면 리스트에 추가
            if (map.get(key) >= 5) {
                list.add(key);
            }
        }

        // 리스트에 값이 없으면 "PREDAJA" 출력
        if (list.size() == 0) {
            System.out.println("PREDAJA");
        } else {
            // 리스트에 값이 있으면 오름차순으로 정렬하여 출력
            list.sort(null);
            for (char c : list) {
                System.out.print(c);
            }
        }
    }
}