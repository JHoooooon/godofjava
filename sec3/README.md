# OOP

자바는 `OOP` 언어이다.
이는 모든 사물은 객체로 되어 있으며, 이러한 객체는 `상태` 와 `행위` 로 이루어져 있다.

책은 다음과 같은 상태를 가진다.

- 펼쳐져있는 상태
- 닫혀져 있는 상태

책은 다음의 행위를 갖는다.

- 펼치는 행위
- 페이지를 넘기는 행위
- 덮는 행위

이렇게 모든 사물은 `상태` 와 `행위` 로 구분지어 만들어질수 있다.
차는 다음의 상태를 갖는다.

- 512km 을 주행한 상태
- 시속 50km 을 주행중인 상태
- 차 색깔이 빨간색인 상태

차의 행위는 다음과 같다.

- 감속하는 행위
- 가속하는 행위
- 문이 열리는 행위
...

이를 다음처럼 만들수 있다.

```java
/** Car class 선언 */
public class Car {
    /** constructor 선언 */
    public Car() {
        
    }

    /** 상태정의 */
    // 현재 속도
    int speed;
    // 주행거리
    int distance;
    // car 색상 
    String color;

    public void speedUp() {
        /** 속도 가속 행위 */
    }

    public void breakDown() {
        /** 속도 감속 행위 */
    }
}

```

## 클래스와 객체는 구분해야 한다.

`Car class` 는 말그대로 `클래스` 이다.
이러한 `클래스` 는 흔히 많이 비교하는 `붕어빵 틀` 이라고 하면,
`객체` 는 `붕어빵` 으로 생각하면 된다.

`클래스` 는 `객체` 를 만들며, 이렇게 만들어진 `객체`는 `Instance` 라 부른다.

### Car()

```java

public class Car {
    /** constructor 선언 */
    public Car() {
        
    }
..중략..
}
```

이 `Car class` 에서 `public Car() {}` 에 대해서 알아볼 필요가 있다.
이 `public Car` 는 `Constructor` 라 부르며, 매개변수를 받아 `Instance` 생성시 초기값으로 상태를 설정할수 있다.

만약, `Arguments` 를 제공하지 않는다면, 이러한 `Constructor` 를 `Default Constructor` 라 부른다.

### NEW

`new` 는 `Java` 의 `reserved word` 이다.
`new` 키워드를 사용하여, `Car` 를 호출하면, `Instance` 가 생성된다.

## Car 클래스 구현

```java
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
```

```java
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
```

```sh
$ javac CarManager.java
$ java CarManager
10
0
```

## 계산기 클래스를 만들어보자

```java
public class Calculator {
  public static void main(String[] args) {
    System.out.println("Calculator class started");
  }

  public int add(int a, int b) {
    return a + b;
  }
  public int subtract(int a, int b) {
    return a - b;
  }
  public int division(int a, int b) {
    return a / b;
  }
  public int multiply(int a, int b) {
    return a * b;
  }
}

```

```java
public class CalculatorManager {
  public static void main(String[] args) {
    Calculator cal = new Calculator();

    System.out.println(cal.add(8, 8));
    System.out.println(cal.subtract(8, 8));
    System.out.println(cal.division(8, 8));
    System.out.println(cal.multiply(8, 8));
  }
}
```

```sh
$ javac CalculatorManager.java
$ java CalculatorManager
16
0
1
64

```



