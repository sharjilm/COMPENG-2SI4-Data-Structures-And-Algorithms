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
public class BSTSet{
    private TNode root;
    
    // Creates an empty binary search tree.
    public BSTSet(){
        root = null;
    }
    
    // Creates a binary search tree set based on values of the integer array passed in.
    public BSTSet(int[] input){
        if(input == null){
            root = null;
            return;
        }
        
        root = new TNode(input[0], null, null);
        
        if(input.length > 1){
            for(int i=1; i<input.length; i++){
                TNode t = root;

                while(t != null){
                    if(input[i] == t.element){
                        break;
                    }

                    else if(input[i] < t.element){
                        if(t.left != null){
                            t = t.left;
                        }

                        else{
                            t.left = new TNode(input[i], null, null);
                            break;
                        }
                    }

                    else{
                        if(t.right != null){
                            t = t.right;
                        }

                        else{
                            t.right = new TNode(input[i], null, null);
                            break;
                        }
                    }
                }
            } 
        }
    }
    
    // Checks whether the integer value v is in the BSTSet and returns true if it is, returns false otherwise.
    public boolean isIn(int v){
        TNode t = root;
        
        if(root == null){
            return false;
        }
        
        else{
            while(t != null){
                if(v == t.element){
                    return true;
                }
                
                else if(v < t.element){
                    t = t.left;
                }
                
                else{
                    t = t.right;
                }
            }
            
            return false;
        }
    }
    
    // This method adds the integer value v into the BSTSet if v was not already an element in the set. It does nothing
    // otherwise.
    public void add(int v){
        TNode t = root;
        
        if(root == null){
            root = new TNode(v, null, null);
        }
        
        else{
            insert(v, t);
        }
    }
    
    // Private method for the add method that carries out the addition of an element into the BSTSet.
    // Code adapted from slide 56 of lecture 4 from 2SI4 lecture
    private TNode insert(int v, TNode t){
        if(t == null){
            t = new TNode(v, null, null);
        }
        
        else if(v < t.element){
            t.left = insert(v, t.left);
        }
        
        else if(v > t.element){
            t.right = insert(v, t.right);
        }
        
        return t;
    }
    
    // This method removes the integer value v from this BSTSet and returns true. It returns false when v is not an 
    // element of this set.
    public boolean remove(int v){
        TNode t = root;
        
        if(root == null){
            return false;
        }
        
        else if(isIn(v) == false){
            return false;
        }
        
        else if(v == t.element && this.size() == 1){
            root = null;
            return true;
        }
        
        else{
            delete(v, t);
            return true;
        }
    }
    
    // Private method for the removal method that carries out the removal of an element from the BSTSet.
    // Code adapted from slide 72 of lecture 4 from 2SI4 lecture
    private TNode delete(int v, TNode t){
        if(v < t.element){
            t.left = delete(v, t.left);
        }
        
        else if(v > t.element){
            t.right = delete(v, t.right);
        }
        
        else if(t.left != null && t.right != null){
            t.element = findMin(t.right);
            t.right = removeMin(t.right);
        }
        
        else{
            if(t.left != null){
                t = t.left;
            }
            
            else{
                t = t.right;
            }
        }
        
        return t;
    }
    
    // Private method for the removal method that looks for the lowest element in the BSTSet.
    // Code adapted from slide 46 of lecture 4 from 2SI4 lecture
    private int findMin(TNode t){
        while(t.left != null){
            t = t.left;
        }
        
        return t.element;
    }
    
    // Private method for the removal method that removes the lowest element in the BSTSet.
    private TNode removeMin(TNode t){
        if(t.left != null){
            t.left = removeMin(t.left);
        }
        
        else{
            t = t.right;
        }
        
        return t;
    }
    
    // This method returns a new BSTSet which represents the union of this BSTSet and s.
    public BSTSet union(BSTSet s){
        if(root == null){
            return s;
        }
        
        else if(s.root == null){
            return this;
        }
            
        BSTSet union = new BSTSet();
        unionMaker(union, root);
        unionMaker(union, s.root);
        
        return union;
    }
    
