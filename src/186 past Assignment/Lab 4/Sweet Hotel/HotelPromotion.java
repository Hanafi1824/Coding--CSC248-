public class HotelPromotion {
    private String bookingCode; 
    private String customerName;
    private String phoneNo;
    private char promotionType;
    private int day;
    private Room roomReserve;
    private double deposit;

    public HotelPromotion(String bC, String cN, String pN, char pT, int d, String block, String level, String no, double dp){
        bookingCode = bC;
        customerName = cN;
        phoneNo = pN;
        promotionType = pT;
        day = d;
        roomReserve = new Room(block, level, no);
        deposit = dp;
    }

    public void setHotelPromotion(String bC, String cN, String pN, char pT, int d, double dp){
        bookingCode = bC;
        customerName = cN;
        phoneNo = pN;
        promotionType = pT;
        day = d;
        deposit = dp;
    }

    public String getBookingCode(){ return bookingCode; }
    public String getCustomerName(){ return customerName; }
    public String getPhoneNo(){ return phoneNo; }
    public char getPromotionType(){ return promotionType; }
    public int getDay(){ return day; }
    public Room getRoomReserve(){ return roomReserve; }
    public double getDeposit(){ return deposit; }

    public double calculatePromotion(){
        double price = 0.0;
        double promotion = 0.0;
        if (promotionType == 'L'){
            price = 4000;
            promotion = price * 0.25 * getDay();
        }
        else if (promotionType == 'B'){
            price = 1500;
            promotion = price * 0.2 * getDay();
        }
        else if (promotionType == 'S'){
            price = 3300;
            promotion = price * 0.15 * getDay();
        }
        return promotion;
    }

    public boolean isSameBlock(HotelPromotion hotelPromotion){
        String block1 = getRoomReserve().getBlock();
        String block2 = hotelPromotion.getRoomReserve().getBlock();
        if (block1.equals(block2)){
            return true;
        }
        else 
            return false;
    }

    public String toString(){
        return "\nBooking code: " + bookingCode + "\nCustomer name: " + customerName + "\nNumber phone: "
        + phoneNo + "\nPromotion Type: " + promotionType + "\nDay: " + day
        + "\nRoom Reserve: " + roomReserve + "\nDeposit: RM " + deposit; 
    }
}
