import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
public class sort {
    
    public static int[] createArray() {
        System.out.print("Задайте размер массива: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] input = new int[size];
        System.out.println("Введите элементы массива через пробел:");
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
        }
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(input));
        return input;
    }

    public static int[] mergeSort(int[] sortArr) {
        int[] buffer1 = Arrays.copyOf(sortArr, sortArr.length);
        int[] buffer2 = new int[sortArr.length];
        int[] result = mergeSortInner(buffer1, buffer2, 0, sortArr.length);
        return result;
    }

    public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }
    
    public static void main(String args[]) {
        int[] sortArr = createArray();
        int[] result = mergeSort(sortArr);
        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(result));
    }
}