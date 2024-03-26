public class Rectangle{
    private int length = 1;
    private int width = 1;
    
    //Accessor
    int getLength(){
        return length;
    }
    
    //Mutator
    void setLength(int value){
        length = value;
    }
    
    //processor
    int findArea(){
        int area = length * width;
        return area;
    }
}