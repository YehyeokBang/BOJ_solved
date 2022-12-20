import java.io.*;

// 비즈네르 암호 해독
public class BOJ_26266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 평문, 암호문 입력
        String[] plainTextArr = br.readLine().split("");
        String[] cryptogramArr = br.readLine().split("");

        int[] plainTextNum = new int[plainTextArr.length];  // 평문 숫자
        int[] cryptogramNum = new int[cryptogramArr.length]; // 암호문 숫자

        // 알파벳과 수 대응
        for(int i = 0; i < plainTextArr.length; i++) {
            plainTextNum[i] = plainTextArr[i].charAt(0) - 64;
            cryptogramNum[i] = cryptogramArr[i].charAt(0) - 64;
        }

        // 암호문 - 평문으로 (키를 단순 반복한) 키 숫자 배열을 알아냄
        int[] keyNum = new int[plainTextArr.length];
        for(int i = 0; i < plainTextArr.length; i++) {
            // 만약 0보다 아래라면 26을 더해서 1 ~ 26으로 만듬
            if(cryptogramNum[i] - plainTextNum[i] < 1) {
                keyNum[i] = cryptogramNum[i] - plainTextNum[i] + 26;
            }
            else {
                keyNum[i] = cryptogramNum[i] - plainTextNum[i];
            }
        }

        // (키를 단순 반복한) 키 숫자 배열을 문자열로 만듬
        String keyString = "";
        for(int i = 0; i < plainTextArr.length; i++) {
            keyString += String.valueOf((char)(keyNum[i] + 64));
        }

        // 가능한 키 중 가장 짧은 키를 찾음
        String key = "";

        // 키 하나씩 대응해보기
        for(int i = 0; i <= plainTextArr.length; i++) {
            String temp = keyString;

            // 확인해볼 키가 있으면 빈 문자열로 만듬
            temp = temp.replace(keyString.substring(0, i), "");

            // 만약 확인해본 키가 가능한 키면 출력
            if(temp.equals("")) {
                key = keyString.substring(0, i);
                break;
            }
        }

        // 출력
        bw.write(key);
        bw.close();
    }
}