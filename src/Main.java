public class Main {

    public static void main(String[] args) {

        //Generate Message M
        int[] m = {1, 0, 1, 0, 0, 0, 1 ,1 ,0 ,1};

        //Mask P is given
        int[] p = {1, 1, 0, 1, 0, 1};

        //Coding Message
        ModuloArithmetics arithmetics = new ModuloArithmetics();
        int[] codedMessage = arithmetics.getMessage(m, p);

        //Generating Error

        //Checking Error
        arithmetics.checkMessage(codedMessage, p);

    }
}
