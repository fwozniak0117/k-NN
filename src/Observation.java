import java.util.ArrayList;
import java.util.Arrays;

public class Observation extends ArrayList<Double> {
    public static int lp;
    private String name;

    private ArrayList <Double> listOfParamets = new ArrayList();

    public Observation(String name, double ... x) {
        this.name = name;

        for (int i = 0; i <x.length; i++) {
            listOfParamets.add(x[i]);
        }
        lp++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getListOfParamets() {
        return listOfParamets;
    }

    public String toString(){
        ArrayList <Double> toPrint = getListOfParamets();
        for (int i = 0; i < toPrint.size(); i++) {
            System.out.print(toPrint.get(i) + " ");

        }
        return "";
    }


    }

