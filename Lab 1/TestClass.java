/*
 * Program created by Sharjil Mohsin
 * Created and finished on January 28, 2019
 * Made for a lab assignment at McMaster University
 */
package lab.pkg1;

public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // 26 sample HugeInteger values for testing
        
        // 20 of these are HugeInteger made from input string
        HugeInteger h1 = new HugeInteger("51812");
        HugeInteger h2 = new HugeInteger("4826");
        HugeInteger h3 = new HugeInteger("2825");
        HugeInteger h4 = new HugeInteger("48275");
        HugeInteger h5 = new HugeInteger("73728");
        HugeInteger h6 = new HugeInteger("25413");
        HugeInteger h7 = new HugeInteger("12345");
        HugeInteger h8 = new HugeInteger("56789");
        HugeInteger h9 = new HugeInteger("33784");
        HugeInteger h10 = new HugeInteger("33784");
        HugeInteger h11 = new HugeInteger("-51812");
        HugeInteger h12 = new HugeInteger("4826");
        HugeInteger h13 = new HugeInteger("-2825");
        HugeInteger h14 = new HugeInteger("48275");
        HugeInteger h15 = new HugeInteger("-73728");
        HugeInteger h16 = new HugeInteger("-25413");
        HugeInteger h17 = new HugeInteger("12345");
        HugeInteger h18 = new HugeInteger("-56789");
        HugeInteger h19 = new HugeInteger("33784");
        HugeInteger h20 = new HugeInteger("-33784");
        
        // 6 others are made with of the same number of digits as the input value
        HugeInteger h21 = new HugeInteger(6);
        HugeInteger h22 = new HugeInteger(5);
        HugeInteger h23 = new HugeInteger(3);
        HugeInteger h24 = new HugeInteger(4);
        HugeInteger h25 = new HugeInteger(5);
        HugeInteger h26 = new HugeInteger(5);
        
        // Checks the values of the 6 random HugeInteger
        System.out.println("Values of the 6 random HugeInteger values:");
        System.out.println(h21);
        System.out.println(h22);
        System.out.println(h23);
        System.out.println(h24);
        System.out.println(h25);
        System.out.println(h26);
        System.out.println();
                
        //--------------------TEST CASES---------------------------------
        
        //--------------------Test Cases for add()------------------------
        System.out.println("Test cases for add():");
        System.out.println();
        
        System.out.println("Test Case 1: Addition of a 5-digit number by 4-digit number using the input string method:"); 
        HugeInteger h27 = h1.add(h2);
        System.out.println(h27);
        System.out.println();
        
        System.out.println("Test Case 2: Addition of a 4-digit number by 5-digit number using the input string method:");
        HugeInteger h28 = h3.add(h4);
        System.out.println(h28);
        System.out.println();
        
        System.out.println("Test Case 3: Addition of a two 5-digit numbers where the first number is larger than"
                + "the second number:");
        HugeInteger h29 = h5.add(h6);
        System.out.println(h29);
        System.out.println();
        
        System.out.println("Test Case 4: Addition of a two 5-digit numbers where the first number is smaller than"
                + "the second number:");
        HugeInteger h30 = h7.add(h8);
        System.out.println(h30);
        System.out.println();
        
        System.out.println("Test Case 5: Addition of two 5-digit numbers that are exactly the same:");
        HugeInteger h31 = h9.add(h10);
        System.out.println(h31);
        System.out.println();
        
        System.out.println("Test Case 6: Addition of a negative 5-digit number by a positive 4-digit number using the "
                + "input string method:"); 
        HugeInteger h32 = h11.add(h12);
        System.out.println(h32);
        System.out.println();
        
        System.out.println("Test Case 7: Addition of a negative 4-digit number by a positive 5-digit number using the "
                + "input string method:"); 
        HugeInteger h33 = h13.add(h14);
        System.out.println(h33);
        System.out.println();
        
        System.out.println("Test Case 8: Addition of a two negative 5-digit numbers where the first number is smaller than"
                + "the second number:");
        HugeInteger h34 = h15.add(h16);
        System.out.println(h34);
        System.out.println();
        
        System.out.println("Test Case 9: Addition of a two 5-digit numbers where the first positive number is smaller"
                + "than the second negative number:");
        HugeInteger h35 = h17.add(h18);
        System.out.println(h35);
        System.out.println();
        
        System.out.println("Test Case 10: Addition of two 5-digit numbers that are exactly the same but the first"
                + "number is positive and the second number is negative:");
        HugeInteger h36 = h19.add(h20);
        System.out.println(h36);
        System.out.println();
        
        System.out.println("Test Case 11: Addition of a random 6-digit number by a random 5-digit number:");
        HugeInteger h37 = h21.add(h22);
        System.out.println(h37);
        System.out.println();
        
        System.out.println("Test Case 12: Addition of a random 3-digit number by a random 4-digit number:");
        HugeInteger h38 = h23.add(h24);
        System.out.println(h38);
        System.out.println();
        
        System.out.println("Test Case 13: Addition of a random 5-digit number by a random 5-digit number:");
        HugeInteger h39 = h25.add(h26);
        System.out.println(h39);
        System.out.println();
        
        //--------------------Test Cases for subtract()------------------------
        System.out.println("Test cases for subtract():");
        System.out.println();
        
        System.out.println("Test Case 14: Subtraction of a 5-digit number by 4-digit number using the input string "
                + "method:"); 
        HugeInteger h40 = h1.subtract(h2);
        System.out.println(h40);
        System.out.println();
        
        System.out.println("Test Case 15: Subtraction of a 4-digit number by 5-digit number using the input string "
                + "method:");
        HugeInteger h41 = h3.subtract(h4);
        System.out.println(h41);
        System.out.println();
        
        System.out.println("Test Case 16: Subtraction of a two 5-digit numbers where the first number is larger than"
                + "the second number:");
        HugeInteger h42 = h5.subtract(h6);
        System.out.println(h42);
        System.out.println();
        
        System.out.println("Test Case 17: Subtraction of a two 5-digit numbers where the first number is smaller than"
                + "the second number:");
        HugeInteger h43 = h7.subtract(h8);
        System.out.println(h43);
        System.out.println();
        
        System.out.println("Test Case 18: Subtraction of two 5-digit numbers that are exactly the same:");
        HugeInteger h44 = h9.subtract(h10);
        System.out.println(h44);
        System.out.println();
        
        System.out.println("Test Case 19: Subtraction of a negative 5-digit number by a positive 4-digit number using the "
                + "input string method:"); 
        HugeInteger h45 = h11.subtract(h12);
        System.out.println(h45);
        System.out.println();
        
        System.out.println("Test Case 20: Subtraction of a negative 4-digit number by a positive 5-digit number using the "
                + "input string method:"); 
        HugeInteger h46 = h13.subtract(h14);
        System.out.println(h46);
        System.out.println();
        
        System.out.println("Test Case 21: Subtraction of a two negative 5-digit numbers where the first number is smaller "
                + "than the second number:");
        HugeInteger h47 = h15.subtract(h16);
        System.out.println(h47);
        System.out.println();
        
        System.out.println("Test Case 22: Subtraction of a two 5-digit numbers where the first positive number is smaller"
                + "than the second negative number:");
        HugeInteger h48 = h17.subtract(h18);
        System.out.println(h48);
        System.out.println();
        
        System.out.println("Test Case 23: Subtraction of two 5-digit numbers that are exactly the same but the first"
                + "number is positive and the second number is negative:");
        HugeInteger h49 = h19.subtract(h20);
        System.out.println(h49);
        System.out.println();
        
        System.out.println("Test Case 24: Subtraction of a random 6-digit number by a random 5-digit number:");
        HugeInteger h50 = h21.subtract(h22);
        System.out.println(h50);
        System.out.println();
        
        System.out.println("Test Case 25: Subtraction of a random 3-digit number by a random 4-digit number:");
        HugeInteger h51 = h23.subtract(h24);
        System.out.println(h51);
        System.out.println();
        
        System.out.println("Test Case 26: Subtraction of a random 5-digit number by a random 5-digit number:");
        HugeInteger h52 = h25.subtract(h26);
        System.out.println(h52);
        System.out.println();
    }
    
}
