package com.cybertek.tests;

import java.util.*;

public class CodilityTest {
    //TODO: return positive min number which does not appear in array
    public int getNum(int[]arr){
        Arrays.sort(arr);
        int max=arr[arr.length-1];
        if (max<=0){
            return 1;
        }
        int countPos=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>0){
                countPos++;//count positive numbers in array
            }
        }
        int[]pos_array=new int[countPos];
        int counter=0;
        for (int i = 0; i <arr.length; i++) {
            if (arr[i]>0){
                pos_array[counter]=arr[i];
                counter++;
            }
        }
        counter=1;
int numToReturn=0;
        for(int i=0; i<pos_array.length; i++){
            for (int j=0; j<pos_array.length; j++) {

            }
        }

        return countPos;
    }


    public static void main(String[] args) {
        int[]arr1={-1,-2,-3,0};
        int[]arr2={120,2,3,0,1};
        int[]arr3={30,-2,13,56};
        int[]arr4={1,2,3,4};

        CodilityTest obj=new CodilityTest();
        int num=obj.getNum(arr2);
        System.out.println("num = " + num);


    }
}
