/*
 * Program created by Sharjil Mohsin
 * Created and finished on April 1, 2019
 * Made for a lab assignment at McMaster University
 */
package lab.pkg5;

/**
 * @author Sharjil *
 */
public class TestMaxHeap {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 2 sample Integer arrays for testing
        Integer array1[] = {5, 12, 40, 30, 55, 60, 50, 45, 10};
        Integer array2[] = {28, 35, 14, 2, 57, 98, 74, 34, 28, 16};
        
        //--------------------TEST CASES---------------------------------
        
        //--------------------Test Case for MaxHeap(int s) and insert------------------------
        System.out.println("Test Case 1: Testing MaxHeap(int s) and insert");
        System.out.println();
        
        MaxHeap m1 = new MaxHeap(5);
        
        m1.insert(2);
        m1.insert(5);
        m1.getArray();
        System.out.println(m1.getSize());
        System.out.println(m1.getNumItems());
        System.out.println();
        
        m1.insert(15);
        m1.insert(24);
        m1.insert(8);
        m1.insert(3);
        m1.getArray();
        System.out.println(m1.getSize());
        System.out.println(m1.getNumItems());
        System.out.println();
        
//        for(int i=0; i<m1.heapArray.length; i++){
//            System.out.println(m1.heapArray[i]);
//        }

        //--------------------Test Case for MaxHeap(Integer[] someArray) and deleteMax------------------------
        System.out.println("Test Case 2: Testing MaxHeap(Integer[] someArray) and deleteMax");
        System.out.println();
        
        MaxHeap m2 = new MaxHeap(array1);
        System.out.println(m2.toString());
        System.out.println();
        
//        m2.deleteMax();
//        System.out.println(m2.toString());
//        System.out.println();

        //--------------------Test Case for heapsort------------------------
        System.out.println("Test Case 3: Testing heapsort");
        System.out.println();
        
        MaxHeap.heapsort(array2);
        
        for(int i=0; i<array2.length; i++){
            System.out.print(array2[i] + " ");
        }
        
        System.out.println();
    }
    
}
