# 패키지는 그냥 폴더의 개념이 아니다?

자바 애플리케이션을 개발시, 클래스들을 분류하지 않으면 이름이 중복되거나, 
어떤 클래스가 어떤일을 하는지 혼동되는 일이 발생한다.

그래서 존재하는 것이 바로 `Package` 라는 것이다.
다음의 폴더를 만들고, 이동한다.

```sh

$ mkdir -p c/javapackage; cd c/javapackage

```

그러면 현재 `c/javapackage` 안에 있다.
그리고 `Package.java` 파일을 만든다

```java
package sec9.c.javapackage;

public class Package {
    public static void main(String[] args) {
        System.out.println("Package class.");
    }
}
```

그리고 최상위 폴더로 이동한다.

```sh
$ cd ../..
```

현재 최상위 폴더는 `godofjava` 이다.
그리고 컴파일하면 제대로 실행된다.

```sh
$ javac sec9/c/javapackage/Package.java; java sec9/c/javapackage/Package
```

책에서 `pacakge` 를 생성할때, 다음과 같은 제약사항이 있다고 말한다.

- source 의 가장 첫째줄에 있어야 한다.
만약 `package` 선언 위에 주석이나 공백이 있어도 상관은 없다.
하지만, 다른 자바 문장이 하나라도 있으면 컴파일이 제대로 되지 않는다.

- 패키지 선언은 소스하나에는 하나만 있어야 한다.
한 소스파일이 두개의 폴더에 한번에 존재할수 없기 때문에 당연하다.

- 패키지 이믈과 위치한 폴더이름이 같아야만 한다.
만약 자바파일을 만들어 놓은 폴더의 이름과 여기에 선언된 패키지의 이름이 다를경우,
`javac` 로 컴파일하려고 하면 파일을 찾지 못해 컴파일이 되지 않는다.

- 패키지 이름을 지정할때, `java` 로 시작해서는 안된다.
컴파일은 정상적으로 되지만, `java.lang.SecurityException` 에러가 발생한다.

## 패키지 이름 규칙

| 패키지 시작 이름 | 내용 |
| :--- | :--- |
| java | 자바 기본 패키지(java 벤더에서 개발) |
| javax | 자바 확장 패키지 (java 벤더에서 개발) |
| org | 일반적인 비 영리단체(오픈 소스)의 패키지 |
| com | 일반적인 영리단체(회사)의 패키지 |

대부분의 코드는 이렇게 패키지가 시작된다.
가잔 대표적인 오픈소스 그룹인 `apache` 는 `org.apache` 로 끝난다.

이에 대한 주의점은 다음과 같다.

- 패키지 이름은 소문자로 지정
- 자바의 예약어를 사용하면 안됨. `int`, `static` 등의 단어가 패키지 이름에 들어있으면 안된다.
  ex) `com.int.util` 과 같이 패키지 이름에 `int` 같은 예약어가 포함되면 안됨.

## import 를 이용한 패키지 접근

자바에서는 패키지가 있을때, 같은 패키지에 있는 클래스들과 `java.lang` 패키지에 있는 클래스들만 찾을수 있다.
다른 패키지에 접근하기 위해서는 `import` 를 사용한다

```sh
# c/javapackage 에 sub 패키지 생성을 위한 폴더 생성
mkdir godofjava/sec9/c/javapackage/sub;
```

```java
// godofjava/sec9/c/javapackage/sub/Sub.java

package sec9.c.javapackage.sub;

public class Sub {
    public Sub() {}
    public void subClassMethod() {}
}

```

이렇게 생성한 `sub package` 의 `Sub` 클래스를 `c.javapackage` 의 `Package` 클래스에서 불러와 `Sub Instance` 를 생성한다.

```java
// godofjava/sec9/c/javapackage/Package.java

package sec9.c.javapackage;
import sec9.c.javapackage.sub.Sub;

public class Package {
    public static void main(String[] args) {
        sub.subClassMethod();
        Sub sub = new Sub();
    }
}
```

에러없이 실행된다.
그럼, `package` 에서 가져오는 클래스가 많으면 어떻게 될까?
만약 `Sub1, Sub2, ..., Sub100` 이 있다면?

```java
// godofjava/sec9/c/javapackage/Package.java

package sec9.c.javapackage;
import sec9.c.javapackage.sub.Sub1;
import sec9.c.javapackage.sub.Sub2;
import sec9.c.javapackage.sub.Sub3;
import sec9.c.javapackage.sub.Sub4;
// ... and so on
import sec9.c.javapackage.sub.Sub100;

public class Package {
    public static void main(String[] args) {
        sub.subClassMethod();
        Sub sub = new Sub();
    }
}
```

이렇게 하는건 매우 비효율적이다.

이럴경우 `import` 할때 모든 클래스를 가져올수있도록 `*` 이 제공된다.
그럼 해당 `package` 에 속하는 모든 클래스를 `import` 했다는 뜻이다.

```java
// godofjava/sec9/c/javapackage/Package.java

package sec9.c.javapackage;
import sec9.c.javapackage.sub.*;

public class Package {
    public static void main(String[] args) {
        sub.subClassMethod();
        Sub sub = new Sub();
    }
}

```

여기서 주의할점은, `*` 을 사용할시, 해당 패키지 밑에 있는 `class` 만 가져오지,
해당 패키지 밑에 있는 패키지들의 모든 `class` 를 `import` 하지 않는다는 점이다.

