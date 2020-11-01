import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class H0001_ProblemSolving_0008_v01_minMaxSum {

    private static final Scanner scanner = new Scanner(System.in);

    private static void miniMaxSum(int[] arr) {
        int sumOfMax = Arrays.stream(arr)
                .sorted()
                .skip(1)
                .sum();

        int sumOfMin = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("unable to calculate"));

        System.out.println(sumOfMin + " " + sumOfMax);
    }

    public void getSolution() {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
