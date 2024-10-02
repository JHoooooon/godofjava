# 참조 자료형

기본적으로 `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean` 을 제외한
자료형은 전부 참조 자료형이다.

## 기본 생성자

`Java` 는 생성자(`constructor`) 를 만들지 않아도 자동으로 만들어지는 기본 생성자가 있다.
이러한 기본 생성자는, 다른 생성자가 없을 경우 기본으로 컴파일할때 만들어지는 생성자이다.

> `Class` 안의 `main` 메서드는 프로그램 진입점으로 사용된다. `constructor` 와는 별개이다.

```java
public class ReferenceDefault {
    public static void main(String[] args) {
        ReferenceDefault ref = new ReferenceDefault();
    }
}
```

다음을 보자

```java
public class ReferenceString {
    public ReferenceString(String arg) {

    }
    public static void main(String[] args) {
        ReferenceString ref = new ReferenceString();
        // The constructor ReferenceString() is undefined
    }
}
````

```sh

$ javac ReferenceString.java; java ReferenceString

ReferenceString.java:6: error: constructor ReferenceString in class ReferenceString cannot be applied to given types;
        ReferenceString ref = new ReferenceString();
                              ^
  required: String
  found:    no arguments
  reason: actual and formal argument lists differ in length
1 error
Error: Could not find or load main class ReferenceString
Caused by: java.lang.ClassNotFoundException: ReferenceString
```

이 에러를 보면, argument 길이가 다르다는 에러이다.
이부분은, 책에서 말하길, 다른 생성자가 있으면, 기본 생성자를 자동으로 만들지 않는다 말한다.

해당 구문을 따로 적어본다.

> "왜 이런 오류가 발생할까?
필자가 기본 생성자에 대한 설명을 할 때 
>
>'아무런 매개 변수가 없는 ReferenceString() 이라는 생성자는 다른 생성자가 없을 경우 기본으로
기본으로 컴파일할때 만들어진다.' 라고 했다.
>
>그런데, 기본 생성자는 다른 생성자가 있으면 만들어지지 않는다."

이말은 컴파일러가 컴파일할때, `constructor` 를 생성하지 않았다면, 기본 생성자를 자동적으로 생성한다.
> 유추한다면, 여기서 생성된 `default constructor` 는 매개변수 없는 `constructor` 가 생성됨을 알수 있다.

하지만, `constructor` 가 존재한다면, 기본 생성자를 자동적으로 생성하지 않고, 
이미 만들어진 `constructor` 를 사용한다는 말로 이해된다.

지금은 기존의 만들어진 `constructor` 를 사용하므로, 만들어진 `constructor` 를 보면, `String arg` 를
받는것으로 볼 수 있다.

이렇게 만들어진 `constructor` 에서, `arg` 값이 존재하는데 `arg` 를 제공하지 않았으니 `Error` 가 난것으로
생각된다.

그럼 이를 해결하려면 다음처럼 고친다.

```java
public class ReferenceString {
    // 매개변수 없는 생성자
    public ReferenceString() {}
    // String 타입의 매개변수가 있는 생성자
    public ReferenceString(String arg) {}
    // Main 메서드
    public static void main(String[] args) {
        // 매개변수 없는 생성자를 호출
        ReferenceString ref = new ReferenceString();
    }
}
```

```sh
$ javac ReferenceString.java; java ReferenceString
# 에러 없음
```

간단하게 말하면, 생성자 선언한다면 해당 선언된 생성자를 사용하고,
그렇지 않고 생성자를 선언하지 않는다면, 컴파일러가 자동적으로 매개변수 없는 생성자를 생성한다는 말이다.

이렇게 매겨변수 없는 생성자를 자동 생성할경우, 이러한 생성자를 기본 생성자라 한다.

기본적으로 생성자는 선언부에, `access modifier` 와 `method name` 식으로 이루어져 있는 메서드이다.
다른 `class method` 와는 다르게, `return type` 이 없다.

이를 통해 생성자와 `class method` 를 구분할수 있다.
`constructor` 는 `method` 중 가장 위에 선언하는것이 많이 사용하는 컨벤션이다.


```java
public class ReferenceString {
    // -- instance valirables --
    String instanceVariable;

