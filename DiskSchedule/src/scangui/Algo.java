/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scangui;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Math.abs;

public class Algo {

    int n = 8, head = 50, diskSize = 199, t;
    ArrayList<Integer> arr3 = new ArrayList<Integer>();
    ArrayList<Integer> arr4 = new ArrayList<Integer>();

    int max(ArrayList<Integer> arr, int n) {
        int m = arr.get(0);
        for (int i = 1; i < n; i++) {
            if (m < arr.get(i)) {
                m = arr.get(i);
            }
        }
        return m;
    }

    Algo() {

    }

    public void inseart(int x) {
        arr3.add(x);
        n = arr3.size();
    }

    public ArrayList<Integer> AScan() {
        {
            arr4.clear();
            //System.out.println("OOOOOOOOOOOOO" + arr4.size());
            ArrayList<Integer> arr = arr3;
            for (int i = 0; i < n; i++) {
                arr.set(i, arr3.get(i));
            }
            int total = 0;
            if (max(arr, n) < head) {
                total = head;
            } else {
                total = head * 2 + (max(arr, n) - head);
            }

            Collections.sort(arr);
            System.out.println("the total head movement " + total);
            ArrayList<Integer> arr2 = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (arr.get(i) < head) {
                    arr2.add(0, arr.get(i));
                }
            }
            int i = 0;
            arr4.add(head);
            for (; i < arr2.size(); i++) {
                System.out.println(arr2.get(i));
                arr4.add(arr2.get(i));
            }
            System.out.println(0);
            arr4.add(0);
            for (; i < n; i++) {
                System.out.println(arr.get(i));
                arr4.add(arr.get(i));
            }
            t = total;
            return arr4;
        }

    }

    public ArrayList<Integer> ACScan() {
        arr4.clear();
        ArrayList<Integer> arr = arr3;
        for (int i = 0; i < n; i++) {
            arr.set(i, arr3.get(i));
        }
        int total = 0;
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr4.add(head);
        Collections.sort(arr);
        for (int i = 0; i < n; i++) {
            if (arr.get(i) < head) {
                arr2.add(arr2.size(), arr.get(i));
            }
        }
        if (arr2.size() == 0) {
            total = diskSize - head;

        } else {
            total = (2 * diskSize) - (head - arr2.get(arr2.size() - 1));
        }

        System.out.println("the total head movement " + total);
        int i = arr2.size();
        for (; i < n; i++) {
            System.out.println(arr.get(i));
            arr4.add(arr.get(i));
        }
        System.out.println(diskSize);
        arr4.add(diskSize);
        System.out.println(0);
        arr4.add(0);

        i = 0;
        for (; i < arr2.size(); i++) {
            System.out.println(arr2.get(i));
            arr4.add(arr2.get(i));
        }
        t = total;
        return arr4;
    }

    public ArrayList<Integer> FCFS() {
        arr4.clear();
        ArrayList<Integer> arr = arr3;
        for (int i = 0; i < n; i++) {
            arr.set(i, arr3.get(i));
        }
        int total = 0;
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        arr4.add(head);
        total += abs(head - arr.get(0));
        System.out.println(arr.get(0));
        arr4.add(arr.get(0));
        for (int i = 1; i < n; i++) {
            total += abs(arr.get(i - 1) - arr.get(i));
            System.out.println(arr.get(i));
            arr4.add(arr.get(i));
        }

        System.out.println("the total head movement " + total);

        t = total;
        return arr4;
    }

    public ArrayList<Integer> Look() {
        arr4.clear();
        ArrayList<Integer> arr = arr3;
        for (int i = 0; i < n; i++) {
            arr.set(i, arr3.get(i));
        }
        int total = 0;
        arr.add(head);
        Collections.sort(arr);
        arr4.add(head);
        int index = binarySearch(arr, 0, arr.size() - 1, arr.size());
        arr.remove(index);
        int index2 = index - 1;

        for (int i = 0; i < n; i++) {
            if (index < arr.size()) {
                arr4.add(arr.get(index));
                index++;
            } else {
                arr4.add(arr.get(index2));
                index2--;
            }
        }

        for (int i = 0; i < arr4.size() - 1; i++) {
            total += abs(arr4.get(i + 1) - arr4.get(i));
            System.out.println(arr4.get(i + 1) + "-" + arr4.get(i));
        }

        System.out.println("the total head movement " + total);

        t = total;
        return arr4;
    }

    public ArrayList<Integer> Clook() {
        arr4.clear();
        ArrayList<Integer> arr = arr3;
        for (int i = 0; i < n; i++) {
            arr.set(i, arr3.get(i));
        }
        int total = 0;
        arr.add(head);
        Collections.sort(arr);
        arr4.add(head);
        int index = binarySearch(arr, 0, arr.size() - 1, arr.size());
        arr.remove(index);
        int index2 = 0;

        for (int i = 0; i < n; i++) {
            if (index < arr.size()) {
                arr4.add(arr.get(index));
                index++;
            } else {
                arr4.add(arr.get(index2));
                index2++;
            }
        }

        for (int i = 0; i < arr4.size() - 1; i++) {
            total += abs(arr4.get(i + 1) - arr4.get(i));
            System.out.println(arr4.get(i + 1) + "-" + arr4.get(i));
        }

        System.out.println("the total head movement " + total);

        t = total;
        return arr4;
    }

    int binarySearch(ArrayList<Integer> arr, int left, int right, int size) {
        int mid = left + (right - left) / 2;
        if (right >= left) {
            if (arr.get(mid) < head) {
                return binarySearch(arr, mid + 1, right, arr.size());
            } else if (arr.get(mid) > head) {
                return binarySearch(arr, left, mid - 1, arr.size());
            } else {
                return mid;
            }
        }
        return -1;
    }

    public void setHead(int x) {
        head = x;
    }

    public void clear() {
        arr3.clear();
    }
}
