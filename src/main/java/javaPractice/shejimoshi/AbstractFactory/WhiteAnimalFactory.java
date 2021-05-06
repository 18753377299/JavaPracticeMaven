package javaPractice.shejimoshi.AbstractFactory;

public class WhiteAnimalFactory implements AnimalFactory{
    public Cat createCat(){
        return  new WhiteCat();
    }
    public Dog createDog(){
        return  new WhiteDog();
    }
}
