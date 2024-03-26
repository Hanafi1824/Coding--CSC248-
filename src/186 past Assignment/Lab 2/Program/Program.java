public class Program {

    //Attributes
    private String code;
    private String progDes;
    private int duration;
    private String faculty;
    private String programHead;

    //Default Constructor
    public Program() {
        code = "";
        progDes = "";
        duration = 0;
        faculty = "";
        programHead = "";
    }

    //Normal Constructor
    public Program(String code, String progDes, int duration, String faculty, String programHead) {
        this.code = code;
        this.progDes = progDes;
        this.duration = duration;
        this.faculty = faculty;
        this.programHead = programHead;
    }

    //Copy Constructor
    public Program (Program pg) {
        code = pg.code;
        progDes = pg.progDes;
        duration = pg.duration;
        faculty = pg.faculty;
        programHead = pg.programHead;
    }

    //Mutator
    public void setCode (String cd) { code = cd; }
    public void setProgDes (String pd) { progDes = pd; }
    public void setDuration (int dr) { duration = dr; }
    public void setFaculty (String fct) { faculty = fct; }
    public void setProgramHead (String ph) { programHead = ph; }

    //Accessor
    public String getCode() {return code;}
    public String getProgDes() {return progDes;}
    public int getDuration() {return duration;}
    public String getFaculty() {return faculty;}
    public String getProgramHead() {return programHead;}

    //Processor
    public String detLevel () {
        if(code.charAt(2) == '0')
            return "Certificate";
        else if(code.charAt(2) == '1')
            return "Diploma";
        else if(code.charAt(2) == '2')
            return "Degree";
        else if(code.charAt(2) == '7')
            return "Master";
        else if(code.charAt(2) == '9')
            return "Doctorate";
        else
            return "Wrong input";
    }

    //Printer
    public String toString() {
        return "\nProgram Code " + code + "\nProgram Description: " + progDes + "\nDuration: " + duration + "\nFaculty: " + faculty + "\nProgram Head: " + programHead;
    }
}