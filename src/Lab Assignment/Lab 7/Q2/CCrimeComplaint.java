public class CCrimeComplaint {
    private String cElement;
    private int noOfComplaint;
    private int year;

    public CCrimeComplaint(String c, int y, int n) {
        cElement = c;
        year = y;
        noOfComplaint = n;
    }

    public void setCElement(String c) { cElement = c; }
    public void setNoOfComplaint(int n) { noOfComplaint = n; }
    public void setYear(int y) { year = y; }
    public String getCElement() { return cElement; }
    public int getNoOfComplaint() { return noOfComplaint; }
    public int getYear() { return year; }

    public String toString(){ 
        return "Complaint Elements: " + cElement + "Year: " + year + "Total Complaints " + noOfComplaint; 
    }

}
