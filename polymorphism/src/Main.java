
class A {
    public void hello(){
        System.out.println("Hello from class A");
    }
}

class B extends A {
    @Override
    public void hello(){
        System.out.println("Hello from class B");
    }
}

abstract class Animal {
    public String animalType;
    public Animal(String animalType){
        this.animalType = animalType;
    }

    public void sleep(){
        System.out.println("This " + animalType + " is sleeping...");
    }

    public abstract void makeSound();
}

class Dog extends Animal{
    //There is no default constructor available in 'Animal'
    public Dog() {
        super("Dog");
    }

    // subclass Dog must implement abstract method makeSound()
    @Override
    public void makeSound() {
        System.out.println("woh woh");
    }
}

class CAT extends Animal {
    public CAT(){
        super("CAT");
    }

    @Override
    public void makeSound() {
        System.out.println("meow meow");
    }
}

// one class can implement multiple interfaces
// all methods are abstract
// interface didn't have constructor
// interface's field default be public static final
interface Edible {
    String howtoEat();
}

class Chicken extends Animal implements Edible {
    public Chicken(){
        super("Chicken");
    }

    @Override
    public void makeSound() {
        System.out.println("co co");
    }

    @Override
    public String howtoEat() {
        return "BBQ a chicken is best way";
    }
}

public class Main {
    public static void main(String[] args) {

        A b = new B();
        A a = new A();
        b.hello();
        a.hello();

        Animal dog1 = new Dog();
        Animal cat1 = new CAT();
        dog1.makeSound();
        cat1.makeSound();

        Edible chick1 = new Chicken();
        Animal chick2 = new Chicken();
        System.out.println(chick1.howtoEat());
        // System.out.println(chick2.howtoEat()); // error because Animal type does not have a howtoEat() method
        System.out.println(((Edible) chick2).howtoEat()); // cast chick2 to Edible

    }
}