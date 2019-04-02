/*
 * Program created by Sharjil Mohsin
 * Created and finished on February 11, 2019
 * Made for a lab assignment at McMaster University
 */
package lab.pkg2;

/**
 *
 * @author Sharjil
 */
import java.math.BigInteger;
import java.util.*;
        
public class HugeIntTiming {   
    public HugeInteger huge1, huge2, huge3;
    public BigInteger big1, big2, big3;
    public long startTime, endTime;
    public double runTime = 0.0;
    public int MAXNUMINTS = 100, MAXRUN = 1000000;
    private static Random rnd = new Random();
    int hi;
    
    public HugeIntTiming(){         
        for(int numInts=0; numInts<MAXNUMINTS; numInts++){
            huge1 = new HugeInteger(10000); // creates a random integer of n digits
            huge2 = new HugeInteger(10000); // creates a random integer of n digits
            big1 = new BigInteger(getRandomNumber(10000));
            big2 = new BigInteger(getRandomNumber(10000));
            startTime = System.currentTimeMillis();
            
            for(int numRun=0; numRun<MAXRUN; numRun++){
                //hi = huge1.compareTo(huge2);
                hi = big1.compareTo(big2);
            }
            
            endTime = System.currentTimeMillis();
            runTime += (double) (endTime - startTime)/((double) MAXRUN);
        }
        
        runTime = runTime/((double) MAXNUMINTS);
        System.out.println(endTime - startTime);
        System.out.println(runTime);
    }
    
    public static String getRandomNumber(int digCount) {
        StringBuilder sb = new StringBuilder(digCount);
        for(int i=0; i < digCount; i++)
            sb.append((char)('0' + rnd.nextInt(10)));
        return sb.toString();
    }
}
