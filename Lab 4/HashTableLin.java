/*
 * Program created by Sharjil Mohsin
 * Created and finished on March 18, 2019
 * Made for a lab assignment at McMaster University
 */
package lab.pkg4;

/**
 *
 * @author Sharjil
 */

// Hash table with linear probing.
public class HashTableLin {
    private Integer[] table;
    private int size, numKeys;
    private double maxLoad;
    
    // This constructor will create a HashTableLin object representing an empty hash table with maximum
    // allowed load factor equal to load.
    public HashTableLin(int maxNum, double load){
        if(maxNum <= 0 || load <= 0){
            throw new IllegalArgumentException("Error: maxNum and load both must be greater than 0.");
        }
        
        numKeys = 0;
        maxLoad = load;
        
        double sizeCalculator = maxNum/load;
        int sizeTable = (int) sizeCalculator;
        
        if(isPrime(sizeTable) == true){
            size = sizeTable;
        }
        
        else{
            size = nextPrime(sizeTable);
        }
        
        table = new Integer[size];
    }
    
    // Private method that helps to determine whether the number input is a prime number or not.
    private boolean isPrime(int n){
        if(n == 2){
            return true;
        }

        else if(n < 2||n % 2 == 0){
            return false;
        }

        for(int i=3; i<n; i=i+2){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
    
    // Private method that calculates and returns the next closest prime number to the input number.
    private int nextPrime(int n){
        boolean x = true;
        
        while(x){
            n = n+1;
            if(isPrime(n) == true){
                x = false;
            }
        }
        
        return n;
    }
    
    // This method inserts the key n in this hash table if the key is not already there. Collisions are
    // resolved using linear probing.
    public void insert(int n){
        int index;
        
        if(isIn(n) == true){
            return;
        }
        
        numKeys++;
        
        if(((numKeys+1)/(double)table.length)>maxLoad){
            System.out.println("rehash");
            rehash();
        }
        
        index = n % size;
        
        if(table[index] == null){
            table[index] = n;
        }
        
        else{
            while(table[index] != null){
                index = (index + 1)%size; 
            }
            
            table[index] = n;
        }
    }
    
    // Private method that allocates a bigger table of size equal to the smallest prime number at least
    // twice larger than the old size.
    private void rehash(){
        Integer[] newTable;
        size = size*2;
        
        if(isPrime(size) == true){
            newTable = new Integer[size];
        }
        
        else{
            size = nextPrime(size);
            newTable = new Integer[size];
        }
        
        for(int i=0; i<table.length; i++){
            if(table[i]!=null){
                newTable[table[i]%size] = table[i];
            }
        }
        
        table = newTable;
    }
    
    // This method checks whether key is in the hash table. It returns true if key n is in this hash table
    // and it returns false otherwise.
    public boolean isIn(int n){
        int index = n % size;
        
        while((table[index] != null) && (index < size - 1)){
            if((table[index] != null) && (table[index] == n)){
                return true;
            }
            
            index++;
        }
        
        return false;
    }
    
    // This method prints all the keys stored in this hash table, in no particular order.
    public void printKeys(){
        if(numKeys == 0){
            System.out.println("Empty hash table.");
            return;
        }
        
        for(int i=0; i<table.length; i++){
            if(table[i] != null){
                System.out.println("Key = " + table[i]);
            }
        }
    }
    
    // This method prints all keys stored in this hash table and the array index where each key is stored, 
    // in increasing order of array indexes.
    public void printKeysAndIndexes(){
        if(numKeys == 0){
            System.out.println("Empty hash table.");
            return;
        }
        
        for(int i=0; i<table.length; i++){
            if(table[i] != null){
                System.out.println("Key = " + table[i] + ", Index = [" + i + "]");
            }
        }
    }
    
    // This method returns the size of the hash table.
    public int getSize(){
        return size;
    }
    
    // This method returns the number of keys in the hash table.
    public int getNumKeys(){
        return numKeys;
    }
    
    // This method returns the maximum load factor allowed in this hash table.
    public double getMaxLoad(){
        return maxLoad;
    }
    
    // This method counts and returns the number of probes performed during an insertion.
    public int insertCount(int n){
        int numProbes = 1;
        int index = n % size;
        
        while(true){
            if(table[index] == null){
                table[index] = n;
                numKeys++;
                break;
            }
            
            else{
                index = (index + 1)%size; 
                numProbes++;
            }
        }
        
        return numProbes;
    }
    
    // This method counts and returns the number of probes performed for an unsuccessful search.
    public int uSearchCount(int n){
        int numProbes = 1;
        int index = n % size;
        
        while(true){
            if(table[index] == null){
                break;
            }
            
            else{
                index = (index + 1)%size; 
                numProbes++;
            }
        }
        
        return numProbes;
    }
}
