import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 파일 정리
public class BOJ_20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 파일의 개수
        int n = Integer.parseInt(br.readLine());

        // 파일의 확장자를 key로, 개수를 value로 저장
        HashMap<String, Integer> map = new HashMap<>();

        // 입력받은 문자열에서 확장자만 추출
        for(int i = 0; i < n; i++) {
            // 파일 이름 입력받고 .으로 split
            String[] file = br.readLine().split("\\.");
            // 확장자만 추출
            String extension = file[1];

            if(map.containsKey(extension)) {
                // 이미 map에 존재하는 확장자면 value + 1
                map.put(extension, map.get(extension) + 1);
            } else {
                // 존재하지 않는 확장자면 value = 1
                map.put(extension, 1);
            }
        }

        // 확장자를 사전순으로 정렬 후 출력
        map.keySet().stream().sorted().forEach(key -> System.out.println(key + " " + map.get(key)));
    }
}