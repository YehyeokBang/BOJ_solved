import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주유쇼
public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cityCount = Integer.parseInt(br.readLine());

        long[] distance = new long[cityCount - 1];
        long[] price = new long[cityCount];

        String[] distanceStr = br.readLine().split(" ");
        String[] priceStr = br.readLine().split(" ");

        for (int i = 0; i < cityCount - 1; i++) {
            distance[i] = Long.parseLong(distanceStr[i]);
        }

        for (int i = 0; i < cityCount; i++) {
            price[i] = Long.parseLong(priceStr[i]);
        }

        long minPrice = price[0];
        long sum = 0;

        // 현재 도시의 기름값이 이전 도시의 기름값보다 싸면 이전 도시의 기름값으로 갱신 후 거리를 곱한다.
        for (int i = 0; i < cityCount - 1; i++) {
            if (price[i] < minPrice) {
                minPrice = price[i];
            }
            sum += minPrice * distance[i];
        }

        System.out.println(sum);
    }
}
