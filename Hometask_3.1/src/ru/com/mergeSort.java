package ru.com;

public class mergeSort implements Sort {
    public void sort(int array[]) {
        mergedSort(0, array.length - 1, array);
    }

    public void mergedSort(int l, int r, int array[]) {
        if (l != r) {
            int center = (l + r) / 2;
            this.mergedSort(l, center, array);
            this.mergedSort(center + 1, r, array);
            merge(array, l, r, center);
        }
    }

    public void setArrayInArray(int toArray[], int fromArray[], int begin) {
        for (int i = begin; i < begin + fromArray.length; i++) {
            toArray[i] = fromArray[i - begin];
        }
    }

    public int[] getArrayfromArray(int array[], int l, int r) {
        int newArray[] = new int[r - l + 1];
        for (int i = l; i <= r; i++) {
            newArray[i - l] = array[i];
        }
        return newArray;
    }

    public void merge(int array[], int l, int r, int middle) {
        int arr1[] = getArrayfromArray(array, l, middle);
        int arr2[] = getArrayfromArray(array, middle + 1, r);;
        int i = 0;
        int j = 0;
        int result[] = new int[r - l + 1];
        while (i < arr1.length || j < arr2.length) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    result[i + j] = arr1[i];
                    i++;
                }
                else {
                    result[i + j] = arr2[j];
                    j++;
                }
            } else if (i < arr1.length) {
                result[i + j] = arr1[i];
                i++;
            } else {
                result[i + j] = arr2[j];
                j++;
            }
        }
        setArrayInArray(array, result, l);
    }
}
