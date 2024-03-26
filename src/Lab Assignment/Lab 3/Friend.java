public class Friend{
    private int idno;
    private String name, hpno, email;

    public Friend (int id, String n, String hp, String em){
        idno = id;
        name = n;
        hpno = hp;
        email = em;
    }
    public int getId(){ return idno; }
    public String getName(){ return name; }
    public String getHP(){ return hpno; }
    public String getEmail(){ return email; }
    
    public void setName(String n){
        name = n;
    }
    public void setHP(String hp){
        hpno = hp;
    }
    public void setEmail(String mail){
        email = mail;
    }
}