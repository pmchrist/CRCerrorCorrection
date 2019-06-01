import java.util.Random;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        int messageNumber = 10000000;
        int errorsCreated = 0;
        int errorsFound = 0;

        //Mask P is given as String
        System.out.println("Give a mask (as 1 line string without spaces): ");
        Scanner input = new Scanner(System.in);
        String pString = input.nextLine();
        //String Input Conversion
        int[] p = new int[pString.length()];
        for (int i = 0; i < pString.length(); i++) {
            p[i] = Character.getNumericValue(pString.charAt(i));
        }

        //Starting transmission
        for (int j=0; j<messageNumber; j++) {

            //Number of bits in each message package
            int k = 10;
            //Generate Message (each bit is random)
            int[] m = new int[k];
            Random rand = new Random();
            for (int i = 0; i < k; i++) {
                m[i] = rand.nextInt(2);
            }

            //Coding Message
            ModuloArithmetic arithmetic = new ModuloArithmetic();
            int[] codedMessage = arithmetic.getMessage(m, p);

            //Generating Error
            int errorRate = 1000;
            boolean containsError = false;
            for (int i = 0; i < codedMessage.length; i++) {
                if (rand.nextInt(errorRate) == 0) {
                    containsError = true;
                    if (codedMessage[i] == 0) {
                        codedMessage[i] = 1;
                    } else {
                        codedMessage[i] = 0;
                    }
                }
            }
            if (containsError) errorsCreated++;

            //Checking Error
            if (!arithmetic.checkMessage(codedMessage, p)) errorsFound++;
        }

        //Show statistics
        System.out.println("% of messages with error: " + (errorsCreated/(double)messageNumber)*100);
        System.out.println("% of messages with error that was found: " + (errorsFound/(double)errorsCreated)*100);
    }
}
