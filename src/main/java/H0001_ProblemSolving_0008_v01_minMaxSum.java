import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class H0001_ProblemSolving_0008_v01_minMaxSum {

    private static final Scanner scanner = new Scanner(System.in);

    private static void miniMaxSum(int[] arr) {
        long sumOfMax = Arrays.stream(arr)
                .asLongStream()
                .sorted()
                .skip(1)
                .sum();

        long sumOfMin = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .map(Long::valueOf)
                .reduce(Long::sum)
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
