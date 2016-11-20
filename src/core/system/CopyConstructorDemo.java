/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.system;

/**
 *
 * @author vsubramanian
 */
public class CopyConstructorDemo {

    public static void main(String... aArguments) {
        Galaxy m101 = new Galaxy(15.0, "M101");

        Galaxy m101CopyOne = new Galaxy(m101);
        m101CopyOne.setMass(25.0);
        System.out.println("M101 mass: " + m101.getMass());
        System.out.println("M101Copy mass: " + m101CopyOne.getMass());

        Galaxy m101CopyTwo = Galaxy.newInstance(m101);
        m101CopyTwo.setMass(35.0);
        System.out.println("M101 mass: " + m101.getMass());
        System.out.println("M101CopyTwo mass: " + m101CopyTwo.getMass());

        System.out.println(m101.getName()==m101CopyOne.getName());
    }
}

class Galaxy {

    // PRIVATE /////
    private double fMass;
    private final String fName;

    Galaxy(double aMass, String aName) {
        fMass = aMass;
        fName = aName;
    }

    /**
     * Copy constructor.
     */
    public Galaxy(Galaxy aGalaxy) {
        this(aGalaxy.getMass(), aGalaxy.getName());
        //no defensive copies are created here, since
        //there are no mutable object fields (String is immutable)
    }

    /**
     * Alternative style for a copy constructor, using a static newInstance
     * method.
     */
    public static Galaxy newInstance(Galaxy aGalaxy) {
        return new Galaxy(aGalaxy.getMass(), aGalaxy.getName());
    }

    public double getMass() {
        return fMass;
    }

    /**
     * This is the only method which changes the state of a Galaxy
     * object. If this method were removed, then a copy constructor
     * would not be provided either, since immutable objects do not
     * need a copy constructor.
     */
    public void setMass(double aMass) {
        fMass = aMass;
    }

    public String getName() {
        return fName;
    }
}
