import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class H0001_ProblemSolving_0005_v01_DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        AtomicInteger firstDiag = new AtomicInteger(0);
        AtomicInteger secondDiag = new AtomicInteger(0);
        AtomicInteger removeCount = new AtomicInteger(0);

        arr.forEach(firstLevel ->{
            firstDiag.addAndGet(firstLevel.get(removeCount.getAndIncrement()));
            secondDiag.addAndGet(firstLevel.get(firstLevel.size() - removeCount.get()));

        });
        return Math.abs(firstDiag.get() - secondDiag.get());
    }

    @SneakyThrows
    public void getSolution() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/eyesless/Загрузки/triplets"));
        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
