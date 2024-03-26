public class RoomActivity extends Activity{
    private String roomType;
    private int numOfParticipant;

    public RoomActivity(){
        super();
        roomType = "";
        numOfParticipant = 0;
    }

    public RoomActivity(String an, char o, double b, String d, String rt, int nop){
        super(an, o, b, d);
        roomType = rt;
        numOfParticipant = nop;
    }

    public String getRoomType(){ return roomType; }
    public int getNumOfParticipant(){ return numOfParticipant; }

    public double roomCharges(){
        double total = 0;
        if (getOrganiser() == 'G'){
            total = 1500;
        }
        else if (getOrganiser() == 'P'){
            total = 25 * getNumOfParticipant();
        }
        else if (getOrganiser() == 'U'){
            total = 10 * getNumOfParticipant();
        }
        return total;
    }

    public String toString(){
        return super.toString() + "\nRoom Type: " + roomType + 
        "\nNumber of Participants: " + numOfParticipant;
    }
}
