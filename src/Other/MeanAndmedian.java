package Other;

public class MeanAndmedian {

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 6, 5, 8};
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double mean = (double) sum / n;
        System.out.println("Mean: " + mean);

        if (n % 2 == 0) {
            double median = (double) (arr[n / 2 - 1] + arr[n / 2]) / 2;
            System.out.println("Median: " + median);
        } else {
            double median = arr[n / 2];
            System.out.println("Median: " + median);
        }
    }
}
