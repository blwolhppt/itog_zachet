package ostalnoe;

import java.util.BitSet;
import java.util.Scanner;

public class task31 {
    public static void main(String[] args) {
        BitSet bitSet1 = new BitSet(8);
        BitSet bitSet2 = new BitSet(8);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите диапазон битов: ");
        int start1 = scanner.nextInt(), end1 = scanner.nextInt();
        bitSet1.set(start1, end1);
        System.out.print("Введите диапазон битов: ");
        int start2 = scanner.nextInt(), end2 = scanner.nextInt();
        bitSet2.set(start2, end2);




        BitSet resultAnd = new BitSet();
        resultAnd = (BitSet) bitSet1.clone();
        resultAnd.and(bitSet2); // данная операция оставляет только одинаковые биты
        System.out.println("Операция AND: " + resultAnd);

        BitSet resultOr = new BitSet();
        resultOr = (BitSet) bitSet1.clone();
        resultOr.or(bitSet2);  // операция добавляет биты из bitSet2, если их нет в resultOr
        System.out.println("Операция OR: " + resultOr);


        BitSet resultXor = new BitSet();
        resultXor = (BitSet) bitSet1.clone();
        resultXor.xor(bitSet2);  // эта операция устанавливает неповторящиеся биты
        System.out.println("Операция XOR: " + resultXor);


        //Маскирование
        BitSet mask = new BitSet(8);
        System.out.println("Введите диапазон для маски: ");
        int a = scanner.nextInt(), b = scanner.nextInt();
        mask.set(a, b);

        BitSet resultMask = new BitSet();
        resultMask = (BitSet) bitSet1.clone();
        resultMask.and(mask);
        System.out.println("Маскирование: " + resultMask); // будет содержать только те биты, которые установлены в битовой маске mask.
    }
}