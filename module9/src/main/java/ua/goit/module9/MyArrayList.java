package ua.goit.module9;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {

    private Object[] arr = new Object[5];
    private int counterElem = 0;


    public void add(T value) {
        if (counterElem == arr.length - 1) {
            resizeArr();
        }
        arr[counterElem] = value;
        counterElem++;
    }

    public void remove(int index) {
        arr[index] = null;
        Object newArr[] = new Object[arr.length -1];

        clearElem(index);
        createResizeArr();
    }

    public void clear() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
    }
    
    public int size() {
       int counter = 0;

       for (int i = 0; i < arr.length; i++) {
           if (arr[i] != null) {
               counter++;
           }
       }
       return counter;
    }

    public Object get(int index) {
        return arr[index];
    }

   private void resizeArr() {
       arr = Arrays.copyOf(arr, arr.length*2);
   }

   private Object clearElem(int index) {
       arr[index] = null;
       for (; index < arr.length-1; index++) {
           arr[index] = arr[index+1];
       }
       return arr;
   }

   private Object[] createResizeArr() {
       Object[] newArr = new Object[arr.length - 1];
       for (int i = 0; i < newArr.length; i++) {
           newArr[i] = arr[i];
       }
       return arr = newArr.clone();
   }


}
