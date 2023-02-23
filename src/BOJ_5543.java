import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 상근날드
public class BOJ_5543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 햄버거 3개 가격 입력 및 햄버거 최저가 알아내기
        int burger1 = Integer.parseInt(br.readLine());
        int burger2 = Integer.parseInt(br.readLine());
        int burger3 = Integer.parseInt(br.readLine());

        int minBurgerPrice = Math.min(burger1, Math.min(burger2, burger3));

        // 음료 2개 가격 입력 및 음료 최저가 알아내기
        int beverage1 = Integer.parseInt(br.readLine());
        int beverage2 = Integer.parseInt(br.readLine());

        int minBeveragePrice = Math.min(beverage1, beverage2);

        // 만들 수 있는 최소 세트 가격 출력
        System.out.print(minBurgerPrice + minBeveragePrice - 50);
    }
}