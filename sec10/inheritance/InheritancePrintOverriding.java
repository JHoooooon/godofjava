package sec10.inheritance;

public class InheritancePrintOverriding {
  public InheritancePrintOverriding() {
    System.out.println("ChildOverriding Constructor.");
  }

  public static void main(String[] args) {
    ChildOverriding child = new ChildOverriding();
    child.printName();
  }
}

