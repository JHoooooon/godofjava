public class CarManager {
  public static void main(String[] args) {
    Car dogCar = new Car();
    dogCar.seedUp();
    dogCar.seedUp();
    System.out.println(dogCar.getCurrentSpeed());
    dogCar.breakDown();
    System.out.println(dogCar.getCurrentSpeed());
  }
}
