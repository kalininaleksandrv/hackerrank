import lombok.SneakyThrows;

import java.util.Scanner;

public class H0001_ProblemSolving_0007_v01_StairCase {

    private static final Scanner scanner = new Scanner(System.in);

    static void staircase(int n) {
        int countOfSymbol = 1;
        for (int i = 0; i < n; i++) {
            char[] chars = new char[n];
            for (int j = 0; j < n; j++) {
                chars[j] = j < n - countOfSymbol ? ' ' : '#';
            }
            System.out.println(new String(chars));
            countOfSymbol++;
        }

    }

    @SneakyThrows
    public void getSolution() {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        staircase(n);

        scanner.close();
    }
}
