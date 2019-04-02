/*
 * Program created by Sharjil Mohsin
 * Created and finished on February 4, 2019
 * Made for a lab assignment at McMaster University
 */
package lab.pkg2;

public class TestClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
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
        
        //--------------------Test Cases for multiply()------------------------
        System.out.println("Test cases for multiply():");
        System.out.println();
        
        System.out.println("Test Case 27: Multiplication of a 5-digit number by 4-digit number using the input string "
                + "method:"); 
        HugeInteger h53 = h1.multiply(h2);
        System.out.println(h53);
        System.out.println();
        
        System.out.println("Test Case 28: Multiplication of a 4-digit number by 5-digit number using the input string "
                + "method:");
        HugeInteger h54 = h3.multiply(h4);
        System.out.println(h54);
        System.out.println();
        
        System.out.println("Test Case 29: Multiplication of a two 5-digit numbers where the first number is larger than"
                + "the second number:");
        HugeInteger h55 = h5.multiply(h6);
        System.out.println(h55);
        System.out.println();
        
        System.out.println("Test Case 30: Multiplication of a two 5-digit numbers where the first number is smaller than"
                + "the second number:");
        HugeInteger h56 = h7.multiply(h8);
        System.out.println(h56);
        System.out.println();
        
        System.out.println("Test Case 31: Multiplication of two 5-digit numbers that are exactly the same:");
        HugeInteger h57 = h9.multiply(h10);
        System.out.println(h57);
        System.out.println();
        
        System.out.println("Test Case 32: Multiplication of a negative 5-digit number by a positive 4-digit number using "
                + "the input string method:"); 
        HugeInteger h58 = h11.multiply(h12);
        System.out.println(h58);
        System.out.println();
        
        System.out.println("Test Case 33: Multiplication of a negative 4-digit number by a positive 5-digit number using "
                + "the input string method:"); 
        HugeInteger h59 = h13.multiply(h14);
        System.out.println(h59);
        System.out.println();
        
        System.out.println("Test Case 34: Multiplication of a two negative 5-digit numbers where the first number is "
                + "smaller than the second number:");
        HugeInteger h60 = h15.multiply(h16);
        System.out.println(h60);
        System.out.println();
        
        System.out.println("Test Case 35: Multiplication of a two 5-digit numbers where the first positive number is "
                + "smaller than the second negative number:");
        HugeInteger h61 = h17.multiply(h18);
        System.out.println(h61);
        System.out.println();
        
        System.out.println("Test Case 36: Multiplication of two 5-digit numbers that are exactly the same but the first"
                + "number is positive and the second number is negative:");
        HugeInteger h62 = h19.multiply(h20);
        System.out.println(h62);
        System.out.println();
        
        System.out.println("Test Case 37: Multiplication of a random 6-digit number by a random 5-digit number:");
        HugeInteger h63 = h21.multiply(h22);
        System.out.println(h63);
        System.out.println();
        
        System.out.println("Test Case 38: Multiplication of a random 3-digit number by a random 4-digit number:");
        HugeInteger h64 = h23.multiply(h24);
        System.out.println(h64);
        System.out.println();
        
        System.out.println("Test Case 39: Multiplication of a random 5-digit number by a random 5-digit number:");
        HugeInteger h65 = h25.multiply(h26);
        System.out.println(h65);
        System.out.println();
        
        //--------------------Test Cases for divide()------------------------
        System.out.println("Test cases for divide():");
        System.out.println();
        
        System.out.println("Test Case 40: Division of a 5-digit number by 4-digit number using the input string "
                + "method:"); 
        HugeInteger h66 = h1.divide(h2);
        System.out.println(h66);
        System.out.println();
        
        System.out.println("Test Case 41: Division of a 4-digit number by 5-digit number using the input string "
                + "method:");
        HugeInteger h67 = h3.divide(h4);
        System.out.println(h67);
        System.out.println();
        
        System.out.println("Test Case 42: Division of a two 5-digit numbers where the first number is larger than"
                + "the second number:");
        HugeInteger h68 = h5.divide(h6);
        System.out.println(h68);
        System.out.println();
        
        System.out.println("Test Case 43: Division of a two 5-digit numbers where the first number is smaller than"
                + "the second number:");
        HugeInteger h69 = h7.divide(h8);
        System.out.println(h69);
        System.out.println();
        
        System.out.println("Test Case 44: Division of two 5-digit numbers that are exactly the same:");
        HugeInteger h70 = h9.divide(h10);
        System.out.println(h70);
        System.out.println();
        
        System.out.println("Test Case 45: Division of a negative 5-digit number by a positive 4-digit number using the "
                + "input string method:"); 
        HugeInteger h71 = h11.divide(h12);
        System.out.println(h71);
        System.out.println();
        
        System.out.println("Test Case 46: Division of a negative 4-digit number by a positive 5-digit number using the "
                + "input string method:"); 
        HugeInteger h72 = h13.divide(h14);
        System.out.println(h72);
        System.out.println();
        
        System.out.println("Test Case 47: Division of a two negative 5-digit numbers where the first number is smaller "
                + "than the second number:");
        HugeInteger h73 = h15.divide(h16);
        System.out.println(h73);
        System.out.println();
        
        System.out.println("Test Case 48: Division of a two 5-digit numbers where the first positive number is smaller"
                + "than the second negative number:");
        HugeInteger h74 = h17.divide(h18);
        System.out.println(h74);
        System.out.println();
        
        System.out.println("Test Case 49: Division of two 5-digit numbers that are exactly the same but the first"
                + "number is positive and the second number is negative:");
        HugeInteger h75 = h19.divide(h20);
        System.out.println(h75);
        System.out.println();
        
        System.out.println("Test Case 50: Division of a random 6-digit number by a random 5-digit number:");
        HugeInteger h76 = h21.divide(h22);
        System.out.println(h76);
        System.out.println();
        
        System.out.println("Test Case 51: Division of a random 3-digit number by a random 4-digit number:");
        HugeInteger h77 = h23.divide(h24);
        System.out.println(h77);
        System.out.println();
        
        System.out.println("Test Case 52: Division of a random 5-digit number by a random 5-digit number:");
        HugeInteger h78 = h25.divide(h26);
        System.out.println(h78);
        System.out.println();
        
        //--------------------Test Cases for compareTo()------------------------
        System.out.println("Test cases for compareTo():");
        System.out.println();
        
        System.out.println("Test Case 53: Comparison of a 5-digit number with a 4-digit number using the input string "
                + "method:"); 
        System.out.println(h1.compareTo(h2));
        System.out.println();
        
        System.out.println("Test Case 54: Comparison of a 4-digit number with a 5-digit number using the input string "
                + "method:");
        System.out.println(h3.compareTo(h4));
        System.out.println();
        
        System.out.println("Test Case 55: Comparison of two 5-digit numbers where the first number is larger than"
                + "the second number:");
        System.out.println(h5.compareTo(h6));
        System.out.println();
        
        System.out.println("Test Case 56: Comparison of two 5-digit numbers where the first number is smaller than"
                + "the second number:");
        System.out.println(h7.compareTo(h8));
        System.out.println();
        
        System.out.println("Test Case 57: Comparison of two 5-digit numbers that are exactly the same:");
        System.out.println(h9.compareTo(h10));
        System.out.println();
        
        System.out.println("Test Case 58: Comparison of a negative 5-digit number with a positive 4-digit number using "
                + "the input string method:"); 
        System.out.println(h11.compareTo(h12));
        System.out.println();
        
        System.out.println("Test Case 59: Comparison of a negative 4-digit number with a positive 5-digit number using "
                + "the input string method:"); 
        System.out.println(h13.compareTo(h14));
        System.out.println();
        
        System.out.println("Test Case 60: Comparison of two negative 5-digit numbers where the first number is smaller "
                + "than the second number:");
        System.out.println(h15.compareTo(h16));
        System.out.println();
        
        System.out.println("Test Case 61: Comparison of two 5-digit numbers where the first positive number is smaller"
                + "than the second negative number:");
        System.out.println(h17.compareTo(h18));
        System.out.println();
        
        System.out.println("Test Case 62: Comparison two 5-digit numbers that are exactly the same but the first"
                + "number is positive and the second number is negative:");
        System.out.println(h19.compareTo(h20));
        System.out.println();
        
        System.out.println("Test Case 63: Comparison of a random 6-digit number with a random 5-digit number:");
        System.out.println(h21.compareTo(h22));
        System.out.println();
        
        System.out.println("Test Case 64: Comparison of a random 3-digit number with a random 4-digit number:");
        System.out.println(h23.compareTo(h24));
        System.out.println();
        
        System.out.println("Test Case 65: Comparison of a random 5-digit number with a random 5-digit number:");
        System.out.println(h25.compareTo(h26));
        System.out.println();
        
        //-------------------------SPECIAL CASES---------------------------------
        
        // Sample HugeInteger values used to test the special cases
        HugeInteger h79 = new HugeInteger("0");
        HugeInteger h80 = new HugeInteger("0");
        HugeInteger h81 = new HugeInteger("1");
        HugeInteger h82 = new HugeInteger("1");
        
        System.out.println("Special Test Cases");
        System.out.println();
        
        System.out.println("Test Case 66: Multiplication of two zeros:");
        HugeInteger h83 = h79.multiply(h80);
        System.out.println(h83);
        System.out.println();
        
        System.out.println("Test Case 67: Multiplication of a zero with a constant:");
        HugeInteger h84 = h79.multiply(h81);
        System.out.println(h84);
        System.out.println();
        
        System.out.println("Test Case 68: Multiplication of a one with a constant:");
        HugeInteger h85 = h1.multiply(h81);
        System.out.println(h85);
        System.out.println();
        
        System.out.println("Test Case 69: Multiplication of two ones:");
        HugeInteger h86 = h81.multiply(h82);
        System.out.println(h86);
        System.out.println();
        
        System.out.println("Test Case 70: Division of zero by a constant:");
        HugeInteger h87 = h79.divide(h81);
        System.out.println(h87);
        System.out.println();
        
        System.out.println("Test Case 71: Division of a constant by zero:");
        HugeInteger h88 = h82.divide(h80);
        System.out.println(h88);
        System.out.println();
        
        System.out.println("Test Case 72: Division of zero by zero:");
        HugeInteger h89 = h79.divide(h80);
        System.out.println(h89);
        System.out.println();
        
        //-------------------------ERROR CASES---------------------------------
        
        // Sample HugeInteger values used to test whether they work
        HugeInteger h90 = new HugeInteger("a");
        HugeInteger h91 = new HugeInteger("-b");
        HugeInteger h92 = new HugeInteger(-2);
        
        System.out.println("Test Case 73: Creating a constructor with the letter a as parameter:");
        System.out.println(h90);
        System.out.println();
        
        System.out.println("Test Case 74: Creating a constructor with the letter -b as parameter:");
        System.out.println(h91);
        System.out.println();
        
        System.out.println("Test Case 75: Creating a constructor with a size of -2:");
        System.out.println(h92);
        System.out.println();

    }
}