    // -- constructor --
    public ReferenceString() {}
    public ReferenceString(String arg) {}

    // -- methods --
    public static void main(String[] args) {
        ReferenceString ref = new ReferenceString();
    }

    public String getString() {
        return instanceVariable;
    }

    public void setString(String str) {
        instanceVariable = str;
    }
}
```

위의 `class` 구조를 살펴본다면, 쉽게 이해할수 있다.
이는 `Java` 및 여러 프로그래밍 언어에서 `class` 를 사용시 흔히 사용되는 컨벤션으로
맨 상단에는 `instance variables` 를 선언하고, 그다음 `constructor`, 그리고 `methods` 를 선언하는
방식으로 많이 구현된다.

```js
class ReferenceString {
    instanceVariable = ""
    constructor() {}

    getString() {
        return this.instanceVariable;
    }

    setString(str) {
        this.instanceVariable = str;
    }
}

const ref = new ReferenceString();
console.log(ref.getString());
ref.setString('Test');
console.log(ref.getString());
```

```sh
Welcome to Node.js v20.12.2.
Type ".help" for more information.
> class ReferenceString {
...     instanceVariable = ""
...     constructor() {}
... 
...     getString() {
...         return this.instanceVariable;
...     }
... 
...     setString(str) {
...         this.instanceVariable = str;
...     }
... }
undefined
> 
> const ref = new ReferenceString();
undefined
> console.log(ref.getString());

undefined
> ref.setString('Test');
undefined
> console.log(ref.getString());
Test
undefined
> 
```

`javascript` 는 현재 작성되는 코드 환경자체가 `global context` 이므로, `main` 이라는 진입점 없이
사용가능하다.

`class` 를 선언하는데, `instanceVariable` 을 먼저 선언하고, `constructor` 를 선언한것을 볼수 있다.

> 사실 이경우 `constructor` 는 생략가능하다. `this` 값을 통해 `class` 호출시 불러오지 않기 때문이다.

그리고 각 `method` 를 선언했다.

> 물론 `javascript` 는 `prototype based` 이기에, 기존의 `java` 와는 구현이 다르지만, `syntex suger` 로써
`class` 를 제공한다.
>
> 완벽하게, `java` 같은 객체지향 언어와 호환되지는 않지만, 적어도 비슷하게는 가능하다.

## 생성자는 몇개까지 만들수 있을까?

`ReferenceString` `class` 를 보면, 여러개의 생성자가 같이 있는것을 볼 수 있다.
`Java` 에서는 여러 매개변수를 선언할수 있도록, 여러개의 생성자를 선언할수 있도록 되어있다.

> "생성자의 개수는 1개여도 되고 100개가 되도 상관없다."

`DTO` 라는 것이 있다.
`Data Transfer Object` 의 약자이며, `Data` 를 다른 서버로 전달하기 위한것이 주목적이다.

비슷한 클래스로 `VO` 가 있다.
`Value Object` 의 앾자로, `DTO` 와 형태는 동일하지만, `VO` 는 데이터를 담아주는 역할을 한다.

> "`DTO` 가 `VO` 를 포함하는 형태이므로, `DTO` 라는 명칭을 선호한다"

한사람의 개인정보를 담는 `DTO` 클래스가 있다.

- name
- phone
- email

을 가진 `class` 이다.

```java
// MemberDTO.java

public class MemberDTO {
    public String name;
    public String phone;
    public String email;

    MemberDTO() {}
    MemberDTO(String name) {
        this.name = name;
    }
    MemberDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    MemberDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}

// ReferenceConstructor.java
public class ReferenceConstructor {
    public static void main(String [] args) {
        ReferenceConstructor ref = new ReferenceConstructor(); 
        MemberDTO [] members = ref.getMemberDTO();

        for (MemberDTO member:members) {
            System.out.println("-------------------");
            System.out.println("name= " + member.name);
            System.out.println("phone= " + member.phone);
            System.out.println("email= " + member.email);
        }
    }

