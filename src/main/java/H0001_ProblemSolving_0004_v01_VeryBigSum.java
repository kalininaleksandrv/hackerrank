import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class H0001_ProblemSolving_0004_v01_VeryBigSum {

    private static final Scanner scanner = new Scanner(System.in);

    private static long aVeryBigSum(long[] ar) {
        return Arrays.stream(ar).sum();
    }

    @SneakyThrows
    public void getSolution() {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/eyesless/Загрузки/triplets"));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] ar = new long[arCount];

        String[] arItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            long arItem = Long.parseLong(arItems[i]);
            ar[i] = arItem;
        }
        long result = aVeryBigSum(ar);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        bufferedWriter.close();
        scanner.close();
    }
}
