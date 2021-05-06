package javaPractice.shejimoshi.AbstractFactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        AnimalFactory animalFactory =new BlackAnimalFactory();
        animalFactory.createCat().eat();
        animalFactory.createDog().eat();

        AnimalFactory animalFactoryTwo =new WhiteAnimalFactory();
        animalFactoryTwo.createCat().eat();
        animalFactoryTwo.createDog().eat();


    }
}
