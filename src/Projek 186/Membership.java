public class Membership {
    private String membershipName;
    private String email;
    private String membershipCode;

    public Membership() {
        membershipName = "";
        email = "";
        membershipCode = "";
    }

    public Membership(String n, String e, String mC) {
        membershipName = n;
        email = e;
        membershipCode = mC;
    }

    public void setMembership(String n, String e, String mC){
        membershipName = n;
        email = e;
        membershipCode = mC;
    }

    public String getMembershipName(){ return membershipName; }
    public String getEmail(){ return email; }
    public String getMembershipCode(){ return membershipCode; }

    public String toString(){
        return "Name: " + membershipName + "Email: " + email
        + "Membership code: " + membershipCode;
    }
}