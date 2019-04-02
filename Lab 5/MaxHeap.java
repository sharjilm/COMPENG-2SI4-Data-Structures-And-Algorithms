/*
 * Program created by Sharjil Mohsin
 * Created and finished on April 1, 2019
 * Made for a lab assignment at McMaster University
 */
package lab.pkg5;

/**
 *
 * @author Sharjil
 */
public class MaxHeap {
    private Integer[] heapArray;
    private int size, numItems;
    
    // This constructor creates an empty heap, where the size of the array to be allocated is passed as the parameter.
    // It allocates the size passed through + 1 to the heapArray, assigns the size to the size variable and sets the
    // number of items in the list to be 0.
    public MaxHeap(int s){
        heapArray = new Integer[s+1]; // 1 extra slot allocated to heapArray to account for the null at the beginning.
        size = s;
        numItems = 0;
    }
    
    // This constructor creates a MaxHeap which stores items from the input array. It allocates the size of heapArray by
    // taking the length of someArray + 1, sets the size to be the length of someArray, and uses a for loop to fill up
    // the heapArray by calling the insert() function.
    public MaxHeap(Integer[] someArray){
        // 1 extra slot allocated to heapArray to account for the null at the beginning.
        heapArray = new Integer[someArray.length+1]; 
        size = someArray.length;      
        
        for(int i=0; i<someArray.length; i++){
            insert(someArray[i]);
        }
    }
    
    // The insert method inserts the value the value n in this max heap (inserts an object of type Integer representing n.
    // It allows duplicates and if there is no room for the insertion in the current array storing the items, then an
    // of double size has to be allocated and all items are copied into the new array, after which insertion is performed.
    public void insert(int n){
        int key;
        
        if(numItems == size){
            MaxHeap tempHeap = new MaxHeap(size*2);
            
            for(int i=0; i<=size; i++){
                tempHeap.heapArray[i] = heapArray[i];
            }
            
            heapArray = tempHeap.heapArray;
            size = size*2;
        }
        
        numItems++;
        heapArray[numItems] = n;
        
        key = numItems;
        
        while((key/2 > 0) && (heapArray[key/2] < n)){
            heapArray[key] = heapArray[key/2];
            heapArray[key/2] = n;
            key = key/2;
        }
    }
    
    // The deleteMax method removes the item with the largest value from the heap and returns its value to the user.
    private int deleteMax(){
        int maxNum, key, temp;
        
        if(numItems == 0){
            System.out.println("Empty heap.");
            return 0;
        }
        
        maxNum = heapArray[1];
        heapArray[1] = heapArray[numItems];
        heapArray[numItems] = null;
        numItems--;
        
        key = 1;
        
        while((key*2 <= size) && (heapArray[key*2]) != null){
            if((key*2+1 <= size) && (heapArray[key*2+1] != null)){
                temp = heapArray[key];
                
                if(heapArray[key*2] >= heapArray[key*2+1]){
                    heapArray[key] = heapArray[key*2];
                }
                
                else{
                    heapArray[key] = heapArray[key*2+1];
                }
                
                if(heapArray[key*2] >= heapArray[key*2+1]){
                    heapArray[key*2] = temp;
                    key = key*2;
                }
                
                else{
                    heapArray[key*2+1] = temp;
                    key = key*2+1;
                }
            }
            
            else if(heapArray[key*2] > heapArray[key]){
                temp = heapArray[key];
                heapArray[key] = heapArray[key*2];
                heapArray[key*2] = temp;
                
                key = key*2;
            }
            
            else{
                break;
            }
        }
        
        return maxNum;
    }
    
    // The toString method returns a string representing the sequence of integer values stored in the heap, in the order
    // they are stored in the array.
    public String toString(){
        String str = "";
        
        for(int i=1; i<=numItems; i++){
            str = str + heapArray[i] + " ";
        }
        
        return str;
    }
    
    // The heapsort method applies the heapsort algorithm to sort the input array.
    public static void heapsort(Integer[] arrayToSort){
        MaxHeap heap = new MaxHeap(arrayToSort);
        
        for(int i=arrayToSort.length-1; i>=0; i--){
            arrayToSort[i] = heap.deleteMax();
        }
    } 
    
    // The getArray method returns each element in the heapArray one by one with a space in between.
    public void getArray(){
        if(numItems == 0){
            System.out.println("Empty heap.");
        }
        
        else{
            System.out.println(this.toString());
        }
    }
    
    // The getSize method returns the size of the array or the amount of memory allocated for the array.
    public int getSize(){
        return size;
    }
    
    // The getNumItems method returns the size of the heap or the number of items stored in the heap.
    public int getNumItems(){
        return numItems;
    }
}
