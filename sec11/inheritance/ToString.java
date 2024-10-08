package sec11.inheritance;

public class ToString {
    public static void main(String[] args) {
        ToString thisObj = new ToString();
        thisObj.toStringMethod();
    }

 //    public void toStringMethod(Object obj) {
 //        System.out.println(obj.toString());
 //        System.out.println(obj);
 //        System.out.println("plus " + obj);
 //
 //    }
 //
    public String toString() {
        return "ToString Class";
    }

    public void toStringMethod() {
        System.out.println(this.toString());
        System.out.println(this);
        System.out.println("plus " + this);
    }
}

