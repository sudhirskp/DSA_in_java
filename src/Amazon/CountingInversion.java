package Amazon;

import java.util.ArrayList;
import java.util.List;

public class CountingInversion {

    public static long countInversions(List<Integer> arr) {
        ArrayList<Integer> list = new ArrayList<>(arr);
        int n = list.size();
        return mergeSort(list, 0, n - 1);
    }

    private static long mergeSort(List<Integer> arr, int l, int r) {
        long count = 0;

        if (l < r) {
            int mid = l + (r - l) / 2;
            count += mergeSort(arr, l, mid);
            count += mergeSort(arr, mid + 1, r);
            count += merge(arr, l, mid, r);
        }
        return count;
    }

    private static long merge(List<Integer> arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] cp1 = new int[n1];
        int[] cp2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            cp1[i] = arr.get(l + i);
        }

        for (int j = 0; j < n2; j++) {
            cp2[j] = arr.get(mid + j + 1);
        }

        int i = 0;
        int j = 0;
        int k = l;

        long count = 0;

        while (i < n1 && j < n2) {
            if (cp1[i] <= cp2[j]) {
                arr.set(k++, cp1[i++]);
            } else {
                arr.set(k++, cp2[j++]);
                count += (n1 - i);
            }
        }

        while (i < n1) {
            arr.set(k++, cp1[i++]);
        }

        while (j < n2) {
            arr.set(k++, cp2[j++]);
        }

        return count;
    }

public static void main(String[] args) {
        System.out.println(countInversions(List.of(2, 1, 3, 1, 2)));
    }
}
