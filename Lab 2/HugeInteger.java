 /*
 * Program created by Sharjil Mohsin
 * Created and finished on April 1, 2019
 * Made for a lab assignment at McMaster University
 */
package lab.pkg2;

/*
 * For this project, I wrote a HugeInteger class which is able to represent arbitrarily large numbers. This class is 
 * similar to the java.math.BigInteger class which is built-in, except that this class is written manually without using
 * anything from that class. This class implements arithmetic operations on integers such as addition and subtraction. 
 * The integers that this class will deal will are outside the integer range of (2^63)-1.
 */
public class HugeInteger {
    protected char charArray[];
    protected char sign, tempSign;
    protected int size;
    
    /*
     * The first constructor will take in a String input and store it in "val". The purpose of this constructor is to
     * take the String input and separate each letter, where each of the letters are stored in an element in the
     * character array. This character array will be the representation of the huge integer. It will also detect the sign
     * of the integer, for which it will assign the HugeInteger a negative sign is a dash if found at the beginning of 
     * the string, or a positive sign otherwise.
     */
    public HugeInteger(String val){
        char charVal;
              
        if(val.charAt(0) == '-'){ // If the String val contains a negative symbol at the beginning
            // Assigns the size of the HugeInteger and allocates the space to hold each number
            size = val.length()-1; 
            charArray = new char[size];
            
            // Check if the string contains any non-decimal digits
            for(int i=1; i<val.length(); i++){
                if((int) val.charAt(i) < 48 || (int) val.charAt(i) > 57){
                    throw new IllegalArgumentException("Non-decimal digits found in string. Please enter correctly.");
                }
            }
            
            // Sets the sign of this HugeInteger to negative
            sign = '-';
            tempSign = '-';
            
            // Fill the array with characters from the string one at a time
            for(int i=1; i<size+1; i++){
                charVal = val.charAt(i);
                charArray[i-1] = charVal;
            }
        }
        
        else{ // If the String val doesn't contain a negative symbol at the beginning
            // Assigns the size of the HugeInteger and allocates the space to hold each number
            size = val.length();
            charArray = new char[size];
            
            // Check if the string contains any non-decimal digits
            for(int i=0; i<val.length(); i++){
                if((int) val.charAt(i) < 48 || (int) val.charAt(i) > 57){
                    throw new IllegalArgumentException("Non-decimal digits found in string. Please enter correctly.");
                }
            }
            
            // Sets the sign of this HugeInteger to positive
            sign = '+';
            tempSign = '+';
            
            // Fill the array with characters from the string one at a time
            for(int i=0; i<size; i++){
                charVal = val.charAt(i);
                charArray[i] = charVal;
            }
        }
    }
    
    /*
     * The second constructor will take in an integer input and store it in the variable "n". The purpose of this
     * constructor is to take the integer input, and generate a random number between 0 and 9 n times, to represent a
     * HugeInteger of n digits. The first digit will be randomly generated between 1 and 9, while the rest of the digits
     * will be randomly generated between 0 and 9.
     */
    public HugeInteger(int n){
        double randomNum, randomGenerator = Math.random();
                
        // Check if the number of digits of the HugeInteger is valid
        if(n < 1){
            throw new IllegalArgumentException("Invalid parameter: n must be greater than or equal to 1.");
        }
        
        // Assigns the size of the HugeInteger and allocates the space to hold each number
        size = n;
        charArray = new char[size];
        
        if(randomGenerator < 0.5){ // 50% chance that the HugeInteger will be a positive number
            sign = '+';
            tempSign = '+';
        }
        
        else{ // 50% chance that the HugeInteger will be a negative number
            sign = '-';
            tempSign = '-';
        }
        
        // Generate a random number between 1 and 9 for the first digit
        randomNum = ((int)(Math.random()*9)+1) + 48;
        charArray[0] = (char) randomNum;    
 
        // Generate a random number between 0 and 9 for the remaining digits
        for(int i=1; i<size; i++){
            randomNum = ((int) (Math.random()*10)) + 48;
            charArray[i] = (char) randomNum;
        }
    }
    
