import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.io.IOException;

// AC
public class BOJ_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i=0; i<testCase; i++) {
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String [] inputArray = (br.readLine().trim().replace("[", "").replace("]", "")).split(",");

            Deque<Integer> array = new LinkedList<Integer>();
            for (int j=0; j<n ; j++) {
                array.add(Integer.parseInt(inputArray[j]));
            }

            boolean checkError = false;
            boolean checkFliped = false;
            for (int k=0; k<function.length(); k++) {
                if(function.charAt(k) == 'R') {
                    checkFliped = !checkFliped;
                    continue;
                } // true:뒤집힌 상태

                if(function.charAt(k) == 'D') {
                    if(array.size() == 0) {
                        checkError=true;
                        break;
                    }
                    if(checkFliped)
                        array.pollLast();
                    else
                        array.pollFirst();
                } // 플립 상태에 따라 맨 앞/뒤 요소 삭제
            }
            if(checkError) {
                result.append("error\n");
            } // 에러일 경우 넘어가기
            else {
                result.append("[");
                if (checkFliped) {
                    while (!array.isEmpty()) {
                        result.append(array.pollLast());
                        if (array.isEmpty())
                            break;
                        result.append(",");
                    }
                }
                else {
                    while (!array.isEmpty()) {
                        result.append(array.pollFirst());
                        if (array.isEmpty())
                            break;
                        result.append(",");
                    }
                }
                result.append("]\n");
            } // 맨 앞/뒤 요소 찾는 것이 압도적으로 빠르나 인덱스로 접근하면 수에 비례해서 느려짐
        }
        bw.write(String.valueOf(result));
        bw.close();
    }
}