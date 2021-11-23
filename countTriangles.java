import java.util.Arrays;
import java.util.Scanner;

/**
 * countTripletsAbsDiff
 */
public class Main {

    public static boolean isFeasible(int a, int mid, int k) {
        return (Math.abs(a - mid) <= k);
    }

    public static int countTriangles(int a[], int p, int startIndex, int n, int k) {
        
        int l = startIndex, u = n-1, mid = 0;
        while (l < u) {
            mid = l + (u-l + 1)/2;
            if (isFeasible(p, a[mid], k)) {
                l = mid;
            } else {
                u = mid - 1;
            }
        }
        n = u - startIndex + 1;
        return isFeasible(p, a[u], k) ? n*(n+1)/2 : 0;
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long count = 0;
        for (int i = 0; i + 1 < n; i++) {
            count += countTriangles(a, a[i], i + 2, n, k);
        }
        System.out.println(count);
    }
}