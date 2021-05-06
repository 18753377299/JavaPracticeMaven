package javaPractice.shejimoshi.AbstractFactory;

public class BlackAnimalFactory implements AnimalFactory{
    public Cat createCat(){
        return  new BlackCat();
    }
    public Dog createDog(){
        return  new BlackDog();
    }
}
