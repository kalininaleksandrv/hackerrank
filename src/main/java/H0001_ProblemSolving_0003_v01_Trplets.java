import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class H0001_ProblemSolving_0003_v01_Trplets {

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        AtomicInteger count = new AtomicInteger(0);
        Integer[] aliceAndBob = new Integer[]{0, 0};

        final List<Integer[]> pairs = a
                .stream()
                .map(item -> {
                    Integer[] myPair = new Integer[a.size()];
                    myPair[0] = item;
                    myPair[1] = b.get(count.getAndIncrement());
                    return myPair;
                })
                .collect(Collectors.toList());

        pairs.forEach(pair -> {

            if (pair[0] > pair[1]) {
                aliceAndBob[0]++;
            }
            if (pair[0] < pair[1]) {
                aliceAndBob[1]++;
            }
        });
        return Arrays.stream(aliceAndBob).collect(Collectors.toList());
    }

    @SneakyThrows
    public void getSolution() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/home/eyesless/Загрузки/triplets"));

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> b = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = compareTriplets(a, b);

        assert result != null;

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
