package sec11.inheritance;

public class MemberDTO {
    public String name;
    public String phone;
    public String email;

    MemberDTO(String name, String phone, String email) {
      this.name = name;
      this.email = email;
      this.phone = phone;
    }

    public static void main(String[] args) {
      MemberDTO dto = new MemberDTO("Test", "010-1111-1111", "test@email.com");
      System.out.println(dto);
    }


    public String toString() {;
        return "Name=" + this.name + "Phone=" + this.phone + "Email=" + this.email;
    }

    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return true;
      if (this.getClass() != obj.getClass()) return false;
      
      MemberDTO other = (MemberDTO) obj;

      if (name == null) {
        if (other.name != null) return false;
      } else if (!name.equals(other.name)) {
        return false;

      }
      if (email == null) {
        if (other.email != null) return false;
        else if (!email.equals(other.email)) {
          return false;
        }
      }

      if (phone == null) {
        if (other.phone != null) return false;
        else if (!phone.equals(other.phone)) {
          return false;
        }
      }

      return true;
  }
}
