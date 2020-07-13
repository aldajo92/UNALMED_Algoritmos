import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        List<Integer> list = IntStream.of(arr) // return Intstream
                .boxed() // Stream<Integer>
                .collect(Collectors.toList());
        System.out.println(list);
    }
}