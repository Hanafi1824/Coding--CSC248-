public class Painter extends Artist{
    private int numOfPainting;

    public Painter(){
        super();
        numOfPainting = 0;
    }

    public Painter(String ap, String an, double p, int n){// normal
        super(ap, an, p);
        numOfPainting = n;
    }

    public void setPainter(int n){
        numOfPainting = n;
    }

    public int getNumOfPainting(){ return numOfPainting; }

    //processor
    public double payArtist(){
        double totalPayment = 0;
        totalPayment = numOfPainting * payment;

        if (numOfPainting > 5)
            totalPayment *= 0.9;
        return totalPayment;
    }

    public String toString(){
        return super.toString() + "\nNumber of paintings painted by painter: " + numOfPainting
        + "\nTotal payment: RM " + payArtist();
    }
}
