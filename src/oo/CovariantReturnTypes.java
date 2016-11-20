package oo;

/**
 * If the return type is a reference type then the overriding method can declare a 
 * return type that is sub-type of that declared by the super class method - 
 * this is called a covariant return type.
 * If the return type is a primitive, type, then the return type of the overriding method
 * must be identical to that of the superclass method.
 * 
 * @author vsubramanian
 */
public class CovariantReturnTypes {

    public static void main(String[] args) {
        AA obj = new AA();
        System.out.println(obj.print());
        obj = new BB();
        System.out.println(obj.print());
    }
}

class AA {

    Object print() {
        return "A";
    }
}

class BB extends AA {

    @Override
    String print() {
        return "B";
    }
}