    public MemberDTO [] getMemberDTO() {
        MemberDTO dto1 = new MemberDTO();
        MemberDTO dto2 = new MemberDTO("J");
        MemberDTO dto3 = new MemberDTO("J", "010xxxxyyyy");
        MemberDTO dto4 = new MemberDTO("J", "010xxxxyyyy", "test@email.com");

        return new MemberDTO [] { dto1, dto2, dto3, dto4 }
    }
}
```

```sh
$ javac ReferenceConstructor.java; java ReferenceConstructor;
-------------------
name= null
phone= null
email= null
-------------------
name= J
phone= null
email= null
-------------------
name= J
phone= 010xxxxyyyy
email= null
-------------------
name= J
phone= 010xxxxyyyy
email= test@email.com
```

제대로 출력되는것을 볼 수있다.

> 여기서 `getMemberDTO` 에서 `MemberDTO[]` 타입으로 반환할때, 중요한 점은
리터럴 배열을 사용하지 않고, `new MemberDTO [] {...}` 식으로 배열타입을 명시적으로 선언해주어야 한다.
그렇지 않으면 `Invalid enum headers` 라는 에러가 발생한다.
>

## Instance Variables 와 Parameters 를 구분하기 위한 this

`class` 의 생성자는 `Parameters` 를 받아 `Instance Variables` 에 할당하여 초기화한다.
이때, `Parameters` 와 명칭과 `Instance Variables` 간의 명칭을 똑같이 하는것이 편하다.

하지만, `class` 의 `Constructor` 역시, `method` 의 한 종류이므로, `Parameters` 는 `local variables` 로써 
사용된다.

여기서 중요한점은 `Instance Variables` 와 `Method` 의 `Local Variables` 는 `scope` 가 다르다. 
만약, `Instance Variables` 와 `Local Variables` 의 명칭이 같다면 `Local Variables` 로써 사용된다.

이는 `scope` 의 우선순위상, `Local Variables` 가 더 높은 우선순위를 가지기 때문이다.
간단하게 이야기하면 다음과 같다.

그럼, `Parameters` 를 받아서, `Instance Variables` 에 넣으려고 한다면?
그리고 `Parameters` 와 `Instance Variables` 의 명칭기 같다면?

`Parameters` 는 사실 `method` 의 `Local Variables` 로써 사용된다.
그러므로 명칭이 같다면, `Parameters` 의 우선순위가 높아지기에, `Instance Variables` 를 사용할수 없다.

다음을 보자


```java
public class MemberDTO {
    public String name;
    public String phone;
    public String email;

    MemberDTO(String name) {
        name = name; // The assignment to variable name has no effect.

        /** 이는 아래와 비슷하다.
         String name = "Test";
         name = name // 자기자신에게 할당하는것은 결국 그 결과값이 같다.
        **/

        // 보면 알겠지만 사실 `Parameters `는 `Local Variables` 이다.
        // 그러므로, 자기자신에게 다시 할당하는것과 같다.
        //
        // Instance Variables 인 name 과 Local Variables 인 name 이 같으므로,
        // 우선순위는 Local Variables 가 더 높기에 사용되는 변수는 Local Variables 이기 때문이다.
    }
}
```

이렇게 하면, 컴파일러는 매개변수 `name` 에 매개변수 `name` 을 할당한다.
그러므로, `변수이름에 할당하면 아무런 효과가 없다` 라는 `warning` 이 나온다.

이를 해결하기 위해서는 2가지 방법이 존재한다.
하나는 `Parameters` 의 명칭을 다른 명칭으로 사용하는 것이다.

```java

public class MemberDTO {
    public String name;
    public String phone;
    public String email;

    MemberDTO(String paramsName) {
        name = paramsName;
    }
}

```

이렇게 하면, 명칭이 중복되는것이 없으므로, `Instance Variables` 의 변수에 할당한다.
다른 한가지는 `Instance` 자신을 뜻하는 `this` 를 사용하여 참조하는 것이다.

```java

public class MemberDTO {
    public String name;
    public String phone;
    public String email;

    MemberDTO(String name) {
        this.name = name;
    }
}

