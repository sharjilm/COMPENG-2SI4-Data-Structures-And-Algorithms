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
public class MyStack {
    private Node head;
    
    public MyStack(){
        head = null;
    }
    
    public boolean isEmpty(){
        return (head == null);
    }
    
    public void push(TNode e){
        head = new Node(e, head);
    }
    
    public TNode pop(){
        if(isEmpty()){
            throw new NullPointerException("Stack Underflow");
        }
        
        else{
            TNode e = head.element;
            head = head.next;
            return e;
        }
    }
}
