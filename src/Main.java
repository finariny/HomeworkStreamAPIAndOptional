import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        addNumbersToList(numbers);

        // Задание 1

        System.out.println("Задание 1");
        findMinMax(numbers.stream(),
                Integer::compareTo,
                (x, y) -> System.out.println("Минимальный элемент: " + x + ". Максимальный элемент: " + y));

        // Задание 2

        System.out.println("Задание 2");
        findEvenNumbersAndCountTheirNumber(numbers);
    }

    private static <T> void findMinMax (Stream<? extends T> stream,
                             Comparator<? super T> order,
                             BiConsumer<? super T, ? super T> minMaxConsumer) {
        List <? extends T> list = stream.sorted(order).toList();
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    private static void findEvenNumbersAndCountTheirNumber (List<Integer> list) {
        System.out.println("Количество чётных чисел в списке: " + list.stream()
                .filter(n -> n % 2 == 0)
                .peek(System.out::println)
                .count());
    }

    private static void addNumbersToList(List<Integer> listOfNumbers) {
        listOfNumbers.add(345);
        listOfNumbers.add(872);
        listOfNumbers.add(124);
        listOfNumbers.add(79);
        listOfNumbers.add(1255);
        listOfNumbers.add(426);
        listOfNumbers.add(657);
    }
}