    /*
     * The add method will simply add one HugeInteger with another HugeInteger to make the sum in a third HugeInteger. The
     * method uses 3 character arrays for the addition to take place; storeArray is used to hold the smaller value taken
     * in and 0s are added in the front to make it the same size as the larger value, addArray is used to hold the added
     * values of the two arrays that are being added, and the transferArray is used if the addition of the two arrays 
     * result in a HugeInteger that is one size larger than either of the two arrays.
     */
    public HugeInteger add(HugeInteger h){
        char storeArray[], addArray[], transferArray[];
        boolean transfer = false;
        HugeInteger sumInteger;
        
        /*
         * The tempSign variable is used to give the variable a temporary sign so that the correct operation can take 
         * place. If the signs don't match originally, the sign of the h variable is temporarily flipped so that the 
         * subtraction operation can take place, since addition can only occur if the two variables have the same sign.
         * Once the operation is complete, the temporary sign is restored to the original sign.
         */
        if(this.tempSign == '+' && h.tempSign == '-'){
            h.tempSign = '+';
            return this.subtract(h);
        }
        
        if(this.tempSign == '-' && h.tempSign == '+'){
            h.tempSign = '-';
            return this.subtract(h);
        }
        
        /*
         * If the size of this HugeInteger is larger than the size of HugeInteger h, then the character array of h is 
         * copied onto the storeArray. Then, the addition of this character array and the storeArray takes place in the
         * for loop. The for loop performs the addition depending on whether the numbers add up to at most 9 or more than
         * 9 and if it occurs at the first digit, the summation is transferred to another array with 1 additional space.
         * The final array of the sum is then changed to a HugeInteger type where it is returned.
         */
        if(this.size > h.size){
            int difference = this.size - h.size;
            storeArray = new char[this.size];
            addArray = new char[this.size];
            transferArray = new char[this.size+1];
            
            for(int i=h.size-1; i>=0; i--){
                storeArray[i+difference] = h.charArray[i];
            }
            
            for(int i=difference-1; i>=0; i--){
                storeArray[i] = '0';
            }
            
            for(int i=this.size-1; i>=0; i--){ 
                if((int) this.charArray[i] + (int) storeArray[i] - 48 <= 57){
                    if(i != 0){
                        if((int) this.charArray[i] + (int) storeArray[i] + (int) addArray[i] - 48 <= 57){
                            addArray[i] += (char) ((int) this.charArray[i] + (int) storeArray[i] - 48);
                        }
                        
                        else{
                            addArray[i] += (char) (((int) this.charArray[i] + (int) storeArray[i] - 48) - 10);
                            addArray[i-1] += 1;
                        }
                    }
                    
                    else{
                        if((int) this.charArray[i] + (int) storeArray[i] + (int) addArray[i] - 48 <= 57){
                            addArray[i] += (char) ((int) this.charArray[i] + (int) storeArray[i] - 48);
                        }
                        
                        else{
                            addArray[i] += (char) (((int) this.charArray[i] + (int) storeArray[i] - 48) - 10);
                        
                            for(int j=this.size-1; j>=0; j--){
                                transferArray[j+1] = addArray[j];
                            }
                        
                            transferArray[0] = '1';
                            transfer = true;
                        }
                    }
                }
                
                else{
                    addArray[i] += (char) (((int) this.charArray[i] + (int) storeArray[i] - 48) - 10);
                    addArray[i-1] += 1;
                }
            }
            
            if(transfer == false){
                sumInteger = new HugeInteger(addArray.length);
                
                for(int i=0; i<addArray.length; i++){
                    sumInteger.charArray[i] = addArray[i];
                }
            }
            
            else{
                sumInteger = new HugeInteger(transferArray.length);
                
                for(int i=0; i<transferArray.length; i++){
                    sumInteger.charArray[i] = transferArray[i];
                }
            }
            
        }
        
        /*
         * If the size of HugeInteger h is larger than the size of this HugeInteger, then this character array is 
         * copied onto the storeArray. Then, the addition of the storeArray and the h character array takes place in the
         * for loop. The for loop performs the addition depending on whether the numbers add up to at most 9 or more than
         * 9 and if it occurs at the first digit, the summation is transferred to another array with 1 additional space.
         * The final array of the sum is then changed to a HugeInteger type where it is returned.
         */
        else if(this.size < h.size){
            int difference = h.size - this.size;
            storeArray = new char[h.size];
            addArray = new char[h.size];
            transferArray = new char[h.size+1];
            
            for(int i=this.size-1; i>=0; i--){
                storeArray[i+difference] = this.charArray[i];
            }
            
            for(int i=difference-1; i>=0; i--){
                storeArray[i] = '0';
            }
            
            for(int i=h.size-1; i>=0; i--){ 
                if((int) h.charArray[i] + (int) storeArray[i] - 48 <= 57){
                    if(i != 0){
                        if((int) h.charArray[i] + (int) storeArray[i] + (int) addArray[i] - 48 <= 57){
                            addArray[i] += (char) ((int) h.charArray[i] + (int) storeArray[i] - 48);
                        }
                        
                        else{
                            addArray[i] += (char) (((int) h.charArray[i] + (int) storeArray[i] - 48) - 10);
                            addArray[i-1] += 1;
                        }
                    }
                    
                    else{
                        if((int) h.charArray[i] + (int) storeArray[i] + (int) addArray[i] - 48 <= 57){
                            addArray[i] += (char) ((int) h.charArray[i] + (int) storeArray[i] - 48);
                        }
                        
                        else{
                            addArray[i] += (char) (((int) h.charArray[i] + (int) storeArray[i] - 48) - 10);
                        
                            for(int j=h.size-1; j>=0; j--){
                                transferArray[j+1] = addArray[j];
                            }
                        
                            transferArray[0] = '1';
                            transfer = true;
                        }
                    }
                }
                
                else{
                    addArray[i] += (char) (((int) h.charArray[i] + (int) storeArray[i] - 48) - 10);
                    addArray[i-1] += 1;
                }
            }
            
            if(transfer == false){
                sumInteger = new HugeInteger(addArray.length);
                
                for(int i=0; i<addArray.length; i++){
                    sumInteger.charArray[i] = addArray[i];
                }
            }
            
            else{
                sumInteger = new HugeInteger(transferArray.length);
                
                for(int i=0; i<transferArray.length; i++){
                    sumInteger.charArray[i] = transferArray[i];
                }
            }
        }
        
        /*
         * If the size of both HugeInteger variables are the same, then this character array and the character array of h
         * is used to perform the addition using the for loop. The for loop performs the addition depending on whether 
         * the numbers add up to at most 9 or more than 9 and if it occurs at the first digit, the summation is 
         * transferred to another array with 1 additional space. The final array of the sum is then changed to a 
         * HugeInteger type where it is returned.
         */
        else{
            addArray = new char[this.size];
            transferArray = new char[this.size+1];
            
            for(int i=this.size-1; i>=0; i--){ 
                if((int) this.charArray[i] + (int) h.charArray[i] + (int) addArray[i] - 48 <= 57){
                    if(i != 0){
                        addArray[i] += (char) ((int) this.charArray[i] + (int) h.charArray[i] - 48);
                    }
                    
                    else{
                        if((int) this.charArray[i] + (int) h.charArray[i] + (int) addArray[i] - 48 <= 57){
                            addArray[i] += (char) ((int) this.charArray[i] + (int) h.charArray[i] - 48);
                        }
                        
                        else{
                            addArray[i] += (char) (((int) this.charArray[i] + (int) h.charArray[i] - 48) - 10);
                        
                            for(int j=this.size-1; j>=0; j--){
                                transferArray[j+1] = addArray[j];
                            }
                        
                            transferArray[0] = '1';
                            transfer = true;
                        }
                    }
                }
                
                else{
                    if(i != 0){
                        addArray[i] += (char) (((int) this.charArray[i] + (int) h.charArray[i] - 48) - 10);
                        addArray[i-1] += 1;
                    }
                    
                    else{
                        addArray[i] += (char) (((int) this.charArray[i] + (int) h.charArray[i] - 48) - 10);
                        
                        for(int j=this.size-1; j>=0; j--){
                            transferArray[j+1] = addArray[j];
                        }
                        
                        transferArray[0] = '1';
                        transfer = true;
                    }
                }
            }
            
            if(transfer == false){
                sumInteger = new HugeInteger(addArray.length);
                
                for(int i=0; i<addArray.length; i++){
                    sumInteger.charArray[i] = addArray[i];
                }
            }
            
            else{
                sumInteger = new HugeInteger(transferArray.length);
                
                for(int i=0; i<transferArray.length; i++){
                    sumInteger.charArray[i] = transferArray[i];
                }
            }   
        }
        
        // Assigns the sign of the new HugeInteger sum depending on whether both HugeIntegers were positive or negative
        if(this.tempSign == '-' && h.tempSign == '-'){
            sumInteger.sign = '-';
            sumInteger.tempSign = '-';
        }
        
        else{
            sumInteger.sign = '+';
            sumInteger.tempSign = '+';
        }
        
        // Restores the temporary signs of this and h HugeInteger back to their original signs
        this.tempSign = this.sign;
        h.tempSign = h.sign;
        
        return sumInteger;
    }
    
