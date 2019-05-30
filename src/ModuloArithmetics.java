import java.util.Arrays;

public class ModuloArithmetics {

    public int[] getMessage(int[] m, int[] p){

        //Creating temp message
        int[] tempMessage = new int[m.length+p.length];
        for (int i=0; i<m.length; i++){
            tempMessage[i]=m[i];
        }
        for (int i=m.length; i<m.length+p.length; i++){
            tempMessage[i]=0;
        }

        //Divide
        tempMessage = divide(tempMessage, p);

        //Combining original message with the reminder
        for (int i=0; i<m.length; i++){
            tempMessage[i]=m[i];
        }

        return tempMessage;
    }

    public boolean checkMessage(int[] m, int[] p){

        //Divide
        m = divide(m,p);

        for (int i=0; i<m.length; i++){
            if (m[i] == 1) return false;
        }
        return true;
    }

    private int[] divide(int[] m, int[] p){

        //Starting dividing
        int messagePivot = 0;
        int messagePivotNext = 0;
        //Until whole message has been passed
        while (messagePivotNext+p.length<m.length) {
            messagePivot = messagePivotNext;
            boolean shift = true;
            //Performing division by bit(XOR)
            for (int pPivot = 0; pPivot < p.length; pPivot++) {
                if (m[messagePivot] == p[pPivot]) {
                    m[messagePivot] = 0;
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
