import java.util.Arrays;
import java.util.Scanner;

/**
 * triangleOrNot
 */
public class triangleOrNot {

    public static boolean isTriangle(int a, int b, int c) {
        return (a + b >= c && a + c >= b && b + c >= a);
    }

    public static int countTriangles(int a[], int p, int q, int startIndex, int n) {
        int l = startIndex, u = n-1, mid = 0;
        while (l < u) {
            mid = l + (u-l + 1)/2;
            if (isTriangle(p, q, a[mid])) {
                l = mid;
            } else {
                u = mid - 1;
            }
        }
        return isTriangle(p, q, a[u]) ? (u - startIndex + 1) : 0;
    }

    public static long gcd(long p, long q) {

        if (p < q) {
            long t = p;
            p = q;
            q = t;
        }

        if(q == 0) return p;
        else return gcd(q, p % q);

    }

    public static long nCr(long n, long r) {
        
        long nn = 1, rr = 1;

        if (n - r < r) {
            r = n - r;
        }

        if(r > 0) {
            while (r > 0) {
                nn *= n--;
                rr *= r--;

                long k = gcd(nn, rr);

                nn /= k;
                rr /= k;

            }
            return nn;
        }
        else return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        while ((n = sc.nextInt()) != 0) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            long count = 0;
            Arrays.sort(a);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    count += countTriangles(a, a[i], a[j], j + 1, n);
                }
            }
            count = nCr(n, 3) - count;
            System.out.println(count);
        }
    }
}