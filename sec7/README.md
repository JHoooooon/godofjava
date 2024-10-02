# Array

배열은 여러가지 타입을 저장할수 있는 목록이다.
`Java` 에서는 다음처럼 `Array` 를 만든다.

```java

// int 형타입을 7 개 가진 배열 선언
int [] arrayLotto = new int[7];

// arrayLotto 의 배열의 첫번째 원소로 1을 할당
arrayLotto[0] = 1;
```

만약 다음처럼 `index` 의 값을 넘긴다면 에러가 발생한다

```java
class ArrayLotto {
  public static void main(String [] args) {
    ArrayLotto arrayLotto = new ArrayLotto();
    arrayLotto.init(); 
  }

  public void init() {
    int [] lottoNumbers = new int[7];
    lottoNumbers [0] = 5;
    lottoNumbers [1] = 12;
    lottoNumbers [2] = 23;
    lottoNumbers [3] = 25;
    lottoNumbers [4] = 38;
    lottoNumbers [5] = 41;
    lottoNumbers [6] = 2;
    // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 
    // Index 7 out of bounds for length 7
    lottoNumbers [7] = 9;
  }
}
```

`ArrayIndexOutOfBoundsException` 로 인한 에러이다.
여기서, `local variables` 는 초기화하지 않을때, 어떻게 작동하는지 살펴볼 필요가 있다.
`instance variables` 는 초기화하지 않을시 기본값이 지정된다고 했다.

> `Local variables` 는 초기화하지 않으면 에러난다..
> 그러므로, `Instance vairables` 를 통해 초기값을 확인했다.

```java
class Test() {
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    char c;
    public void init() {
        System.out.println(b); // 0
        System.out.println(s); // 0
        System.out.println(i); // 0
        System.out.println(l); // 0
        System.out.println(f); // 0.0
        System.out.println(d); // 0.0
        System.out.println(c); // " "
    }
}
```

이처럼 각 값은 초기화하지 않을시, 출력되는 기본값이 자동할당된다.

> 다시한번 말하지만 변수 삽입시, `local variables` 는 초기화값이 없으면, 에러난다.

이러한 방식은, 배열에서도 동작한다.
하지만 `local variables` 내에서 변수 삽입시, 배열자체를 삽입하여 저장하므로,
배열의 원소에 초기화값을 주지 않으면 기본값이 삽입되는듯 하다.

```java
class Test() {
  public static void main(String [] args) {
    Test test = new Test();
    test.init(); 
  }

  public void init() { 
    // 이는 배열을 할당하므로, 초기화값이 배열이다.
    // 그러므로 아래 배열변수들(local variables) 는
    // 배열의 값을 가지며, 초기화되지 않은, 기본값을 가진다.
    byte [] b = new byte [2];
    short [] s = new short [2];
    int [] i = new int [2];
    long [] l = new long [2];
    float [] f = new float [2];
    double [] d = new double [2];
    char [] c = new char [2];

    // 각 배열의 원소를 출력하면 기본값을 가진것을 확인할수 있다.
    System.out.println(b[0]); // 0
    System.out.println(s[0]); // 0
    System.out.println(i[0]); // 0
    System.out.println(l[0]); // 0
    System.out.println(f[0]); // 0.0
    System.out.println(d[0]); // 0.0
    System.out.println(c[0]); // " "

    // 각 배열의 원소를 출력하면 기본값을 가진것을 확인할수 있다.
    System.out.println(b[1]); //0
    System.out.println(s[1]); //0
    System.out.println(i[1]); //0
    System.out.println(l[1]); //0
    System.out.println(f[1]); //0.0
    System.out.println(d[1]); //0.0
    System.out.println(c[1]); // " " == \u0000
  }
}
```

이부분이 `javascript` 와 약간 다른부분이다.
`javascript` 는 `존재하지 않은 원소` 에 접근하면 `undefined` 이다.
`python` 은 `list index out of range` 에러가 발생한다.
하지만, `java` 는 해당 타입의 기본값으로 초기화 되어있는것을 볼 수 있다.

이는 `primitive type` 의 경우에 해당하며, `reference type` 은 약간 다르다.

