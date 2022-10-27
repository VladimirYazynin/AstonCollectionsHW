package myArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class MyArrayListTets {

    private MyArrayList<Integer> list;

    @BeforeEach
    public void init() {
        list = new MyArrayList<>(3);
    }


    @Test
    void addIntegersSuccessful() {
        list.add(1);
        assertTrue(list.add(1));
    }


    @Test
    void getSuccessful() {
        list.add(0);
        assertEquals(0, list.get(0));
    }

    @Test
    void getOutOfBound() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
    }

    @Test
    void removeSuccessful() {
        list.add(0);
        assertEquals(0, list.delete(0));
    }

    @Test
    void sort() {
        MyArrayList<Integer> listResul = new MyArrayList<>(3);
        listResul.add(0);
        listResul.add(1);
        listResul.add(2);

        list.add(2);
        list.add(0);
        list.add(1);

        Comparator<Integer> c = Comparator.comparingInt(o -> o);

        list.sort(c);

        assertEquals(list, listResul);
    }

}
