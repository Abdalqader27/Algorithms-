package com.Elkood.Sortings;

public class Sorting {
    public static void main(String[] args) {

        int a[] = {1, 4, 6, 2, 5, 5, 2, 0, 8, 7};
//        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));
//        InsertionSort(a);
//        System.out.println("After  Sort");
//        IntStream.range(0, a.length).forEach(i -> System.out.print(a[i] + " "));

//        int[] v = {0, 1, 2, 3, 4, 5};
//        int[] v2 = {0, 1, 2, 3, 4, 5};
//        int[] v3 = new int[v.length + v2.length];
//        mergeTwoSortedArray(v, v2, v3);
//        for (int c : v3) {
//            System.out.print(c + " ");
//        }

    }

    public static void BubbleSort(int[] a) {
        int out, in;
        for (out = a.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (a[in + 1] < a[in]) {
                    int t = a[in];
                    a[in] = a[in + 1];
                    a[in + 1] = t;
                }
            }
        }

    }

    public static void SelectionSort(int[] a) {
        int in, out, min;
        for (out = 0; out < a.length - 1; out++) {
            min = out;
            for (in = out + 1; in < a.length; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }

            int t = a[out];
            a[out] = a[min];
            a[min] = t;
        }


    }

    public static void InsertionSort(int[] a) {

        int in, out;
        for (out = 1; out < a.length; out++) {
            int temp = a[out];
            in = out;
            while (in > 0 && a[in - 1] > temp) {
                a[in] = a[in - 1];
                --in;
            }
            a[in] = temp;
        }
    }

    public static void mergeTwoSortedArray(int[] a, int[] b, int[] c) {
        int dexA = 0, dexB = 0, dexC = 0;
        while (dexA < a.length && dexB < b.length) {
            if (a[dexA] < b[dexB]) {
                c[dexC++] = a[dexA++];
            } else {
                c[dexC++] = b[dexB++];
            }
        }

        while (dexA < a.length) {
            c[dexC++] = a[dexA++];
        }

        while (dexB < b.length) {
            c[dexC++] = b[dexB++];
        }

    }


    public void MergeSort(int[] a) {
        int[] workSpace = new int[a.length];
        recMergeSort(workSpace, 0, a.length);
    }

    public void recMergeSort(int[] workSpace, int low, int high) {

        if (low != high) {
            int mid = (low + high) / 2;
            recMergeSort(workSpace, low, mid);
            recMergeSort(workSpace, mid + 1, high);
            Merge(workSpace, low, mid + 1, high);
        }
    }

    public void Merge(int[] workspace, int low, int mid, int hight) {
        int j = 0;
        int lower = low;
        int Mid = mid - 1;
        int n = hight - low + 1;
        while (lower <= Mid && mid <= hight) {

            if (workspace[lower] < workspace[Mid]) {
                workspace[j++] = workspace[lower++];
            }
            if (workspace[Mid] > workspace[hight]) {
                workspace[j++] = workspace[lower++];
            }


        }


    }


    public void QuickSort(int l, int r) {
        if (l - r <= 0) {
            ;
        } else {
            int Partition = PartitionIT(l, r);
            QuickSort(l, Partition - 1);
            QuickSort(Partition + 1, r);
        }
    }

    private int PartitionIT(int l, int r) {
        return 0;
    }
}


