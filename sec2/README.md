# SEC2 요약

## 컴파일

기본적으로 java 는 다음의 컴파일 단위를 갖는다

```sh
--> | 소스 | --> | 컴파일러 | --바이트코드--> | 디스크 | --바이트코드--> | JVM | --기계어---> | 운영체제 |
```

이는 작성한 프로그래밍 언어를 `소스` 라 하며, 이를 `운영체제` 에서 읽을수 있는 
`기계어` 로 변경하는 작업이 필요하다.

이는 `컴파일` 을 통해서 변환된다.
`Java` 는 기본적으로, `Oak` 라는 `Programing` 언어에서 시작되었는데,
이 언어의 목적은 바로 `cross platform` 이다.

당시에는 `OS` 및 `CPU` 에 따라, 프로그래밍 언어를 실행하는데 제약이 많이 있었다.
`Java` 를 만든 `제임스 고슬랭` 은 이러한 프로그래밍 언어의 한계를 극복하기 위해
`C, C++` 언어와 가상머신을 구현하는것을 중점으로 두어 언어를 제작했다고 한다.

그래서 슬로건이 `Write Once, Run Anywhere` 를 내세우며, 안정성및 `Java Applet` 지원으로,
인기는 급상승하며 메이저급 프로그래밍 언어로 진화했다.

이때, 여기에서 사용되는 가상머신이 바로 `Java` 에서 사용되는 `JVM` 이다.
이는 위에서 말한것처럼 `JVM` 을 통해서 `운영체제` 가 이해할수 있는 `기계어` 로 변환하는데,
`소스` 에서 `JVM` 이 읽을수 있는 `byte code`(`.class` 파일) 로 한번더 변환해야 한다.

`바이트 코드` 로 변환하는 역할은 `javac`(`java complier`) 로 변환하며, 이후 변환된 `바이트 코드` 를
`JVM` 이 읽어서 운영체제에서 실행되는 순서로 처리된다.

### 바이너리 파일이란 

현대의 컴퓨터는 이러한 이진법으로 이루어진 값을 읽어서 처리한다.
이는 `0` 과 `1` 이진법으로 이루어진 파일을 말한다.

```sh
$ javac HelloGodOfJava.java

$ ls
HelloGodOfJava.class  HelloGodOfJava.java  README.md
```

`HelloGodOfJava.class` 파일이 생긴것을 볼 수 있다.

```sh
$ java HelloGodOfJava
Hello God of Java

```
## System.out.println() 과 System.out.print()

이는 간단한다.
`System.out.println` 은 끝에 `\n` 이 있어 다음줄로 띄어쓰지만,
`System.out.print` 는 다음줄 띄어쓰기 없이 연달아서 작성된다. 

```java
public class HelloGodOfJava {
    public static void main(String[] args) {
        System.out.println("다음줄에 글을쓴다.");
        System.out.println("다음줄에 글을쓴다.");
    }
}
```

```sh
$ javac HelloGodOfJava.java
$ java HellogodOfJava

다음줄에 글을쓴다.
다음줄에 글을쓴다.
```

```java
public class HelloGodOfJava {
    public static void main(String[] args) {
        System.out.println("줄이 이어진다.");
        System.out.println("줄이 이어진다.");
    }
}
```

```sh
$ javac HelloGodOfJava.java
$ java HellogodOfJava

줄이 이어진다.줄이 이어진다.
```