```java
class RefClass { }

class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.init();
    }

    public void init() {
        RefClass[] ref = new RefClass[2];
        Test[] t = new Test[2];

        System.out.println(ref[0]); // null
        System.out.println(ref[1]); // null
        System.out.println(t[0]); // null
        System.out.println(t[1]); // null
    }
}
```

이를 보면 마치 `javascript` 에서 `undefined` 인것 처럼, `reference type` 은
`null` 이다.

`reference type` 에 값을 할당하려면 다음처럼 한다.

```java
    public void init() {
        RefClass[] ref = new RefClass[2];
        MyTest[] t = new MyTest[2];

        ref[0] = new RefClass();
        ref[1] = new RefClass();
        t[0] = new MyTest();
        t[1] = new MyTest();

        System.out.println(ref[0]); // RefClass@7ad041f3
        System.out.println(ref[1]); // RefClass@251a69d7
        System.out.println(t[0]); // MyTest@7344699f
        System.out.println(t[1]); // MyTest@6b95977
    }
```

이와 같이, 해당 클래스의 고유번호를 반환한다.
즉 여기서 강조하는 부분은 선언다음에 값 초기화하는 습관이 좋다는 것이다.
이는 예상치 못한 결과로 인해 처리가 어려워질수 있다.

> 고유번호는 `타입이름@고유번호` 로 이루어져있다.
이는 `class` 를 구분하기 위한, 고유한 값으로 생각하는 것이 좋다.

이 고유번호는 다음을 통해 더 명확하게 확인가능하다

```java

public class ArrayPrint {
    public static void main(String[] args) {
        ArrayPrint ap = new ArrayPrint();
        ap.init();
    }

    public init() {
        System.out.println(new String[0]); // [Ljava.lang.String;@1dbd16a6
        System.out.println(new ArrayPrint[0]); // [LArrayPrint;@7ad041f3
    }
}
```

이를 보면, `[` 은 배열이고,  `L` 은 해당하는 배열은 참조자료형이라는 뜻이다. 
`java.lang.String` 은 배열의 타입을 알려주고, 뒤에 `@숫자` 는 고유번호이다.

이를 통해 생성된 타입의 정보를 알수있다.

다음은 `primitive` 값을 참조하는 배열은 다음처럼 나타난다.

```java
  public void primitiveTypeInit() {
    System.out.println(new byte[1]);// [B@251a69d7
    System.out.println(new short[1]);// [S@7344699f
    System.out.println(new int[1]);// [I@6b95977
    System.out.println(new long[1]);// [J@7e9e5f8a
    System.out.println(new float[1]);// [F@8bcc55f
    System.out.println(new double[1]);// [D@58644d46
    System.out.println(new char[1]); // 책에서는 나오는데 여기에는 나오지 않는다. 버전이 달라서 그런가?
    System.out.println(new boolean[1]);// [Z@14dad5dc
  }
```
`new char[1]` 은 나오지 않는다.
일단은 넘어가도록 한다.

여기에서 보면, 각 타입의 `primitive type` 을 제공하고 있다.
이를 정리하면 다음과 같다.

| boolean | char | double | float | long | int | short | byte |
| :- | :- | :- | :- | :- | :- | :- | :- |
| Z | C | D | F | J | I | S | B |

여기에서 `Z` 와 `J` 가 유추가 안되는데, 앞에서 `L` 은 참조타입이라고 했다.
`long` 타입과 중복되므로 `L` 이 아닌 `J` 로 변경한것이라 한다.

반면, `boolean` 타입은 앞첫글자가 `b` 인데, 이미 `byte` 에서 선점해서, `Z` 로 표시된다한다.
이는 외울수밖에 없다.

> 개발할때 그다지 많이 쓰이지는 않는다고 하니, 참고만 하자.

## 배열을 선언하는 다른 방법

`new` 키워드를 사용하여, 배열선언을 했는데, 더 간단하게는 중괄호를 사용하여 선언도 가능하다.

```java
public class ArrayInintialize {
    public static void main(String args[]) {
        ArrayInintialize arr = new ArrayInintialize();
        arr.otherInt();
    }

    public void otherInt() {
        int [] lottoNumbers = {5, 12, 23, 25, 38, 41, 2};
    }
}
```

