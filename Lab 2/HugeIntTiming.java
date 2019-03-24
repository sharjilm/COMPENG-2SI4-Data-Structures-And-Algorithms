/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg2;

/**
 *
 * @author Sharjil
 */
public class HugeIntTiming {   
    public HugeInteger huge1, huge2, huge3;
    public long startTime, endTime;
    public double runTime = 0.0;
    public int MAXNUMINTS = 100, MAXRUN = 1900000;
    
    public HugeIntTiming(){         
        for(int numInts=0; numInts<MAXNUMINTS; numInts++){
            huge1 = new HugeInteger(10); // creates a random integer of n digits
            huge2 = new HugeInteger(10); // creates a random integer of n digits
            startTime = System.currentTimeMillis();
            
            for(int numRun=0; numRun<MAXRUN; numRun++){
                huge3 = huge1.add(huge2);
            }
            
            endTime = System.currentTimeMillis();
            runTime += (double) (endTime - startTime)/((double) MAXRUN);
        }
        
        runTime = runTime/((double) MAXNUMINTS);
        System.out.println(endTime - startTime);
        System.out.println(runTime);
    }
}
