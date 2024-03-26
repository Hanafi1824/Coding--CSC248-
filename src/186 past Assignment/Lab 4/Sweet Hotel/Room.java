public class Room {
    private String block;
    private String level;
    private String no;

    public Room(String b, String l, String n){
        block = b;
        level = l;
        no = n;
    }

    public void setRoom(String b, String l, String n){
        block = b;
        level = l;
        no = n;
    }

    public String getBlock(){ return block; }
    public String getLevel(){ return level; }
    public String getNo(){ return no; }
}