    // Private method for the union method that traverses through this BSTSet and adds all
    // element to the BSTSet union recursively.
    private void unionMaker(BSTSet union, TNode t){       
        if(t != null){
            unionMaker(union, t.left);
            union.add(t.element);
            unionMaker(union, t.right);
        }
    }
    
    // This method returns a new BSTSet which represents the intersection of this BSTSet and s.
    public BSTSet intersection(BSTSet s){
        if(root == null || s.root == null){
            return new BSTSet();
        }
        
        BSTSet inter = new BSTSet();
        intersectionMaker(inter, s.root);
        
        return inter;
    }
    
    // Private method for the intersection method that traverses through this BSTSet recusively 
    // and adds the elements in the BSTSet inter if a similar number is found in the BSTSet
    // s.
    private void intersectionMaker(BSTSet inter, TNode t){
        if(t != null){
            intersectionMaker(inter, t.left);
            
            if(isIn(t.element) == true){
                inter.add(t.element);
            }
     
            intersectionMaker(inter, t.right);
        }
    }
    
    // This method returns a new BSTSet which represents the difference of this BSTSet and s.
    public BSTSet difference(BSTSet s){
        if(root == null){
            return new BSTSet();
        }
        
        else if(s.root == null){
            return this;
        }
        
        BSTSet diff = new BSTSet();
        s.differenceMaker(diff, root);
        
        return diff;
    }
    
    // Private method for the difference method that traverses through the BSTSet of s recusively 
    // and adds the elements in the BSTSet diff if a number found in this BSTSet is found that is
    // not in the BSTSet s.
    private void differenceMaker(BSTSet diff, TNode t){
        if(t != null){
            differenceMaker(diff, t.left);
            
            if(isIn(t.element) == false){
                diff.add(t.element);
            }
     
            differenceMaker(diff, t.right);
        }
    }
    
    // This method returns the number of elements in this set.
    public int size(){
        return sizeCalculator(root);
    }
    
    // Private method for the size method that calculates the number of elements in this BSTSet.
    private int sizeCalculator(TNode t){
        if(t == null){
            return 0;
        }
        
        else{
            return 1 + sizeCalculator(t.left) + sizeCalculator(t.right);
        }
    }
    
    // This method returns the height of this BSTSet
    public int height(){
        return heightCalculator(root);
    }
    
    // Private method for the height method that calculates the height of this BSTSet.
    private int heightCalculator(TNode t){
        if(t == null){
            return -1;
        }
        
        else{
            int leftHeight = heightCalculator(t.left);
            int rightHeight = heightCalculator(t.right);
            
            if(leftHeight > rightHeight){
                return leftHeight + 1;
            }
            
            else{
                return rightHeight + 1;
            }
        }
    }
    
    // This method outputs the elements of this set to the console, in increasing order.
    public void printBSTSet(){
        if(root == null){
            System.out.println("This set is empty");
        }
        
        else{
            System.out.print("The set elements are:");
            printBSTSet(root);
            System.out.print("\n");
        }
    }
    
    // Private method for printBSTSet that outputs to the console the elements stored in
    // the subtree rooted in t, in increasing order.
    private void printBSTSet(TNode t){
        if(t != null){
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ");
            printBSTSet(t.right);
        }
    }
    
    // This method prints the integers in this BSTSet in increasing order.
    public void printNonRec(){        
        if(root == null){
            System.out.println("This set is empty");
            return;
        }
        
        MyStack s = new MyStack();
        TNode t = root;
        
        System.out.print("The set elements are:");
        
        while(t != null || s.isEmpty() == false){
            while(t != null){
                s.push(t);
                t = t.left;
            }
            
            t = (TNode) s.pop();
            System.out.print(" " + t.element + ", ");
            t = t.right;
        }
        
        System.out.print("\n");
    }
}
