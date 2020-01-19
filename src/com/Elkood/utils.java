package com.Elkood;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class utils {
    static long Gcd(long n, long k) {
        if (k == 0) return n;
        return Gcd(n, n % k);
    }
    public static void sort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // One by one extract an element from heap
        for (int i = n - 1; i >= 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static int nextPrime(int n, List<Integer> list) {
        int item = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (n == list.get(i)) item = list.get(i + 1);
        }
        return item;
    }

    static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to n-1
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }

    static String Reverse(String v) {
        StringBuilder g = new StringBuilder();

        if (v.length() == 1) return v;
        else {
            for (int i = v.length() - 1; i >= 0; i--) {
                g.append(v.charAt(i));
            }
        }
        return g.toString();
    }
}

//   if (Arrays.stream(a).anyMatch(x -> x % 2 != 0)) isOdd = true;

//out.println(Arrays.stream(temp).reduce(temp[0], Math::max) + " " + map.size());

//    	   static boolean isSorted(int[] a) {
//       int i = a.length - 1;
//       if (i <= 0) return true;
//       if ((i & 1) > 0) {
//               if (a[i] < a[i - 1]) return false;
//               i--;
//           }
//       for (int ai = a[i]; i > 0; i -= 2)
//               if (ai < (ai = a[i - 1]) || ai < (ai = a[i - 2])) return false;
//              return a[0] <= a[1];
//
//
//    }
class FastReader {

    BufferedReader br;
    StringTokenizer st;

    FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String string = "";
        try {
            string = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    char nextChar() {
        return next().charAt(0);
    }
}
//    String str = "Protijayi";
//// Method 1
//        str = str.chars() // IntStream
//                .sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
//
//                System.out.println(str);
//                // Method 2
//                str = Stream.of(str.split(" ")).sorted().collect(Collectors.joining());
//                System.out.println(str);


//    public static boolean isCircularSorted(int[] array) {
//        int size = array.length;
//        int count = 0;
//        boolean one_n_1 = false;
//        for (int x = 1; x < size; x++)
//            if (Math.abs(array[x - 1] - array[x]) == 1) {
//            } else {
//                if (!one_n_1 && Math.abs(array[x - 1] - array[x]) == size - 1) {
//                    one_n_1 = true;
//                } else {
//                    return false;
//                }
//            }
//        return true;
//    }
//int dcmp(double a, double b)                            {return((fabs(a-b)<EPS)?0:(a<b)?-1:+1);}
//    double crossP(const point &v1, const point &v2)         {return (conj(v1)*v2).Y;}
//    double dotP(const point &v1, const point &v2)           {return (conj(v1)*v2).X;}
//    double lengthSqr(const point &p)                        {return dotP(p, p);}
//    double length(const point &p)                           {return hypot(p.X,p.Y);}
//    double fixAngle(double a)                               {return ((a>1)?1:(a<-1)?-1:a);}
//    bool same(const point &p1, const point &p2)             {return((dcmp(p1.X, p2.X)==0 && dcmp(p1.Y, p2.Y)==0)?1:0);}
//    double getAngle_A_abc(double a, double b, double c)     {return acos(fixAngle((b*b+c*c-a*a)/(2*b*c)));}