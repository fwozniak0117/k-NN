import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Observation> testSet = readAndCreateObs("Test-set.txt");
        ArrayList<Observation> trainSet = readAndCreateObs("Train-set.txt");






    }

    static ArrayList<Observation> readAndCreateObs(String fileName) throws FileNotFoundException {
        ArrayList <Observation> observations = new ArrayList<>();
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int numberOfArgs;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(",");
            numberOfArgs = words.length - 1;
            double [] args = new double[numberOfArgs];
            for (int i = 0; i < numberOfArgs ; i++) {
                args[i] = Double.parseDouble(words[i]);
            }
            Observation observation = new Observation(words[numberOfArgs],args);
            observations.add(observation);

        }
        return observations;
    }
    public static String classify (int k, Observation obs, ArrayList<Observation> trainSet){
        double [] parameters = new double[obs.getListOfParamets().size()];
        ArrayList <double> diffs = new ArrayList<double>();
        for (int i = 0; i < parameters.length ; i++)
            parameters[i] = obs.getListOfParamets().get(i);

        
    }
}
