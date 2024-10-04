package sec9.c.javapackage;
// import sec9.c.javapackage.sub.*;
import static sec9.c.javapackage.sub.SubStatic.subStatic;
import static sec9.c.javapackage.sub.SubStatic.CLASS_NAME;;

public class Package {
  public static void main(String[] args) {
    // System.out.println("Package class.");
    // Sub sub = new Sub();
    // sub.subClassMethod();

    System.out.println(CLASS_NAME);
    subStatic();
  }
}