```

`this` 를 사용하여 참조하는 방법이 가장 깔끔하다.

## method overloading

`overloading` 은 "넘치게 적재한다" 는 뜻으로 생각된다.
이말은, `method` 선언시, `Parameters` 를 다르게 만들수 있도록 하기 위한 방식이다.

즉, 한개의 `Parameters` 가 아닌, 더 많은 경우의 수에 따른 `Parameters` 를 적재하는 방식이다. 

```java
public class ReferenceOverloading {
    public static void main(String[] args) {
        ReferenceOverloading ref = new ReferenceOverloading();
    } 

    public void print(int data) {
        ...
    }
    public void print(string data) {
        ...
    }
    public void print(int intData, String stringData) {
        ...
    }
    public void print(String stringData, int intData) {
        ...
    }
}
```

보면 `print` 메서드에 사용가능한, 여러 `Parameters` 를 사용한다.
책에서는 `System.out.println` 을 예시로 `Overloading` 의 이점을 설명한다.

> "메소드중에서 `System.out.println()' 이라는 메서드가 있다.
이 메서드의 매개변수로 `int` 만 넘겨줘도 되고, `long` 만 넘겨줘도 되고, `String` 만 넘겨줘도 된다.
만약 `int` 만 넘겨줄때, `System.out.printlnInt()` 를 사용하고,
`String` 을 넘겨줄때, `System.printlinString()` 을 사용한다면 매우 불편할것이다.
>
> 매서드 오버로딩은 '같은 역할을 하는 메서드는 같은 메서드이름을 가졍하 한다' 는 모토로 사용하는것이라고
기억하면 된다."

## 메서드에서 값 넘겨주기

메서드 종료시점은 다음과 같다.

- 메서드 body 안의 코드 전부 실행되었을때
- 메서드에서 return 될때
- 메서드에서 Exception 을 Throw 할때

`javascript` 와 큰차이가 없다. 

## Static 메서드와 일반 메서드의 차이

`static` 메서드는 정적으로, `Instance` 생성없이 `class` 자체에서 사용가능한 메서드이다.
반면, `일반 메서드` 는 `Instance` 생성이후 객체에서 생성가능한 메서드이다.
여기서 생각해볼것은, `static` 메서드는 `class variables` 만 사용가능하다. 

```java
public class ReferenceStatic {
    String name = "Min";

    public static void staticMethodCallVariable() {
        System.out.println(name); // Cannot make a static reference to the non-static field name.
    }
}
```

---

`javascript` 와 큰 차이가 없다.

```javascript
class ReferenceStatic {
    name = 'Min';

    static staticMethodCallVariable() {
        console.log(name);
    }
}

```

```sh
Welcome to Node.js v20.12.2.
Type ".help" for more information.

> class ReferenceStatic {
...     name = 'Min';
... 
...     static staticMethodCallVariable() {
...         console.log(name);
...     }
... }
undefined
> ReferenceStatic.staticMethodCallVariable();
Uncaught ReferenceError: name is not defined
    at ReferenceStatic.staticMethodCallVariable (REPL47:5:21)
>
```

`javascript` 에서도 `static method` 인 `staticMethodCallVariable` 를 호출하면, `name` 이 없다는 에러가
나온다.

이는 `name` 이 `Instance Variables` (`Instance Property`) 이기 때문이다.

```sh
Welcome to Node.js v20.12.2.
Type ".help" for more information.

> const ref = new ReferenceStatic();
undefined
> ref
ReferenceStatic { name: 'Min' }

```

보면, `Instance` 변수이므로, `Instance` 생성이후, 값을 출력해보면 `{ name: 'Min'}` 이 나오는것을
볼수 있다.

---

즉, `Java` 에서는 `static` 사용시 `instance` 변수를 사용할수 없으며,
오직 `static variables` 만 사용가능하다. 

`Instance Variables` 는 인스턴스 생성이후, 만들어지는 변수이므로 참조 불가능한건 당연하다.

## static block 

`static` 블록은 객체가 생성되기 전에 한번만 호출되고, 그 이후에는 호출하려고 해도 호출할수가 없다.
그리고, 클래스 내에 선언되어 있어야 한다.

> 메서드 내에서는 선언할수 없다.

