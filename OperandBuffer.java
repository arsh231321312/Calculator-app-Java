package controller;

public class OperandBuffer {
    int base=10;
    String magnitude;
    boolean isNegative;
    String s;
    public OperandBuffer(int base,String magnitude, boolean isNegative){
        this.base=base;
        this.isNegative=isNegative;
        this.magnitude=magnitude;
    }

    public void setBase(int base){
        this.base=base;
    }
    public int getBase(){return base;}
    public void setMagnitude(){this.magnitude= "";}
    public void extend(int num){
        magnitude+=num;

    }
    public void negate(){
        long number = Long.parseLong(magnitude);
        this.isNegative=!isNegative;
        if(!isNegative){
            number= Math.abs(number) * -1;
        }else {
            number = Math.abs(number);
        }
        magnitude=Long.toString(number);
    }
    public long toLong(){
        long number = Long.parseLong(magnitude);

        if(base==10){
            s = Long.toString(number);

        }else{
            s = Long.toBinaryString(number);
        }
        number=Long.parseLong(s);
        return number;
    }

}
