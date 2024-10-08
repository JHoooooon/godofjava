package sec11.inheritance;

public class Equals {
	public static void main(String args[]) {
		Equals thisObj = new Equals();
		thisObj.equalMethod();
	}
	public void equalMethod() {
		MemberDTO obj1 = new MemberDTO("Jh", "010-0000-0000", "jh@email.com");
    MemberDTO obj2 = new MemberDTO("Jh", "010-0000-0000", "jh@email.com");
		
		if (obj1.equals(obj2)) {
			System.out.println("obj1 and obj2 is same.");
		} else {
			System.out.println("obj1 and obj2 is differance.");
		}
	}

}
