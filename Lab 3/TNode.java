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
public class TNode {
    int element;
    TNode left;
    TNode right;
    
    TNode(int i, TNode l, TNode r){
        element = i;
        left = l;
        right = r;
    }
}
