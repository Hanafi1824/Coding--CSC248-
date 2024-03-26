public class Artist {
    protected String artistProfession;
    protected String artistName;
    protected double payment;

    public Artist(){
        artistProfession = "";
        artistName = "";
        payment = 0;
    }

    public Artist(String ap, String an, double p){
        artistProfession = ap;
        artistName = an;
        payment = p;
    }

    public void setArtist(String ap, String an, double p){
        artistProfession = ap;
        artistName = an;
        payment = p;
    }

    public String getArtistProfession(){ return artistProfession; }
    public String getArtistName(){return artistName;}
    public double getPayment(){ return payment; }

    public String toString(){
        return "\nArtist Profession: " + artistProfession + "\nArtist Name: "
        + artistName + "\nPayment: Rm " + payment;
    }
}
