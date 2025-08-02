package Other;

public class LandWaterRider {

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int ls = landStartTime.length;
        int ws = waterStartTime.length;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < ls; i++) {
            for (int j = 0; j < ws; j++) {
                int landfinsh = Math.max(landStartTime[i], 0)
                        + landDuration[i];
                int waterStart = Math.max(waterStartTime[j], landfinsh);
                int total = waterStart + waterDuration[j];
                min = Math.min(total, min);


                int Waterfinsh = Math.max(waterStartTime[j], 0) + waterDuration[j];
                int landStart = Math.max(landStartTime[i], Waterfinsh);
                int total1 = landStart + landDuration[i];
                min = Math.min(total1, min);
            }

        }
        return min;
    }

    public static void main(String[] args) {
        int landStartTime[] = {99};
        int landDuration[] = {59};
        int waterStartTime[] = {99,54};
        int waterDuration[] = {85,20};
        LandWaterRider ob = new LandWaterRider();
        int ans = ob.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println(ans);
    }
}

//leetCode - Contest biweekly -02/08/25
