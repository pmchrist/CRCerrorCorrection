
class ModuloArithmetic {

    /**
     *
     * Returns coded message for transmission
     *
     * @param m message to be coded
     * @param p mask for coding
     * @return coded message
     */
    public int[] getMessage(int[] m, int[] p){

        //Creating temp message (setting mask to 0)
        int[] tempMessage = new int[m.length+p.length];
        System.arraycopy(m, 0, tempMessage, 0, m.length);
        for (int i=m.length; i<m.length+p.length; i++){
            tempMessage[i]=0;
        }

        //Divide
        divide(tempMessage, p);

        //Combining original message with the reminder
        System.arraycopy(m, 0, tempMessage, 0, m.length);

        return tempMessage;
    }

    /**
     *
     * Checks if transmitted message is correct
     *
     * @param m message to be checked
     * @param p mask according to which we check
     * @return if message is correct
     */
    public boolean checkMessage(int[] m, int[] p){

        //Divide
        divide(m, p);

        //If message is correct, after division (checking) message will contain only 0
        for (int i1 : m) {
            if (i1 == 1) return false;
        }
        return true;
    }

    /**
     *
     * This class performs per bit modulo2 division (XOR)
     *
     * @param m message to divide
     * @param p mask according to which we divide
     * @return message after division
     */
    private int[] divide(int[] m, int[] p){

        //Starting dividing
        int messagePivot;
        int messagePivotNext = 0;
        //Until whole message has been passed
        while (messagePivotNext+p.length<m.length) {
            //We need to know where we are located in the message for the right bit shift
            messagePivot = messagePivotNext;
            boolean shift = true;
            //Performing division by bit(XOR)
            for (int i : p) {
                if (m[messagePivot] == i) {
                    m[messagePivot] = 0;
                    //We need to shift bit until division creates 1
                    if (shift) messagePivotNext++;
                } else {
                    m[messagePivot] = 1;
                    shift = false;
                }
                messagePivot++;
            }
        }
        return m;
    }

}
