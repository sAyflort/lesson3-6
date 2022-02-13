package ru.gb.lesson3_6;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 1, 2};
        System.out.println(Arrays.toString(afterFour(arr)));
        System.out.println(isThere14(arr));
    }
    
    public static int[] afterFour(int[] arr) throws RuntimeException{
        int[] retArr;
        int index = -1;
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (arr[i] == 4) {
                index = i + 1;
                break;
            }
        }
        if (index == -1) {
            throw new RuntimeException();
        }

        retArr = new int[arr.length-index];

        for (int i = 0; i < retArr.length; i++) {
            retArr[i] = arr[index+i];
        }

        return retArr;
    }

    public static boolean isThere14(int[] arr) {
        boolean one = false, four = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                one = true;
            }
            if(arr[i] == 4) {
                four = true;
            }
            if(one&&four) {
                break;
            }
        }
        return one&&four;
    }
}