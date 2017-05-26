package ru.spbu.terekhow;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class MergeSortMultiThread {
    private int left;
    private int right;

    private int maxCountThreads;
    private int currentCountThreads;

    public void sort(ArrayList<Integer> array, int maxCountOfThreads) {
        this.maxCountThreads = maxCountOfThreads;
        currentCountThreads = 1;
        sortArrayFromTo(array, 0, array.size()-1);
    }

    private void sortArrayFromTo(ArrayList<Integer> array, int left, int right) {
        //System.out.println(Thread.currentThread().getName() + ": " + left + ", " + right);
        if (left == right) {
            return;
        }
        if (isNewThreadCanAdd()) {
            Thread newThread = new Thread(() -> sortArrayFromTo(array, left, (left+right)/2));
            newThread.setName("Thread" + currentCountThreads);
            newThread.start();
            sortArrayFromTo(array, (left+right)/2 + 1, right);
            try {
                newThread.join();
                merge(left, right, (left+right)/2, array);
            } catch (InterruptedException e) {}
        } else {
            sortArrayFromTo(array, left, (left+right)/2);
            sortArrayFromTo(array, (left+right)/2 + 1, right);
            merge(left, right, (left+right)/2, array);
        }
    }

    private synchronized boolean isNewThreadCanAdd() {
        if (currentCountThreads < maxCountThreads) {
            currentCountThreads++;
            return true;
        } else {
            return false;
        }
    }

    private void merge(int l, int r, int middle, ArrayList<Integer> array) {
        ArrayList<Integer> leftArray = new ArrayList<>(array.subList(l, middle+1));
        ArrayList<Integer> rightArray = new ArrayList<>(array.subList(middle + 1, r+1));
        int i = 0;
        int j = 0;
        ArrayList<Integer> mergedArray = new ArrayList<>();
        while (i < leftArray.size() || j < rightArray.size()) {
            if (i < leftArray.size() && j < rightArray.size()) {
                if (leftArray.get(i) < rightArray.get(j)) {
                    mergedArray.add(leftArray.get(i));
                    i++;
                }
                else {
                    mergedArray.add(rightArray.get(j));
                    j++;
                }
            } else if (i < leftArray.size()) {
                mergedArray.add(leftArray.get(i));
                i++;
            } else {
                mergedArray.add(rightArray.get(j));
                j++;
            }
        }
        setArrayInArray(array, mergedArray, l);
    }

    private void setArrayInArray(ArrayList<Integer> array, ArrayList<Integer> mergedArray, int l) {
        for (int i = 0; i < mergedArray.size(); i++) {
            array.set(l+i, mergedArray.get(i));
        }
    }
}
