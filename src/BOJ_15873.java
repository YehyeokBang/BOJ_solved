import java.util.Scanner;

// 공백 없는 A+B
public class BOJ_15873 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        // 앞의 숫자가 두 자리 수 이하이고 뒤의 숫자가 한 자리 수일 때
        int result = (A / 10) + (A % 10);

        // 앞의 숫자가 한 자리 수이고 뒤의 숫자가 두 자리 수 이하일 때
        if (A / 10 > 10) {
            result = (A / 100) + (A % 100);
        }

        // 앞과 뒤 모두 두 자리 수일 때(경우의 수는 1)
        if (A == 1010) {
            result = 20;
        }

        System.out.println(result);
    }
}