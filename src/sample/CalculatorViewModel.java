package sample;

public class CalculatorViewModel {
    private String savedValue;
    private String lastOperation;
    public CalculatorViewModel(){
        savedValue = "0";
        lastOperation = "";
    }
    public String getSavedValue(){
        return savedValue;
    }
    public void setSavedValue(String a ){
        savedValue = a;
    }
    public void calculation(String a, String operation){
        double b = 0.0;
        if (operation.equals("+")){
            savedValue = a;
            lastOperation = "+";
        }
        if (operation.equals("-")){
            savedValue = a;
            lastOperation = "-";
        }
        if (operation.equals("*")){
            savedValue = a;
            lastOperation = "*";
        }
        if (operation.equals("/")){
            savedValue = a;
            lastOperation = "/";
        }
        if (operation.equals("=")){
            if(lastOperation.equals("+"))
            {
                b = Double.parseDouble(savedValue) + Double.parseDouble(a);
                savedValue = Double.toString(b);
            }
            if(lastOperation.equals("-"))
            {
                b = Double.parseDouble(savedValue) - Double.parseDouble(a);
                savedValue = Double.toString(b);
            }
            if(lastOperation.equals("*"))
            {
                b = Double.parseDouble(savedValue) * Double.parseDouble(a);
                savedValue = Double.toString(b);
            }
            if(lastOperation.equals("/"))
            {
                b = Double.parseDouble(savedValue) / Double.parseDouble(a);
                savedValue = Double.toString(b);
            }
        }
    }




}