```java
import sec9.c.*; // 이는 c package 의 모든 class 를 가져온다.
                 // 하지만, c package 아래있는 `javapackage`, `sub` 
                 // 패키지의 `class` 는 가져오지 않는다.

// 만약, `javapackage` 의 `class` 를 가져오려면 다음처럼 해야 한다.
import sec9.c.javapackage.*;
// 만약, `c` 의 `class` 를 가져오려면 다음처럼 해야 한다.
import sec9.c.javapackage.c.*;

// 그러므로, 자기 직속 `class` 만 가져온다고 생각하면되며
// 중첩된 `package` 의 `class` 는 포함되지 않는다.
```

`JDK 5` 부터는 `import static` 이 추가되었다.
이는 말그대로 `class` 의 `static variables` 와 `static methods` 를 사용하고자 할때 사용된다.

```java
package sec9.c.javapackage.sub;

public class SubStatic {
    public final static String CLASS_NAME = "SubStatic";
    public static void subStatic() {
        System.out.println("subStaticMethod() is called.");
    }
}
```

이를 기존의 `import` 만 사용해서, `static` 변수와 메서드에 접근하려고 하면 다음과 같다.

```java
package sec9.c.javapackage;
// 이는 sec9.c.javapackage.sub 패키지의 class 이므로 다음처럼 사용해도 된다.
import sec9.c.javapackage.sub.*;

public class Package {
  public static void main(String[] args) {
    // SubStatic class 의 static variables CLASS_NAME 에 접근하여 출력
    System.out.println(SubStatic.CLASS_NAME);
    // SubStatic class 의 static method subStatic 메서드 호출
    SubStatic.subStatic();
  }
}
```

이를 `static import` 로 하면 다음처럼 사용가능하다.

```java
package sec9.c.javapackage;
import static sec9.c.javapackage.sub.SubStatic.subStatic;
import static sec9.c.javapackage.sub.SubStatic.CLASS_NAME;;

public class Package {
  public static void main(String[] args) {

    System.out.println(CLASS_NAME);
    subStatic();
  }
}
```

이는 굳이 `class` 이름을 사용하지 않아도 `Package` 에 선언한것처럼 사용가능하다.
만약, 각 `static` 변수 및 메서드를 직접 `import` 하기 싫다면 `*` 사용도 가능하다.

```java
package sec9.c.javapackage;
import static sec9.c.javapackage.sub.SubStatic.*;

public class Package {
  public static void main(String[] args) {

    System.out.println(CLASS_NAME);
    subStatic();
  }
}
```

`Package import` 시 `import` 하지 않아도 되는 `package` 는 다음과 같다.

- `java.lang` 패키지 
- 같은 패키지 클래스

이 같은경우 `package` 는 이미 포함된것으로 생략가능하다.
사실, `System`, `String` 같은 클래스는 모드 `java.lang` 패키지에 있다.
그래서 `import` 할 필요가 없었다.

그러므로, ***같은 패키지에 있는지, 다른 패키지에 있는지가 중요할뿐, 하위 패키지인지의 여부는
중요한 부분이 아니다*** 하위 패키지는 그저 논리적으로 패키지에 포함될뿐, 패키지를 `import` 할때
영향을 미치지 않는다. 이는 `Package` 의 상관관계를 나타낼뿐이다.

이 부분만 기억하면, `import` 여부에 대한것은 마무리된다.

## 자바의 접근 제어자

`Access modifier` 는 총 4가지 존재한다.

- public: 누구나 접근 허용
- protected: 패키지 내에 있거나, 상속받은 경우 접근 허용
- package-private: **아무런 접근 제어자를 적어주지 않을때**, `package` 내에서만 접근 허용
- private: 해당 클래스에서만 접근 허용

클래스 접근 제어자 선언할때 다음의 유의점이 있다.

```java
// godofjava/sec9/c/javapackage/PublicClass.java
package sec9.c.javapackage;

class PublicClass {
    public static void main(String[] args) {}
}

class PublicSecondClass {}

```

이 두 클래스의 선언문에 아무것도 없으므로 `package-private` 이다.
컴파일은 제대로 실행된다.

단, `package-private` 이므로, 같은 `package` 내에서만 이 `class` 를
사용할수 있다.

```java
// godofjava/sec9/c/javapackage/PublicClass.java
package sec9.c.javapackage;

public class PublicClass {
    public static void main(String[] args) {}
}

class PublicSecondClass {}
```

이렇게 사용해도 잘 된다.
하지만 다음은 컴파일되지 않는다.

```java
// godofjava/sec9/c/javapackage/PublicClass.java

package sec9.c.javapackage;

public class PublicClass {
    public static void main(String[] args) {}
}

public class PublicSecondClass {}
```

이는 다음의 에러를 내뿜는다.

```sh
Java: The public type PublicSecondClass must be defined in its own file [16777541]
```

`public type 인 PublicSecondClass 는 자체 파일에 정의되어야 한다.` 라는 에러가 나온다
이말은, `public` 타입으로 정의하려면 자기자신의 이름을 가진 파일내에서 정의하라는 말이다.

즉 `PublicClass.java`가 아닌 `PublicSecondClass.java` 내에서 `public class PublicSecondClass` 를
정의하라는 말이다..

이는 `public` 타입으로 `class` 를 정의하려면, 자기자신의 이름을 가진 소스파일에서 
정의하도록 만드는것이 좋다.

이는 구조적으로도 더 쉽게 분할되어, 클래스를 선언하도록 유도되므로 좋은 방식인듯하다.

## 

