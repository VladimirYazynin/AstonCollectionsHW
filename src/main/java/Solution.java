import myArrayList.MyArrayList;

public class Solution {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        list.delete(3);

        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

        list.delete(1);

        for(int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));

    }
}
