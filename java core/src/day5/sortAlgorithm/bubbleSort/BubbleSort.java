package day5.sortAlgorithm.bubbleSort;

public class BubbleSort {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void main(String[] args){
        bubbleSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
    
    public static void bubbleSort(int[] list){
        boolean needNextPass = true;

        for(int i = list.length - 1; i >= 0 && needNextPass; i--){
            needNextPass = false;
            for(int j = 0; j < i; j++){
                if(list[j] > list[j+1]){
                    swap(list, j, j+1);
                    needNextPass = true;
                }
            }
        }
    }

    public static void swap(int[] list, int i, int j){
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
