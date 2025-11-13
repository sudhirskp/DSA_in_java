package Daily_Task.Nov2025;

public class MoveOneToEnd {

    public int maxOperations(String s) {
        int totalOperations = 0;

        int onesCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == '1') {
                onesCount++;
            } else if (currentChar == '0') {
                if (i > 0 && s.charAt(i - 1) == '1') {
                    totalOperations += onesCount;
                }
            }
        }

        return totalOperations;
    }

    public static void main(String[] args) {
        MoveOneToEnd moveOneToEnd = new MoveOneToEnd();
        String s = "110100";
        System.out.println(moveOneToEnd.maxOperations(s));
    }
}
//leetCode 3228
//13 nov 2025
//Time : O(n)
