package core.basicJava;

public class PassReferenceByValue {
    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Bob";
        person.changeName(person);
        System.out.println(person.name);  // ➜ Alice

    }

    static class Person {
        String name;

        void changeName(Person p) {
            p.name = "Alice";  // modifies the object's field
            //Here, ‘p’ is a copy of the reference to the same object in memory. So you can modify the object it points to.
        }
    }

}
