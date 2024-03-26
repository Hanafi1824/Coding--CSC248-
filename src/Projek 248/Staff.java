public class Staff{
    private String staffID;
    private String staffName;
    private String contactNo;
    private char staffStatus;
    private char position;
    private String address;
    private int salary;

    //constructor
    public Staff(String ID, String sn, String cn, char ss, char p, String a, int s){
        staffID = ID;
        staffName = sn;
        contactNo = cn;
        staffStatus = ss;
        position = p;
        address = a;
        salary = s;
    }

    //setter
    public void setStaffName(String sn){ staffName = sn; }
    public void setContactNo(String cn){ contactNo = cn; }
    public void setStaffStatus(char ss){ staffStatus = ss; }
    public void setPosition(char p){ position = p; }
    public void setAddress(String a){ address = a; }
    public void setSalary(int s){ salary = s; }
    
    //getter
    public String getStaffID(){ return staffID; }
    public String getStaffName(){ return staffName; }
    public String getContactNo(){ return contactNo; }
    public char getStaffStatus(){ return staffStatus; }
    public char getPosition(){ return position; }
    public String getAddress(){ return address; }
    public int getSalary(){ return salary; }

    public String printStatus(){
        String print = "";
        if (getStaffStatus() == staffStatus){
            if (staffStatus == 'S')
                print = "Single";
            else if (staffStatus == 'M')
                print = "Married";
            else if (staffStatus == 'D')
                print = "Divorced";
        }
        return print;
    }

    public String printPosition(){
        String print = "";
        if (getPosition() == position){
            if (position == 'A')
                print = "Assistant";
            else if (position == 'B')
                print = "Barista";
            else if (position == 'C')
                print = "Cashier";
            else if (position == 'H')
                print = "Chef";
            else if (position == 'L')
                print = "Cleaner";
            else if (position == 'M')
                print = "Manager";
            else if (position == 'W')
                print = "Waiter";
        }
        return print;
    }

    public String toString(){
        return staffID + ";" + staffName + ";" + contactNo + ";" + printStatus() + ";" 
        + printPosition() + ";" + address + ";" + salary;
    }
}