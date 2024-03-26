public class JobCandidate {
    private int regNo;
    private String name; //candidate's name
    private char qualification; //D- Diploma, S- Degree, M- Master, P- PHD
    private int age;
    private char gender; //M- Male, F- Female

    public JobCandidate(int r, String n, char q, int a, char g){
        regNo = r;
        name = n;
        qualification = q;
        age = a;
        gender = g;
    }

    public void setJobCandidate(int r, String n, char q, int a, char g){
        regNo = r;
        name = n;
        qualification = q;
        age = a;
        gender = g;
    }

    public int getRegNo(){ return regNo; }
    public String getName(){ return name; }
    public char getQualification(){ return qualification; }
    public int getAge(){ return age; }
    public char getGender(){ return gender; }

    public String toString(){
        return "\nRegistration No: " + getRegNo() + "\n" +
                "Name: " + getName() + "\n" +
                "Qualification: " + getQualification() + "\n" +
                "Age: " + getAge() + "\n" +
                "Gender: " + getGender() + "\n";
    }

}
