public class ReferenceConstructor {
  String name = "Min";

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
        MemberDTO dto4 = new MemberDTO("J",  "010xxxxyyyy", "test@email.com");

        return new MemberDTO[] { dto1, dto2, dto3, dto4 };
    }
}
