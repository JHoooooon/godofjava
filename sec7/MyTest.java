class RefClass {
  public static void main(String[] args) {
    System.out.println("Ref");
  }
};

class MyTest {
    public static void main(String[] args) {
        MyTest t = new MyTest();
        t.init();
    }

    public void init() {
        RefClass[] ref = new RefClass[2];
        MyTest[] t = new MyTest[2];

        ref[0] = new RefClass();
        ref[1] = new RefClass();
        t[0] = new MyTest();
        t[1] = new MyTest();

        System.out.println(ref[0]);
        System.out.println(ref[1]);
        System.out.println(t[0]);
        System.out.println(t[1]);
    }
}
