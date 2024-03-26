public class ResidentialSuites extends House{
    private String residentialSuiteType;

    public ResidentialSuites(){
        super();
        residentialSuiteType = "";
    }

    public ResidentialSuites(String b, long ic, String g, boolean bp, String r){
        super(b, ic, g, bp);
        residentialSuiteType = r;
    }

    public void setResidentialSuites(String r){ residentialSuiteType = r; }

    public String getResdentialSuites(){ return residentialSuiteType; }

    public String toString(){
        return super.toString() + "\nResident Suite Type: " + residentialSuiteType;
    }
}
