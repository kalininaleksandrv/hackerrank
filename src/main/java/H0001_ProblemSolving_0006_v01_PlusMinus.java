import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class H0001_ProblemSolving_0006_v01_PlusMinus {
    private static final Scanner scanner = new Scanner(System.in);

    static void plusMinus(int[] arr) {

        int[] noNullArray = Arrays.stream(arr).filter(i -> i != 0).toArray();

        float proportionOfNullable = 1 - ((float) noNullArray.length / (float) arr.length);

        int sumOfPositiveElements = Arrays.stream(noNullArray)
                .map(i -> i > 0 ? 1 : -1)
                .filter(i -> i > 0)
                .sum();

        float proportionOfPositive = (float) sumOfPositiveElements / (float) arr.length;

        System.out.println(proportionOfPositive);
        System.out.println(1-proportionOfNullable-proportionOfPositive);
        System.out.println(proportionOfNullable);

    }

    @SneakyThrows
    public void getSolution() {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }
}
