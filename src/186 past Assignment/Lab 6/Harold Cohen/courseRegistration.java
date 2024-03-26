public class courseRegistration{
    private String studentID;
    private String studentName;
    private int studentAge;
    private char studentGender;
    private int studentType;

    public courseRegistration(){
        studentID = "";
        studentName = "";
        studentAge = 0;
        studentGender = '\u0000';
        studentType = 0;
    }

    public courseRegistration(String ID, String n, int a, char g, int t){
        studentID = ID;
        studentName = n;
        studentAge = a;
        studentGender = g;
        studentType = t;
    }

    public void setCourseRegistration(String ID, String n, int a, char g, int t){
        studentID = ID;
        studentName = n;
        studentAge = a;
        studentGender = g;
        studentType = t;
    }

    public String getStudentID(){ return studentID; }
    public String getStudentName(){ return studentName; }
    public int getStudentAge(){ return studentAge; }
    public char getStudentGender(){ return studentGender; }
    public int getStudentType(){ return studentType; }

    public String toString(){
        return "\nStudent ID: " + studentID + "\nStudent Name: " + studentName +
        "\nAge: " + studentAge + "\nGender: " + studentGender + "\nStudent Type: " + studentType;
    }
}