```java
public class StaticBlock {
    static int data = 1;
    public StaticBlock() {
        System.out.println("StaticBlock Constructor");
    }

    static {
        System.out.println("*** First static block. ***");
        data = 3;
    }

    static {
        System.out.println("*** Second static block. ***");
        data = 5;
    }

    public static int getData() {
        return data;
    }
}
```

이는 선언된 순서대로, 블록들이 차례대로 호출된다.
이제 위의 `StaticBlock` 을 호출해보자.

```java

public class StaticBlockCheck {
  public static void main(String[] args) {
    StaticBlockCheck check = new StaticBlockCheck();
    check.makeStaticBlockObject();
  }

  public void makeStaticBlockObject() {
    System.out.println("Creating block1");

    StaticBlock block1 = new StaticBlock();

    System.out.println("Created block1");
    System.out.println("--------------");
    System.out.println("Creating block2");

    StaticBlock block2 = new StaticBlock();

    System.out.println("Created block2");
  }
}

```

```sh
$ javac StaticBlockCheck.java; java StaticBlockCheck;

Creating block1
*** First static block. ***
*** Second static block. ***
StaticBlock Constructor
Created block1
--------------
Creating block2
StaticBlock Constructor
Created block2

```

`*** First static block. ***`
`*** Second static block. ***`

`StaticBlock` 을 2번 호출했지만, 한번만 출력된것을 볼수 있다. 

```java
public class StaticBlockCheck {
  public static void main(String[] args) {
    StaticBlockCheck check = new StaticBlockCheck();
    check.makeStaticBlockObject();
  }

  public void makeStaticBlockObject() {
    System.out.println("Creating block1");

    StaticBlock block1 = new StaticBlock();

    System.out.println("Created block1");
    System.out.println("--------------");
    System.out.println("Creating block2");
    System.out.println(StaticBlock.getData()); // 5

    StaticBlock block2 = new StaticBlock();
    StaticBlock.data = 2;

    System.out.println("Created block2");
    System.out.println(StaticBlock.getData()); // 2
  }
}
```

이렇게 하면, `5` 와 `2` 가 출력된다.
이는 `static block` 에 선언된 `data` 값이 `5` 로 호출되면서 할당되고,
이후 `staticBlock.data` 에 `2` 값을 할당해서 그렇다.

> 여기서 궁금한것은 `static variables` 인데, 책에서는 `StaticBlock Instance` 에서 값을 변경해도
그대로 적용된다는 것이다.
>
> 만약, `block2.data = 2` 라고 하면
>
> `The static field StaticBlock.data should be accessed in a static way` 라는 `warning` 이 출력된다.
>
> 이 말은, `Class` 를 통해 정적방식에 접근하라는 말이다.
> Instance 를 통해서도 접근되지만, 이는 권장하지 않으며, 실제로 정적변수는 class 에서 사용되는 변수이므로
> 해당 변수에 접근하기 위해서는 `Class` 를 통해서 접근해야 한다.
>
> Instance 로 접근해도 값이 변경되기는 한다.

`static block` 은 `static variables` 뿐만 아니라 `static methods` 도 사용할수 있다.

```java
public class StaticBlock {
    static int data = 1;
    public StaticBlock() {
        System.out.println("StaticBlock Constructor");
    }

    static {
        System.out.println("*** First static block. ***");
        data = 3;
    }

    static {
        System.out.println("*** Second static block. ***");
        data = 5;
        System.out.println(getData());
    }

    public static int getData() {
        return data;
    }
}
```
이렇게 하면, 다음처럼 출력된다.

```sh
$ javac StaticBlockCheck.java; java StaticBlockCheck;

Creating block1
*** First static block. ***
*** Second static block. ***
5 <-- 출력됨
StaticBlock Constructor
Created block1
--------------
Creating block2
5
StaticBlock Constructor
Created block2
2
```

## Pass by value, Pass by reference

이건, `Java` 에서 제공하는 메서드가 아닌, 메서드에 `value` 를 전달했을때, `reference value` 를 넘겼을때
차이점을 알기위해서 존재하는 장이다.

간단하다. `method` 내에 함수를 호출할때, `parameters`에 전달된 값이 `Primitive value` 이고,
그 값을 변경한다면, 해당값이 외부 `method` 에 영향을 받는가? 