    /*
     * The subtract method will simply subtract one HugeInteger by another HugeInteger to make the difference in a third 
     * HugeInteger. The method uses 3 character arrays for the subtraction to take place; storeArray is used to hold 
     * the smaller value taken in and 0s are added in the front to make it the same size as the larger value, subArray 
     * is used to hold the subtracted values of the two arrays that are being subtracted, and the transferArray is used 
     * if the subtraction of the two arrays result in a HugeInteger that is one size smaller than either of the two 
     * arrays. There is also a boolean variable "carry" that tells us whether the number is carrying a 1 to be subtracted
     * to the number to the front, the subtraction occurs if the carry is set to true.
     */
    public HugeInteger subtract(HugeInteger h){
        char storeArray[], subArray[], transferArray[] = null;
        boolean transfer = false, carry = false;
        HugeInteger diffInteger;
        
        /*
         * The tempSign variable is used to give the variable a temporary sign so that the correct operation can take 
         * place. If the signs don't match originally, the sign of the h variable is temporarily flipped so that the 
         * subtraction operation can take place, since subtraction can only occur if the two variables have the same sign.
         * Once the operation is complete, the temporary sign is restored to the original sign.
         */
        if(this.tempSign == '+' && h.tempSign == '-'){
            h.tempSign = '+';
            return this.add(h);
        }
        
        if(this.tempSign == '-' && h.tempSign == '+'){
            h.tempSign = '-';
            return this.add(h);
        }
        
        /*
         * If the size of this HugeInteger is larger than the size of HugeInteger h, then the character array of h is 
         * copied onto the storeArray. Then, the subtraction of this character array and the storeArray takes place in 
         * the for loop. The for loop performs the subtraction depending on whether the numbers subtract down to at least
         * 0 or less than 0 and if it occurs at the first digit, the difference is transferred to another array with 1 
         * less space. The final array of the difference is then changed to a HugeInteger type where it is returned. The 
         * if statement also assigns the sign of the new HugeInteger difference depending on whether both HugeIntegers 
         * were positive or negative.
         */
        if(this.size > h.size){
            int difference = this.size - h.size;
            storeArray = new char[this.size];
            subArray = new char[this.size];
            
            for(int i=h.size-1; i>=0; i--){
                storeArray[i+difference] = h.charArray[i];
            }
            
            for(int i=difference-1; i>=0; i--){
                storeArray[i] = '0';
            }
            
            for(int i=this.size-1; i>0; i--){ 
                if((int) this.charArray[i] - (int) storeArray[i] + 48 > 48){
                    subArray[i] = (char) ((int) this.charArray[i] - (int) storeArray[i] + 48);
                    
                    if(carry == true){
                        subArray[i] -= 1;
                    }
                    
                    carry = false;
                }
                
                else if((int) this.charArray[i] - (int) storeArray[i] + 48 == 48 && carry == false){
                    subArray[i] = (char) ((int) this.charArray[i] - (int) storeArray[i] + 48);
                    
                    carry = false;
                }
                
                else if((int) this.charArray[i] - (int) storeArray[i] + 48 == 48 && carry == true){
                    subArray[i] = (char) ((int) this.charArray[i] - (int) storeArray[i] + 48);
                    subArray[i] -= 1;
                    subArray[i] += 10;
                    
                    carry = true;
                }
                
                else{
                    subArray[i] = (char) ((int) this.charArray[i] - (int) storeArray[i] + 48);
                    subArray[i] += 10;
                    
                    if(carry == true){
                        subArray[i] -= 1;
                    }
                    
                    carry = true;
                }
            }
            
            if((int) this.charArray[0] - (int) storeArray[0] + 48 > 49){
                subArray[0] += (char) ((int) this.charArray[0] - (int) storeArray[0] + 48);
                
                if(carry == true){
                    subArray[0] -= 1;
                }
            }
            
            else if((int) this.charArray[0] - (int) storeArray[0] + 48 == 49 && carry == false){
                subArray[0] += (char) ((int) this.charArray[0] - (int) storeArray[0] + 48);
            }
            
            else{
                transferArray = new char[this.size-1];
                
                for(int j=this.size-1; j>=1; j--){
                    transferArray[j-1] = subArray[j];
                }
                        
                transfer = true;
            }
            
            if(transfer == false){
                diffInteger = new HugeInteger(subArray.length);
                
                for(int i=0; i<subArray.length; i++){
                    diffInteger.charArray[i] = subArray[i];
                }
            }
            
            else{
                diffInteger = new HugeInteger(transferArray.length);
                
                for(int i=0; i<transferArray.length; i++){
                    diffInteger.charArray[i] = transferArray[i];
                }
            }
            
            if(this.tempSign == '+' && h.tempSign == '+'){
                diffInteger.sign = '+';
                diffInteger.tempSign = '+';
            }
            
            else{
                diffInteger.sign = '-';
                diffInteger.tempSign = '-';
            }
        }
        
        /*
         * If the size of HugeInteger h is larger than the size of this HugeInteger, then this character array is 
         * copied onto the storeArray. Then, the subtraction of the storeArray and the h character array takes place in 
         * the for loop. The for loop performs the subtraction depending on whether the numbers subtract down to at least
         * 0 or less than 0 and if it occurs at the first digit, the difference is transferred to another array with 1 
         * less space. The final array of the difference is then changed to a HugeInteger type where it is returned. The 
         * if statement also assigns the sign of the new HugeInteger difference depending on whether both HugeIntegers 
         * were positive or negative.
         */
        else if(this.size < h.size){
            int difference = h.size - this.size;
            storeArray = new char[h.size];
            subArray = new char[h.size];
            
            for(int i=this.size-1; i>=0; i--){
                storeArray[i+difference] = this.charArray[i];
            }
            
            for(int i=difference-1; i>=0; i--){
                storeArray[i] = '0';
            }
            
            for(int i=h.size-1; i>0; i--){ 
                if((int) h.charArray[i] - (int) storeArray[i] + 48 > 48){
                    subArray[i] = (char) ((int) h.charArray[i] - (int) storeArray[i] + 48);
                    
                    if(carry == true){
                        subArray[i] -= 1;
                    }
                    
                    carry = false;
                }
                
                else if((int) h.charArray[i] - (int) storeArray[i] + 48 == 48 && carry == false){
                    subArray[i] = (char) ((int) h.charArray[i] - (int) storeArray[i] + 48);
                    
                    carry = false;
                }
                
                else if((int) h.charArray[i] - (int) storeArray[i] + 48 == 48 && carry == true){
                    subArray[i] = (char) ((int) h.charArray[i] - (int) storeArray[i] + 48);
                    subArray[i] -= 1;
                    subArray[i] += 10;
                    
                    carry = true;
                }
                
                else{
                    subArray[i] = (char) ((int) h.charArray[i] - (int) storeArray[i] + 48);
                    subArray[i] += 10;
                    
                    if(carry == true){
                        subArray[i] -= 1;
                    }
                    
                    carry = true;
                }
            }
            
            if((int) h.charArray[0] - (int) storeArray[0] + 48 > 49){
                subArray[0] += (char) ((int) h.charArray[0] - (int) storeArray[0] + 48);
                
                if(carry == true){
                    subArray[0] -= 1;
                }
            }
            
            else if((int) h.charArray[0] - (int) storeArray[0] + 48 == 49 && carry == false){
                subArray[0] += (char) ((int) h.charArray[0] - (int) storeArray[0] + 48);
            }
            
            else{
                transferArray = new char[h.size-1];
                
                for(int j=h.size-1; j>=1; j--){
                    transferArray[j-1] = subArray[j];
                }
                        
                transfer = true;
            }
            
            if(transfer == false){
                diffInteger = new HugeInteger(subArray.length);
                
                for(int i=0; i<subArray.length; i++){
                    diffInteger.charArray[i] = subArray[i];
                }
            }
            
            else{
                diffInteger = new HugeInteger(transferArray.length);
                
                for(int i=0; i<transferArray.length; i++){
                    diffInteger.charArray[i] = transferArray[i];
                }
            }
            
            if(this.tempSign == '+' && h.tempSign == '+'){
                diffInteger.sign = '-';
                diffInteger.tempSign = '-';
            }
            
            else{
                diffInteger.sign = '+';
                diffInteger.tempSign = '+';
            }
        }
        
        /*
         * If the size of both HugeInteger variables are the same, then this character array and the character array of h
         * is used to perform the subtraction using the for loop. The for loop performs the subtraction depending on 
         * whether the numbers subtract down to at least 0 or less than 0 and if it occurs at the first digit, the 
         * difference is transferred to another array with 1 less space. The final array of the difference is then 
         * changed to a HugeInteger type where it is returned. The if statement also assigns the sign of the new 
         * HugeInteger difference depending on whether both HugeIntegers were positive or negative.
         */
        else{
            int condition = 0;
            
            for(int i=0; i<this.size; i++){
                if((int) this.charArray[i] > (int) h.charArray[i]){
                    condition = 1;
                    break;
                }
                
                else if((int) this.charArray[i] < (int) h.charArray[i]){
                    condition = 2;
                    break;
                }
            }
                                   
            switch(condition){
                case 1:
                    subArray = new char[this.size];
                    
                    for(int i=this.size-1; i>0; i--){
                        if((int) this.charArray[i] - (int) h.charArray[i] + 48 > 48){
                            subArray[i] = (char) ((int) this.charArray[i] - (int) h.charArray[i] + 48);
                            
                            if(carry == true){
                                subArray[i] -= 1;
                            }
                            
                            carry = false;
                        }
                        
                        else if((int) this.charArray[i] - (int) h.charArray[i] + 48 == 48 && carry == false){
                            subArray[i] = (char) ((int) this.charArray[i] - (int) h.charArray[i] + 48);
                            
                            carry = false;
                        }
                        
                        else if((int) this.charArray[i] - (int) h.charArray[i] + 48 == 48 && carry == true){
                            subArray[i] = (char) ((int) this.charArray[i] - (int) h.charArray[i] + 48);
                            subArray[i] -= 1;
                            subArray[i] += 10;
                            
                            carry = true;
                        }
                        
                        else{
                            subArray[i] = (char) ((int) this.charArray[i] - (int) h.charArray[i] + 48);
                            subArray[i] += 10;
                            
                            if(carry == true){
                                subArray[i] -= 1;
                            }
                            
                            carry = true;
                        }
                    }   
                    
                    if((int) this.charArray[0] - (int) h.charArray[0] + 48 > 49){
                        subArray[0] += (char) ((int) this.charArray[0] - (int) h.charArray[0] + 48);
                        
                        if(carry == true){
                            subArray[0] -= 1;
                        }
                    }
                    
                    else if((int) this.charArray[0] - (int) h.charArray[0] + 48 == 49 && carry == false){
                        subArray[0] += (char) ((int) this.charArray[0] - (int) h.charArray[0] + 48);
                    }
                    
                    else{
                        transferArray = new char[this.size-1];
                        
                        for(int j=this.size-1; j>=1; j--){
                            transferArray[j-1] = subArray[j];
                        }
                        
                        transfer = true;
                    }   
                    
                    if(transfer == false){
                        diffInteger = new HugeInteger(subArray.length);
                        
                        for(int i=0; i<subArray.length; i++){
                            diffInteger.charArray[i] = subArray[i];
                        }
                    }

                    else{
                        diffInteger = new HugeInteger(transferArray.length);
                        
                        for(int i=0; i<transferArray.length; i++){
                            diffInteger.charArray[i] = transferArray[i];
                        }
                    }
                    
                    if(this.tempSign == '+' && h.tempSign == '+'){
                        diffInteger.sign = '+';
                        diffInteger.tempSign = '+';
                    }

                    else{
                        diffInteger.sign = '-';
                        diffInteger.tempSign = '-';
                    }
                    
                    break;
                
                case 2:
                    subArray = new char[h.size];
                    
                    for(int i=h.size-1; i>0; i--){
                        if((int) h.charArray[i] - (int) this.charArray[i] + 48 > 48){
                            subArray[i] = (char) ((int) h.charArray[i] - (int) this.charArray[i] + 48);
                            
                            if(carry == true){
                                subArray[i] -= 1;
                            }
                            
                            carry = false;
                        }
                        
                        else if((int) h.charArray[i] - (int) this.charArray[i] + 48 == 48 && carry == false){
                            subArray[i] = (char) ((int) h.charArray[i] - (int) this.charArray[i] + 48);
                            
                            carry = false;
                        }
                        
                        else if((int) h.charArray[i] - (int) this.charArray[i] + 48 == 48 && carry == true){
                            subArray[i] = (char) ((int) h.charArray[i] - (int) this.charArray[i] + 48);
                            subArray[i] -= 1;
                            subArray[i] += 10;
                            
                            carry = true;
                        }
                        
                        else{
                            subArray[i] = (char) ((int) h.charArray[i] - (int) this.charArray[i] + 48);
                            subArray[i] += 10;
                            
                            if(carry == true){
                                subArray[i] -= 1;
                            }
                            
                            carry = true;
                        }
                    }   
                    
                    if((int) h.charArray[0] - (int) this.charArray[0] + 48 > 49){
                        subArray[0] += (char) ((int) h.charArray[0] - (int) this.charArray[0] + 48);
                        
                        if(carry == true){
                            subArray[0] -= 1;
                        }
                    }
                    
                    else if((int) h.charArray[0] - (int) this.charArray[0] + 48 == 49 && carry == false){
                        subArray[0] += (char) ((int) h.charArray[0] - (int) this.charArray[0] + 48);
                    }

                    else{
                        transferArray = new char[h.size-1];
                        
                        for(int j=h.size-1; j>=1; j--){
                            transferArray[j-1] = subArray[j];
                        }
                        
                        transfer = true;
                    }   
                    
                    if(transfer == false){
                        diffInteger = new HugeInteger(subArray.length);
                        
                        for(int i=0; i<subArray.length; i++){
                            diffInteger.charArray[i] = subArray[i];
                        }
                    }
                    
                    else{
                        diffInteger = new HugeInteger(transferArray.length);
                        
                        for(int i=0; i<transferArray.length; i++){
                            diffInteger.charArray[i] = transferArray[i];
                        }
                    }
                    
                    if(this.tempSign == '+' && h.tempSign == '+'){
                        diffInteger.sign = '-';
                        diffInteger.tempSign = '-';
                    }

                    else{
                        diffInteger.sign = '+';
                        diffInteger.tempSign = '+';
                    }

                    break;
                
                default:
                    diffInteger = new HugeInteger("0");
                    
                    break;
            }
        }

        // Restores the temporary signs of this and h HugeInteger back to their original signs
        this.tempSign = this.sign;
        h.tempSign = h.sign;
        
        return diffInteger;
    }
        
