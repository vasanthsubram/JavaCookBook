package oo;


/**
 * This class implements two interfaces whose methods differ only in the return type
 * It requires only one method to implemented
 *
 * It is odd that there is no compile error
 * @author vsubramanian
 */
public class InterfacesAndReturnType implements Sing, Speaker {

    public String sing() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

interface Sing{
    String sing();
}
interface Speaker{
    Object sing();
}