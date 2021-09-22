package SwingInterfaces;

import java.util.Arrays;

public class ListNames {
    private static final ListNames Instance = new ListNames();
    private final Object[] List = new Object[2];

    private ListNames(){ }

    public void addServerName(String Name){
        this.List[0] = Name;
    }

    public void addClientName(String Name){
        this.List[1] = Name;
    }

    public String getServerName(){
        return String.valueOf(this.List[0]);
    }

    public String getClientName(){
        return String.valueOf(this.List[1]);
    }

    public void show(){
        System.out.println(Arrays.toString(List));
    }

    public static ListNames getInstance(){
        return Instance;
    }

}