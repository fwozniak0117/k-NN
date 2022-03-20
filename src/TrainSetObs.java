import java.util.ArrayList;
import java.util.Arrays;

public class TrainSetObs {
    public static int lp;
    private String name;
    private ArrayList<int[]> listOfParamets = new ArrayList<>();

    public TrainSetObs (String name, int ... x) {
        this.name = name;
        if (x != null) {
            listOfParamets.addAll(Arrays.asList(x));
        }
        lp++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<int[]> getListOfParamets() {
        return listOfParamets;
    }


    void printAllArgs () {
        for (int i = 0; i < listOfParamets.size() ; i++) {
            System.out.println(Arrays.toString(listOfParamets.get(i)));
        }
    }
}
