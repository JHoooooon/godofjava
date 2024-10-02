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
    System.out.println(StaticBlock.getData());

    StaticBlock block2 = new StaticBlock();
    StaticBlock.data = 2;

    System.out.println("Created block2");
    System.out.println(StaticBlock.getData());
  }
}
