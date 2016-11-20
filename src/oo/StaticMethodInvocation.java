package oo;

/**
 * For class methods, the runtime system invokes the method defined in the
 * compile-time type of the reference on which the method is called.
 * 
 * For instance methods, the runtime system invokes the method defined in the 
 * runtime type of the reference on which the method is called.
 * 
 * @author vsubramanian
 */
public class StaticMethodInvocation {

    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = (Animal) myCat;
        myAnimal.hide();
        myAnimal.override();
    }
}

class Animal {
    public static void hide() {
        System.out.println("The hide method in Animal.");
    }
    public void override() {
        System.out.println("The override method in Animal.");
    }
}

class Cat extends Animal {
    public static void hide() {
        System.out.println("The hide method in Cat.");
    }
    @Override
    public void override() {
        System.out.println("The override method in Cat.");
    }
}
