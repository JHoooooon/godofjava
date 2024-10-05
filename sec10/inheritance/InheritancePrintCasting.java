package sec10.inheritance;

public class InheritancePrintCasting {
  public static void main(String[] args) {
  //    ParentCasting parent = new ParentCasting();
    ChildCasting child = new ChildCasting();

    // 상속가능
    ParentCasting parent2 = child; 
    ChildCasting child2 = (ChildCasting) parent2;

    System.out.println(child2 instanceof ChildCasting);
    System.out.println(child2 instanceof ParentCasting);
    System.out.println(parent2 instanceof ParentCasting);
  }
}
