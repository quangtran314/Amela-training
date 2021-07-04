package day4.list.arrayList;

public class TestMyList {
    public static void main(String[] args){
        MyList<Integer> myList = new MyList<Integer>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(3);
        myList.add(4);

        System.out.println(myList);

        myList.add(5);
        myList.add(2, 6);
        myList.remove(3);
        
        System.out.println("My list after insert and remove: " + myList);

        if(myList.contains(3)){
            System.out.println("My list contain 3");
        }

        myList.clear();
        System.out.println("My list after clear: " + myList);
    }
}
