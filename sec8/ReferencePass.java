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
