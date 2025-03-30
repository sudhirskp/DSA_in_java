package Other;

public class RemoveBlength {
    public String solve(String A, int B) {
        StringBuilder result = new StringBuilder();
        int n = A.length();
        int i = 0;

        while (i < n) {
            int count = 1;

            // Count the length of the current sequence of identical characters
            while (i + 1 < n && A.charAt(i) == A.charAt(i + 1)) {
                i++;
                count++;
            }

            // If the sequence length is not equal to B, add it to the result
            if (count != B) {
                for (int j = 0; j < count; j++) {
                    result.append(A.charAt(i));
                }
            }

            i++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        RemoveBlength ob = new RemoveBlength();
        String a=ob.solve("aabbcd",2);
        System.out.println(a);
    }
}