    /*
     * The multiply method will simply multiply one HugeInteger by another HugeInteger to make the product in a third 
     * HugeInteger. The method has 2 sets of zero counters to check if this HugeInteger or the h HugeInteger is 0. If
     * one of these HugeInteger values is 0, then the method will return 0 as the product will be 0. The method also has
     * 2 sets of one counters that check whether one of the HugeInteger is just 1. If both HugeIntegers are 1, then the 
     * method returns just 1. If only on of the HugeInteger is 1, then the method returns the other HugeInteger. This 
     * method utlizes the StringBulder class to deal with the addition of the first HugeInteger and the addition is 
     * performed the same number of times as the second HugeInteger. 
     */
    public HugeInteger multiply(HugeInteger h){
        int thisZeroCounter = 0, hZeroCounter = 0, thisOneCounter = 0, hOneCounter = 0;
        
        StringBuilder longNum = new StringBuilder();
        StringBuilder shortNum = new StringBuilder();
        StringBuilder tempString;
        StringBuilder countNum = new StringBuilder();
        
        for(int i=0; i<this.size; i++){
            if(this.charArray[i] == '0'){
                thisZeroCounter++;
            }
        }
        
        for(int i=0; i<h.size; i++){
            if(h.charArray[i] == '0'){
                hZeroCounter++;
            }
        }
        
        if(thisZeroCounter == this.size || hZeroCounter == h.size){
            return new HugeInteger("0");
        }
        
        for(int i=0; i<this.size; i++){
            if(this.charArray[i] == '1'){
                thisOneCounter++;
            }
        }
        
        for(int i=0; i<h.size; i++){
            if(h.charArray[i] == '1'){
                hOneCounter++;
            }
        }
        
        if((thisOneCounter == 1 && this.charArray[this.size-1] == '1') && (hOneCounter == 1 && h.charArray[h.size-1] == '1')){
            return new HugeInteger("1");
        }
        
        if(thisOneCounter == 1 && this.charArray[this.size-1] == '1'){
            String array = new String(h.charArray);
            return new HugeInteger(array);
        }
        
        if(hOneCounter == 1 && h.charArray[h.size-1] == '1'){
            String array = new String(this.charArray);
            return new HugeInteger(array);
        }
        
        for(int i=0; i<this.size; i++){
            longNum.insert(i, this.charArray[i]);
        }
        
        for(int i=0; i<h.size; i++){
            shortNum.insert(i, h.charArray[i]);
        }
        
        if(h.size > this.size){
            tempString = shortNum;
            shortNum = longNum;
            longNum = tempString;
            
            countNum.setLength(this.size);
        }
        
        else{
            countNum.setLength(h.size);
        }
        
        HugeInteger prodInteger = new HugeInteger(longNum.toString());
        HugeInteger count = new HugeInteger("1");
        
        while(!countNum.toString().equals(shortNum.toString())){
            prodInteger = prodInteger.add(new HugeInteger(longNum.toString()));
            count = count.add(new HugeInteger("1"));
            
            for(int i=0; i<count.size; i++){
                countNum.setCharAt(i, count.charArray[i]);
            }
        }
              
        if(this.sign == h.sign){
            prodInteger.sign = '+';
        }
        
        else{
            prodInteger.sign = '-';
        }
        
        return prodInteger;
    }
 
