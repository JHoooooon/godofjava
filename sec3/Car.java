public class Car {
  int speed;
  int distance;
  String color;

  public Car() {

  }

  public void seedUp() {
    /** speed 는 5 씩 증가 */
    speed += 5;
  }
  public void breakDown() {
    /** speed 는 10 씩 감소 */
    speed -= 10;
  }
  public int getCurrentSpeed() {
    /** 현재 speed 반환 */
    return speed;
  }
}
