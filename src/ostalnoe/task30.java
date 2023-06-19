package ostalnoe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class task30 {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину списка: ");
        int n = scanner.nextInt();
        System.out.print("Ввдите начало диапазона: ");
        int min = scanner.nextInt();
        System.out.print("Введите конец диапазона: ");
        int max = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * (max - min + 1) + min);
            numbers.add(num);
        }
        Collections.sort(numbers);


        System.out.print("Введите искомое число: ");
        int index = binarySearch(numbers, scanner.nextInt());
        if (index == -1)
            System.out.println("Заданное число не входит в список");
        else
            System.out.println("Индекс заданного числа в списке: " + index);
        System.out.println(numbers);
    }

    public static int binarySearch(List<Integer> numbers, int target) {
        int left = 0, right = numbers.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers.get(mid) == target) {
                return mid;
            } else if (numbers.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }



}