package myArrayList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<T> {

    private final Object[] emptyArray = {};
    private static final int DEFAULT_CAPACITY = 10;

    private int size;
    Object[] myArray = {};

    public MyArrayList() {
        myArray = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            myArray = new Object[capacity];
        } else if (capacity == 0) {
            myArray = emptyArray;
        } else {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean add(Object o) {
        try {
            if (size >= myArray.length) {
                int capacityNew = myArray.length + (int) (myArray.length * 0.5);
                myArray = Arrays.copyOf(myArray, capacityNew);
            }
            myArray[size] = o;
            size++;
            return true;
        } catch (ClassCastException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void set(int index, T t) {
        myArray[index] = t;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) myArray[index];
    }

    public T delete(int index) {
        Objects.checkIndex(index, size);
        T value = get(index);
        size--;
        for (int i = index; i < myArray.length - 1; i++) {
            myArray[i] = myArray[i + 1];
        }
        myArray[myArray.length - 1] = null;
        return value;
    }

    public void sort(Comparator<? super T> comp) {
        for (int i = 0; i < size - 1; i++) {
            if (myArray[i] == null) {
                for (int j = i; j < myArray.length - 1; j++) {
                    myArray[j] = myArray[j + 1];
                }
                size--;
                myArray[myArray.length - 1] = null;
            }
        }
        Arrays.sort((T[]) myArray, 0, size, comp);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            builder.append(myArray[i]).append(" ");
        }
        builder.append(myArray[size - 1]);
        return "MyArrayList.MyArrayList [" + builder + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return size == that.size && Arrays.equals(emptyArray, that.emptyArray) && Arrays.equals(myArray, that.myArray);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(emptyArray);
        result = 31 * result + Arrays.hashCode(myArray);
        return result;
    }
}