    /*
     * The divide method will simply divide one HugeInteger by another HugeInteger to make the quotient in a third 
     * HugeInteger. The method has 2 sets of zero counters to check if this HugeInteger or the h HugeInteger is 0.
     * If this HugeInteger is found to be 0, then method returns 0 as 0 divided by anything is 0. If h HugeInteger
     * is 0, then the method will print out an error stating that division by 0 is not possible. It also checks a
     * case where this HugeInteger is smaller than h HugeIntger, for which the method returns 0. Otherwise, this
     * method utlizes the StringBulder class to deal with the subtraction of the first HugeInteger and the subtraction
     * is done enough times so the first HugeInteger is brought down to 0. That number of times is the quotient and 
     * thus returns to the user.
     */
    public HugeInteger divide(HugeInteger h){
        int thisZeroCounter = 0, hZeroCounter = 0;
        
        StringBuilder firstNum = new StringBuilder();
        StringBuilder secondNum = new StringBuilder();
        StringBuilder countNum = new StringBuilder();
        
        for(int i=0; i<this.size; i++){
            if(this.charArray[i] == '0'){
                thisZeroCounter++;
            }
        }
        
        for(int i=0; i<h.size; i++){
            if(h.charArray[i] == '0'){
                hZeroCounter++;
            }
        }
        
        if(thisZeroCounter == this.size){
            return new HugeInteger("0");
        }
        
        if(hZeroCounter == h.size){
            throw new ArithmeticException("Division by zero, not possible.");
        }
        
        if(this.size < h.size){
            return new HugeInteger("0");
        }
        
        if(this.size == h.size){
            for(int i=0; i<this.size; i++){
                if(this.charArray[i] < h.charArray[i]){
                    return new HugeInteger("0");
                }
            }
        }
        
        for(int i=0; i<this.size; i++){
            firstNum.insert(i, this.charArray[i]);
        }
        
        for(int i=0; i<h.size; i++){
            secondNum.insert(i, h.charArray[i]);
        }
        
        HugeInteger numHolder = new HugeInteger(firstNum.toString());
        HugeInteger divInteger = new HugeInteger("0");
        
        countNum.setLength(this.size);
        
        for(int i=0; i<numHolder.size; i++){
            countNum.setCharAt(i, numHolder.charArray[i]);
        }
        
        HugeInteger count = new HugeInteger(countNum.toString());
        HugeInteger divisor = new HugeInteger(secondNum.toString());
        
        while(count.compareTo(divisor) >= 0){
            numHolder = numHolder.subtract(new HugeInteger(secondNum.toString()));
            divInteger = divInteger.add(new HugeInteger("1"));
            
            if(countNum.length() != numHolder.size){
                countNum.deleteCharAt(countNum.length()-1);
            }
            
            for(int i=0; i<numHolder.size; i++){
                countNum.setCharAt(i, numHolder.charArray[i]);
            }
            
            count = new HugeInteger(countNum.toString());
        }
        
        if(this.sign == h.sign){
            divInteger.sign = '+';
        }
        
        else{
            divInteger.sign = '-';
        }
        
        return divInteger;
    }
    
