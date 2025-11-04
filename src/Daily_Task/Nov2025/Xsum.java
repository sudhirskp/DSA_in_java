package Daily_Task.Nov2025;

import java.util.ArrayList;
import java.util.List;

public class Xsum {

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {
            res[i] = xsum(i, i + k - 1, nums, x);
        }

        return res;
    }

    int xsum(int st, int end, int[] nums, int x) {
        int[] freq = new int[51];
        for (int i = st; i <= end; i++) {
            freq[nums[i]]++;
        }

        List<int[]> pairs = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) pairs.add(new int[]{i, freq[i]});
        }

        pairs.sort((a, b) -> {
            if (b[1] == a[1]) return b[0] - a[0];
            return b[1] - a[1];
        });

        int sum = 0;
        for (int i = 0; i < Math.min(x, pairs.size()); i++) {
            sum += pairs.get(i)[0] * pairs.get(i)[1];
        }

        return sum;
    }

    public static void main(String[] args) {
        Xsum xsum = new Xsum();
        int[] nums = {1,1,2,2,3,4,2,3};
        int k = 6;
        int x = 2;
        int[] res = xsum.findXSum(nums, k, x);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
//LeetCode : 3318
