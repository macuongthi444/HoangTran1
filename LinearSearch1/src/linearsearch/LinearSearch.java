package linearsearch;

/**
 *
 * @author hoang
 */
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author THAYCACAC
 */
public class LinearSearch {
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int n = check_InputInt();
        int[] array = new int[n];
        Create_Array(array, n);
        System.out.println("");
        int search = checkInputInt();
        PrintfArray(array, n);
        System.out.println("\nFound " + search + " at index: " + linerSearch(array, search));
    }
    
    public static void Create_Array(int[] arr, int n) {
        
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(10);
        }
        
    }

    public static void PrintfArray(int[] arr, int n) {
        System.out.println("");
        System.out.print("The array: ");
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public static int linerSearch(int[] arr, int search) {

//        int size = arr.length;
//       for (int i = 0; i < size; i++) {
//            if (arr[i] == search) {
//                return i; 
//                
//            }
//        }
//        return -1;
        ////////////
//        int i=0;
//        int size = arr.length;
//        while(i < size && arr[i]!=search){
//            i++;
//        }
//            if(i==size){
//                return -1;
//            }
//            else{
//            return i;
//            }
        int size = arr.length;
        
        int i = 0;
        int foundIndex = -1; // Khởi tạo giá trị mặc định không tìm thấy

        while (i < size) {
            if (arr[i] == search) {
                foundIndex = i; // Gán chỉ số của phần tử tìm thấy
                break; // Thoát khỏi vòng lặp khi tìm thấy phần tử
            }
            i++;
        }
        
        return foundIndex; // Trả về giá trị của foundIndex
    }
    
    public static int check_InputInt() {
        
        int a = 0;
        
        boolean inputter = true;
        System.out.println("Enter number of array:");
        while (inputter) {
            try {
                System.out.print("Input a number: ");
                scanner = new Scanner(System.in);
                a = scanner.nextInt();
                if (a <= 0) {
                    System.out.println("Input Error");
                    System.out.println("Please enter again!");
                    continue;
                }
                inputter = false;
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("No input accepted! Please enter again!");
            }
        }
        
        return a;
    }
    
    static int checkInputInt() {
        int a = 0;
        boolean input = true;
        System.out.println("Enter search value:");
        while (input) {
            try {
                scanner = new Scanner(System.in);
                a = scanner.nextInt();
                break;
                
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Please input a number.");
                System.out.print("Enter again: ");
                
            }
        }
        return a;
    }
}