    /*
     * The compareTo method takes the two HugeIntegers and returns a result depending on whether this HugeInteger is
     * less than, greater than, or equal to h. The method returns -1 if this HugeInteger is less than h, returns 1 
     * if this HugeInteger is larger than h, and returns 0 is this HugeInteger is equal to h.
     */
    public int compareTo(HugeInteger h){
        if(this.sign == '-' && h.sign == '+'){
            return -1;
        }
        
        else if(this.sign == '+' && h.sign == '-'){
            return 1;
        }
        
        else if(this.sign == '+' && h.sign == '+'){
            if(this.size > h.size){
                return 1;
            }
            
            else if(this.size < h.size){
                return -1;
            }
            
            else{
                for(int i=0; i<this.size; i++){
                    if((int) this.charArray[i] > (int) h.charArray[i]){
                        return 1;
                    }

                    else if((int) this.charArray[i] < (int) h.charArray[i]){
                        return -1;
                    }

                    else{
                        return 0;
                    }
                }
            }
        }
        
        else{
            if(this.size > h.size){
                return -1;
            }
            
            else if(this.size < h.size){
                return 1;
            }
            
            else{
                for(int i=0; i<this.size; i++){
                    if((int) this.charArray[i] > (int) h.charArray[i]){
                        return -1;
                    }

                    else if((int) this.charArray[i] < (int) h.charArray[i]){
                        return 1;
                    }

                    else{
                        return 0;
                    }
                }
            }
        }
        
        return 0;
    }
    
    /*
     * The toString method returns a string representing the sequence of digits corresponding to the decimal 
     * representation ofthis HugeInteger.
     */
    public String toString(){
        String number = new String(this.charArray);
        String numSign = String.valueOf(this.sign);
        String result = numSign.concat(number);
        
        return result;
    }
}