이를 통해 선언과 동시에, 값을 초기화하므로 앞의 `new` 키워드를 사용하여 배열을 선언하는것보다
바람직하다.

하지만, 여기서 생각할 필요가 있는것은, 선언과 동시에 초기화한다는 것이다.
`local variables` 는 초기화되지 않으면, 에러를 내뿜는다.

```java

    public void otherInt() {
        int [] lottoNumbers;
        lottoNumbers = {5, 12, 23, 25, 38, 41, 2}; //  Array constrants can only be used in initialize
    }

```

배열을 초기화하라는 에러가 나온다.
여기서 `new` 키워드를 사용해서 배열을 선언하는 방법과 다른 중요한 차이점은
***값이 고정된 값을 표현할때 사용한다.***


이를 아는 것은 매우중요하다.
책에서는 이렇게 중괄호를 사용하는 방식으로, 고정된 배열을 나타낸다고 한다.

> 물론, 중괄호로 만든 배열역시 값 변경이 가능하다.
> 단지 이는 고정된 배열이니, 값을 변경하지 말자는 무언의 약속과도 같은듯하다.
> Java 특유의 컨벤션인듯하다..
> 내가 알기로는 불변성을 원하면 collection 모듈을 사용해서 만들면 되지 않나?
> 싶지만, 일단 책에서 이렇다는 부분은 알아두자..

다음은 `getMonth` 를 사용하여, 고정된 배열에서 값을 가져오는 방식을 설명한 예시이다.

```java
public class Month {
    static String[] month = {'January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'Octobar', 'November', 'December'};

    public static void main(String[] args) {
        Month month = new Month();
        month.getMonth(0);
    }

    public void getMonth(int monthIndex) {
        return month[monthIndex]
    }
}

```

이를 통해 정해진 달수를 `index` 를 통해 출력한다. 
여기서 사용되 `static` 은 `Instance` 가 생성될때 만들어지는 변수가 아니라,
`Class` 내에서 사용가능한 `Class 변수`이다.

그러므로, `getMonth` 는 `Instance` 가 생성되지 않았음에도 참조해서 사용가능하다.

> 단, `static` 변수는 남용하면 안된다. 잘못 사용되면 심각한 문제가 발생할수 있기 때문이다.

## 배열을 위한 for 루프

`JDK5` 에서 자바에 큰 변화가 있었다고 한다.
이를 `for` 문을 더 단순하게 만들었는데 다음과 같다

```java

for (type variable : obj) {

}

```

이는 다음처럼 사용할수 있다.

```java
public class ArrayNewFor {
    public static void main(String[] args) {
        ArrayNewFor arr = new ArrayNewFor();
        arr.newFor();
    }

    public void newFor() {
        int[] oneDim = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int data:oneDim) {
            System.out.println(data);
            // 1
            // 2
            // 3
            // 4
            // 5
            // 6
            // 7
            // 8
            // 9
            // 10
        }
    }

}
```

매우 편해졌다.
`javascript` 의 `for of 문` 같은 느낌이다.

만약, `2 dimention` 같은 경우는 다음처럼 처리할수 잇다.

```java
public void twoDimetion() {
    int [][] twoDim = {{1, 2, 3}, {4, 5, 6}};
    for (int[] dim: twoDim) {
        for (int data: dim) {
            System.out.println(data);
        }
    }

}
```
만약, `index` 를 얻길 원한다면 다음처럼 처리한다.

```java
public void twoDimetion() {
    int [][] twoDim = {{1, 2, 3}, {4, 5, 6}};
    int twoDimIdx = 0; 
    for (int[] dim: twoDim) {
        int dimIdx = 0;
        for (int data: dim) {
            System.out.println(twoDimIdx +" "+ dimIdx + " "+ data);
            dimIdx += 1;
        }
        twoDimIdx += 1;
    }

}
```

```sh
$ javac ArrayNewFor.java; java ArrayNewFor;

0 0 1
0 1 2
0 2 3
1 0 4
1 1 5
1 2 6

```

제대로 나오는것을 볼수 있다.

