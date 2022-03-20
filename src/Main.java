import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Observation> obs = readAndCreateObs(true,"Test-set.txt");

            System.out.println(obs.get(6).getListOfParamets().get(2));



    }

    static ArrayList<Observation> readAndCreateObs(boolean isTest , String fileName) throws FileNotFoundException {
        ArrayList <Observation> observations = new ArrayList<>();
        File file = new File(fileName);
        Scanner sc = new Scanner(file);
        int numberOfArgs;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.split(",");
            numberOfArgs = words.length - 2;
            double [] args = new double[numberOfArgs];
            for (int i = 0; i < numberOfArgs ; i++) {
                args[i] = Double.parseDouble(words[i]);
            }
            Observation observation = new Observation(isTest, words[words.length -1],args);
            observations.add(observation);

        }
        return observations;
    }
}
