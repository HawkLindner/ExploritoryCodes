package Java;
import java.util.Random;
public class Alg {
    /*
     * This method sorts an array using the bubble sort algorithm and returns
     * the sorted array.
     */
    public static int[] sort(int[] arr){
        for(int i = 0 ; i < arr.length - 1 ; i++){
            for(int j = 0 ; j < arr.length - i - 1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
    /*
     * This search requires a sorted array. It uses the bubble search algorithm
     * to find the target in the array and returns its index if found. If not
     * found, it throws an exception.
     */
    public static int bubbleSearch(int[] arr, int target){
        int temp = arr.length / 2;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[temp] == target){
                return temp;
            }
            else if(arr[temp] < target){
                temp = temp + (arr.length - temp) / 2;
            }
            else{
                temp = temp / 2;
            }
        };
        throw new IllegalArgumentException("Target not found in array");
    }
    /*
     * This search does not need a sorted array. It simply looks for the target
     * in the array and returns its index if found. If not found, it throws an
     * exception.
     */
    public static int BinarySearch(int[]arr, int target){
        //Start with protecting against empty array
        if(arr.length == 0){
            return -1;
        }
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == target){
                return i;
            }
        }
        throw new IllegalArgumentException("Target not found in array");
    }
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for(int i = 0 ; i < 10; i++){
            arr[i] =  rand.nextInt(1,10);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        int target = rand.nextInt(1,10);
        System.out.println("Target: " + target);
        try {
            int index = BinarySearch(arr, target);
            System.out.println("Target found at index: " + index);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        int arr1Sorted[] = arr;
        arr1Sorted = sort(arr1Sorted);
        System.out.print("Sorted array: ");
        for(int i = 0 ; i < arr1Sorted.length ; i++){
            System.out.print(arr1Sorted[i] + " ");  
        }
        System.out.println();
        try {
            int index = bubbleSearch(arr1Sorted, target);
            System.out.println("Target found at index (in sorted array): " + index);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
