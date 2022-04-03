package com.codesgate;

import java.util.Arrays;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        this.items = new int[length];
    }

    public void insert(int item) {
        if(items.length == count){
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
        items[count++] = item;
    }

    public int indexOf(int number) {
        int left = 0;
        int right = count - 1;
        int mid;

        while (left <= right){
            mid = left + (right - left) / 2;
            if (items[mid] == number) return mid;

            if (items[mid] > number)
                right -= 1;
            else
                left += 1;
        }
        return -1;
    }

    public void removeAt(int index) {
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count; i++)
            items[i] = items[i + 1];
        count--;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }
}
