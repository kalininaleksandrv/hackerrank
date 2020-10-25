import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class H0001_ProblemSolving_0002_v01_SimpleArraySumm {
    private static final Scanner scanner = new Scanner(System.in);

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        int summ = 0;
        for (int j : ar) {
            summ = summ + j;
        }

        System.out.println("ar " + Arrays.toString(ar));
        return summ;
    }

    public void getSolution() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/eyesless/Загрузки/simpleoutput"));

        int arCount = Integer.parseInt(scanner.nextLine().trim());

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");

        for (int arItr = 0; arItr < arCount; arItr++) {
            int arItem = Integer.parseInt(arItems[arItr].trim());
            ar[arItr] = arItem;
        }

        int result = simpleArraySum(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
