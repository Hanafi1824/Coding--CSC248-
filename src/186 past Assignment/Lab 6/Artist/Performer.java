public class Performer extends Artist{
    private int workingHours;
    private String genre;

    public Performer(){
        super();
        workingHours = 0;
        genre = "";
    }

    public Performer(String ap, String an, double p, int w, String g){//normal
        super(ap, an, p);
        workingHours = w;
        genre = g;
    }

    public void setPerformer(int w, String g){
        workingHours = w;
        genre = g;
    }

    public int getWorkingHours(){ return workingHours; }
    public String getGenre(){return genre;}

    //processor
    public double payArtist(){
        double totalPayment = 0;
        int totalWorkingHour = workingHours;
        totalPayment = totalWorkingHour * payment;

        if (totalWorkingHour > 24)
            totalPayment += 500.0;//extra allowance
        return totalPayment;
    } 

    public String toString(){
        return super.toString() + "\nWorking Hours: " + workingHours + "\nGenre: " + genre
        + "\nTotal payment: RM " + payArtist();
    }
}