이는 `javascript` 처럼 처리되므로, `Primitive value` 값을 전달하면 `Parameters` 역시 `Local variables`
이므로 해당 내부 함수내에서만 적용된다.

```js
function inner(primitiveValue) {
    primitiveValue = 2;
    console.log(primitiveValue); // 2
}

function func () {
    let primitiveValue = 1;
    inner(primitiveValue);
    console.log(primitiveValue); // 1
}

func();
```

이것과 비슷하게 작동한다.

```java
class ReferencePass {
    public static void main(String[] args) {
        ReferencePass ref = new ReferencePass();
        ref.callPassByValue();
    }

    public void callPassByValue() {
        int a = 10;
        String b = "b";

        System.out.println(a); // 10
        System.out.println(b); // "b"

        passByValue();

        System.out.println(a); // 10
        System.out.println(b); // "b"
    }

    public void passByValue(int a, String b) {
        a = 20;
        b = "z";

        System.out.println(a); // 20
        System.out.println(b); // "z"
    }
}

```

```sh
$ javac ReferencePass.java; java ReferencePass;

10
b
20
z
10
b
```

이를 보면, 전달된 값이 변경되지는 않는다.
반면 `reference type` 같은경우는 참조값이므로, 값이 변경된다.

```java
class ReferencePass {
    public static void main(String[] args) {
        ReferencePass ref = new ReferencePass();
        ref.callPassByValue();
    }

    public void callPassByValue() {
        int a = 10;
        String b = "b";
        MemberDTO member = new MemberDTO("JH");

        System.out.println(a); // 10
        System.out.println(b); // "b"
        System.out.println(member.name); // "JH"

        passByValue(a, b);
        passByReference(member);

        System.out.println(a); // 10
        System.out.println(b); // "b"
        System.out.println(member.name); // "JH2"
    }

    public void passByValue(int a, String b) {
        a = 20;
        b = "z";

        System.out.println(a); // 20
        System.out.println(b); // "z"
    }

  public void passByReference(MemberDTO memeber) {
    memeber.name = "JH2";

    System.out.println(memeber.name); // "JH2"
  }
}
```

`passByReference` 를 추가하고 호출한다.
이는 `MemberDTO` 타입은 `member` 를 받아 처리한다.

다음은 출력이다.

```sh
$ javac ReferencePass.java; java ReferencePass;

10
b
JH
20
z
JH2
10
b
JH2

```

이를 보면 `PrimitiveValue` 를 사용할때와는 다르게 값이 변경된것을 볼수있다.
참조값으로써 값이 변경되기 때문이다.

## 매개변수를 지정하는 특이한 방법

이는 `javascript` 의 `spread` 문법과 비슷하다.
보통 여러개의 `Parameters` 를 받기 위한 방법은, 배열을 사용하는 방법이다.

하지만, 이러한 배열을 더 쉽게 선언해서 연속으로 `Parameters` 를 받도록 할수 있다.

```java
public class MethodVarargs {
    public static void main(String [] args) {
        MethodVarargs vavargs = new MethodVarargs();
        vavargs.calcuateNumbersWithArray(new int[] {1, 2, 3, 4, 5});
        vavargs.calcuateNumbers(1, 2, 3, 4, 5);
    }

    public void calcuateNumbersWithArray(int [] numbers) {}
    public void calcuateNumbers(int ...numbers) {
        int total = 0;

        for (int number:numbers) {
            total += number;
        }

        System.out.println(total); // 15
    }
}

```

`...` 을 통해서 더 쉽게 값을 받아 처리할수있다.
이는 `Java` 에서의 고정된 배열을 넘겨주는것보다, 동적으로 `Parameters` 를 받아 처리하기에
더 용이하다.

이를 사용할때 다음의 주의점이 있다.

> 사실 `javascript` 의 주의점과 같다...

```java
public void arbitary(int ... numbers, String message) {} // Error
public void arbitary(String message, int ... numbers) {} // 제대로 됨
```

이를 보면 명확히 알수 있다.
고정적으로 사용되는 매개변수를 같이 사용할때는, 해당 매개변수를 먼저 선언하고,
그다음에 `...` 을 사용한 매개변수를 넣어주어야 한다.


