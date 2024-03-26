public class Activity {
    private String activityName;
    private char organiser;
    private double budget;
    private String date;

    public Activity(){
        activityName = "";
        organiser = '\u0000';
        budget = 0;
        date = "";
    }

    public Activity(String an, char o, double b, String d){
        activityName = an;
        organiser = o;
        budget = b;
        date = d;
    }

    public String getActivityName(){ return activityName; }
    public char getOrganiser(){ return organiser; }
    public double getBudget(){ return budget; }
    public String getDate(){ return date; }

    public String toString(){
        return "\nActivity Name: " + activityName + "\nOrganiser: " + organiser +
        "\nBudget: RM " + budget + "\nDate: " + date;
    }
}