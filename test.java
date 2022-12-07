import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class test {
    public static void main(String[] args) {
        System.out.print("Задайте размер массива: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] input = new int[size];
        System.out.println("Введите элементы массива через пробел:");
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(input));
    }
}
