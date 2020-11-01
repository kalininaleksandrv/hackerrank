import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class H0001_ProblemSolving_0009_v01_cakeCandles implements Solution {
    static int birthdayCakeCandles(List<Integer> candles) {

        AtomicInteger countOfCandles = new AtomicInteger(1);

        candles.stream()
                .sorted(Collections.reverseOrder())
                .reduce((i1, i2) -> {
                    if (i1.equals(i2)) {
                        countOfCandles.incrementAndGet();
                       return i1;
                    } else return 0;
                });
        return countOfCandles.get();
    }

    @Override
    public void getSolution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/eyesless/Загрузки/simpleoutput"));

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
