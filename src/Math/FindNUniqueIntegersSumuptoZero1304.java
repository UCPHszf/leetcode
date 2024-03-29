package Math;

public class FindNUniqueIntegersSumuptoZero1304 {
    public int[] sumZero(int n) {
        if (n == 1) return new int[]{0};
        int[] res = new int[n];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            res[i] = i + 1;
            sum += res[i];
        }
        res[n - 1] = -sum;
        return res;
    }
}
