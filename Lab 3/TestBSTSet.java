/*
 * Program created by Sharjil Mohsin
 * Created and finished on March 4, 2019
 * Made for a lab assignment at McMaster University
 */
package lab.pkg3;

/**
 *
 * @author Sharjil
 */
public class TestBSTSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 6 sample arrays for testing
        int array1[] = {3, 8, 12, 9};
        int array2[] = {9, 12, 15, 100};
        int array3[] = {5, 4, 7, 8, 3, 9};
        int array4[] = {5, 4, 7, 8, 3, 9};
        int array5[] = {12, 15, -34, 48, 65};
        int array6[] = {1, -18, 25, 13, -15, -5};
        int array7[] = {5, 7, 4};
        
        // Creation of BSTSets from the sample arrays
        BSTSet set1 = new BSTSet(array1);
        BSTSet set2 = new BSTSet(array2);
        BSTSet set3 = new BSTSet(array3);
        BSTSet set4 = new BSTSet(array4);
        BSTSet set5 = new BSTSet(array5);
        BSTSet set6 = new BSTSet(array6);
        BSTSet set7 = new BSTSet(array7);
        BSTSet set8 = new BSTSet();
        
        //--------------------TEST CASES---------------------------------
        
        //-------------------Test Cases for isIn()-----------------------
        System.out.println("Test Case 1: Check if it can detect that a number is in the list");
        System.out.println(set1.isIn(8));
        System.out.println(set3.isIn(3));
        System.out.println(set6.isIn(-5));
        System.out.println();
        
        System.out.println("Test Case 2: Check if it can detect that a number is not in the list");
        System.out.println(set2.isIn(8));
        System.out.println(set4.isIn(-3));
        System.out.println(set5.isIn(5));
        System.out.println();
        
        //---------------------Test Cases for add()-----------------------
        System.out.println("Test Case 3: Addition of a different number into a set");
        set7.add(13);
        set7.printBSTSet();
        System.out.println();
        
        System.out.println("Test Case 4: Addition of a number that is already in the set into a set");
        set7.add(7);
        set7.printBSTSet();
        System.out.println();
        
        System.out.println("Test Case 5: Addition of a negative number into a set");
        set7.add(-9);
        set7.printNonRec();
        System.out.println();
        
        System.out.println("Test Case 6: Addition of a number into an empty set");
        set8.add(2);
        set8.printNonRec();
        System.out.println();
        
        //-------------------Test Cases for remove()----------------------
        System.out.println("Test Case 7: Removal of a number that is already in the set");
        set7.remove(-9);
        set7.printBSTSet();
        System.out.println();
        
        System.out.println("Test Case 8: Removal of a number that is not in the set");
        set7.remove(11);
        set7.printBSTSet();
        System.out.println();
        
        System.out.println("Test Case 9: Removal the only number in a set with one node");
        set8.remove(2);
        set8.printBSTSet();
        System.out.println();
        
        System.out.println("Test Case 10: Removal of a number from an empty set");
        set8.remove(2);
        set8.printBSTSet();
        System.out.println();
        
        //---------------------Test Cases for union()----------------------
        System.out.println("Test Case 11: Union of two sets that shares some similar numbers");
        BSTSet set9 = set1.union(set2);
        set9.printBSTSet();
        System.out.println();
        
        System.out.println("Test Case 12: Union of two sets that have the exact same numbers");
        BSTSet set10 = set3.union(set4);
        set10.printBSTSet();
        System.out.println();
        
        System.out.println("Test Case 13: Union of two sets that have completely different numbers");
        BSTSet set11 = set5.union(set6);
        set11.printNonRec();
        System.out.println();
        
        //------------------Test Cases for intersection()-------------------
        System.out.println("Test Case 14: Intersection of two sets that shares some similar numbers");
        BSTSet set12 = set1.intersection(set2);
        set12.printBSTSet();
        System.out.println();
        
        System.out.println("Test Case 15: Intersection of two sets that have the exact same numbers");
        BSTSet set13 = set3.intersection(set4);
        set13.printNonRec();
        System.out.println();
        
        System.out.println("Test Case 16: Intersection of two sets that have completely different numbers");
        BSTSet set14 = set5.intersection(set6);
        set14.printNonRec();
        System.out.println();
        
        //------------------Test Cases for difference()---------------------
        System.out.println("Test Case 17: Difference of two sets that shares some similar numbers");
        BSTSet set15 = set1.difference(set2);
        set15.printBSTSet();
        System.out.println();
        
        System.out.println("Test Case 18: Difference of two sets that have the exact same numbers");
        BSTSet set16 = set3.difference(set4);
        set16.printNonRec();
        System.out.println();
        
        System.out.println("Test Case 19: Difference of two sets that have completely different numbers");
        BSTSet set17 = set5.difference(set6);
        set17.printNonRec();
        System.out.println();
        
        //---------------------Test Cases for size()-----------------------
        System.out.println("Test Case 20: Checking size of sets that aren't empty");
        System.out.println(set1.size());
        System.out.println(set3.size());
        System.out.println(set5.size());
        System.out.println();
        
        System.out.println("Test Case 21: Checking size of sets that are empty");
        System.out.println(set8.size()); // Note that set 8 was emptied on line 90 of this class
        System.out.println();
        
        //---------------------Test Cases for height()-----------------------
        System.out.println("Test Case 22: Checking height of sets that aren't empty");
        System.out.println(set1.height());
        System.out.println(set4.height());
        System.out.println(set6.height());
        System.out.println();
        
        System.out.println("Test Case 23: Checking height of sets that are empty");
        System.out.println(set8.height());
        System.out.println();
    }
    
}
