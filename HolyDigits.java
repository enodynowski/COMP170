public class HolyDigits {
    public static void main (String[] args){
        
        addressFinder();

    }
    public static void addressFinder(){
        int thousands, hundreds, tens, ones;
        /* wow this was awful and took me forever. So many accidental infinite loops :(
        anyway this creates a new loop for each digit, and increments it 1-9, then on the innermost loop runs the tests 
        for the various conditions of the addresS using a series of if statements, one for each condition. 
        then finall it prints the address once it makes its way through all the if blocks */
        for (thousands = 0; thousands <= 9; thousands++){
            for(hundreds = 0; hundreds <= 9; hundreds ++){
                for (tens = 0; tens <= 9; tens++){
                    for (ones = 0; ones <= 9; ones++){
                        if (thousands + hundreds + tens + ones == 27){
                            if (ones % 2 != 0){
                                if ((thousands != hundreds) && (hundreds != tens) && (tens != ones) && (hundreds != ones) && (thousands != ones)){
                                    if (thousands == tens *3){
                                        System.out.println("The address is " + thousands + hundreds + tens + ones + " Pennsylvania Ave");

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }   
    }
}   
