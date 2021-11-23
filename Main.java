import java.util.Arrays;
import java.util.Scanner;

/**
 * Main
 */
public class Main {

    public class pair {
        public long first, second;
        pair(long a, long b) {
            first = a;
            second = b;
        }
    }

    public static long distanceFromOrigin(pair x) {
        return x.first * x.first + x.second * x.second;
    }

    public static boolean isFeasible(long distances[], double mid, long k) {
        int count = 0;
        for (long distance : distances) {
            if (distance <= mid*mid) {
                count++;
            }
            if(count >= k) return true;
        }
        return false;
    }

    public static double findMin(pair cities[], long k) {
        long distances[] = new long[cities.length];
        for (int i = 0;i < cities.length;i++) {
            distances[i] = distanceFromOrigin(cities[i]);
        }
        Arrays.sort(distances);
        double l = 0, u = distances[cities.length - 1], mid = -1;
        while (l < u) {
            mid = l + (u-l)/2;
            if (isFeasible(distances, mid, k)) {
                u = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            pair [] arr = new pair[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Pair(sc.nextInt(), sc.nextInt());
            }
            long k = sc.nextLong();
            System.out.printf(".4f", findMin(arr, k));
        }
    }
}