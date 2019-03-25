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
import java.util.Random;
import java.text.DecimalFormat;

public class TestHashTable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashTableQuad h1 = new HashTableQuad(5, 0.4);
        HashTableLin h2 = new HashTableLin(6, 0.3);
        //System.out.println(h1.getSize()+"\n\n");

        h1.insert(2);
        h1.insert(15);
        h1.insert(28);
        h1.insert(41);
        h1.insert(54);
        h1.insert(67);
        h1.insert(80);
        h1.insert(106);
        h1.insert(119);
        h1.insert(132);
        h1.insert(145);
        h1.insert(156);
        h1.insert(11);
        h1.insert(80);
        
        
        System.out.println("Test of quadratic probing for maxNum = 5, load = 0.4");
        System.out.println(h1.getMaxLoad());
        System.out.println(h1.getNumKeys());
        System.out.println(h1.getSize());
        h1.printKeysAndIndexes();
        System.out.println(h1.isIn(1));
        System.out.println("\n");
        
        h2.insert(2);
        h2.insert(45);
        h2.insert(37);
        h2.insert(52);
        h2.insert(32);
        h2.insert(56);
        h2.insert(42);
        h2.insert(41);
        
        System.out.println("Test of linear probing for maxNum = 6, load = 0.3");
        System.out.println(h2.getMaxLoad());
        System.out.println(h2.getNumKeys());
        System.out.println(h2.getSize());
        h2.printKeysAndIndexes();
        System.out.println("\n");
        
        System.out.println("********************************************* Linear Probing for Successful Search *********************************************");
        HashTableLin test;
        double calc, avg, load = 0.1;
        int count, num;
        Random R = new Random();
        DecimalFormat value = new DecimalFormat("#.#");
        
        for(int j = 0; j < 9; j++){
            avg = 0.0;
            for(int i = 0; i < 100; i++){
                count = 0;
                test = new HashTableLin(100000, load);
                while (test.getNumKeys() < 100000){
                    num = R.nextInt(1000000);
                    if (test.isIn(num) == false){
                        count += test.insertCount(num);
                    }
                }
                calc = (double)count/(double)test.getNumKeys();
                avg += calc;
                //System.out.println(test.getSize());
            }
            System.out.println("Load: " + value.format(load));
            System.out.println("Experimental: " + avg/100);
            System.out.println("Theoretical: " + (double)(0.5 * (1.0 + 1.0/(1.0 - load))) + "\n");
            load += 0.1;
        }
        
        System.out.println("********************************************* Quadratic Probing for Successful Search *********************************************");
        HashTableQuad test2;
        load = 0.1;
        
        for(int j = 0; j < 9; j++){
            avg = 0.0;
            for (int i = 0; i < 100; i++){
                count = 0;
                test2 = new HashTableQuad(100000, load);
                while (test2.getNumKeys() < 100000){
                    num = R.nextInt(1000000);
                    if (test2.isIn(num) == false){
                        count += test2.insertCount(num);
                    }
                }
                //calc = (double)((double)count)/((double)test.getNumKeys());
                calc = (double)count/(double)test2.getNumKeys();
                avg += calc;
            }
            System.out.println("Load: " + value.format(load));
            System.out.println("Experimental: " + avg/100);
            System.out.println("Theoretical: " + (double)(0.5 * (1.0 + 1.0/(1.0 - load))) + "\n");
            load += 0.1;
        }
        
        System.out.println("********************************************* Linear Probing for Unsuccessful Search *********************************************");
        HashTableLin test3;
        double calc2, avg2, load2 = 0.1;
        int count2, num2, numU;
        Random R2 = new Random();
        
        for (int j = 0; j < 9; j++){
            avg2 = 0.0;
            for (int i = 0; i < 100; i++){
                count2 = 0;
                numU = 0;
                test3 = new HashTableLin(100000, load2);
                while (test3.getNumKeys() < 100000){
                    num2 = R2.nextInt(1000000);
                    if (test3.isIn(num2) == false){
                        test3.insert(num2);
                    }
                }
                while (numU < 100000){
                    num2 = R2.nextInt(1000000);
                    if (test3.isIn(num2) == false){
                        count2 += test3.uSearchCount(num2);
                        numU++;
                    }
                }
                //calc = (double)((double)count)/((double)test.getNumKeys());
                calc2 = (double)count2/(double)100000;
                avg2 += calc2;
            }
            System.out.println("Load: " + value.format(load2));
            System.out.println("Experimental: " + avg2/100);
            System.out.println("Theoretical: " + (double)(0.5 * (1.0 + 1.0/((1.0 - load2)*(1.0 - load2)))) + "\n");
            load2 += 0.1;
        }   
    }
    
    
}
