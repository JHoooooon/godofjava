public class MemberDTO {
    public String name;
    public String phone;
    public String email;

    MemberDTO() {}
    MemberDTO(String name) {
        this.name = name;
    }
    MemberDTO(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
    MemberDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
