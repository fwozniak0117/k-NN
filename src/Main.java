import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static double counterOfSucc;

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Observation> testSet = readAndCreateObs(args[1]);
        ArrayList<Observation> trainSet = readAndCreateObs(args[2]);


        for (int i = 0; i <testSet.size() ; i++) {
            classify(Integer.parseInt(args[0]), testSet.get(i),trainSet);
        }

        System.out.println("Accuracy: " + counterOfSucc/testSet.size());


            while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter paramteres with /n separator");
            double[] parameters = new double[testSet.get(0).getNumOfParameters()];
            for (int i = 0; i < testSet.get(0).getNumOfParameters(); i++) {
                parameters[i] = input.nextDouble();
            }
            Observation obs = new Observation("Input", parameters);
            System.out.println("Enter k");
            int k = input.nextInt();
            classify(k, obs, trainSet);
        }



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
    public static void classify (int k, Observation obs, ArrayList<Observation> trainSet){
        double [] parameters = new double[obs.getListOfParamets().size()];
        Map <Double,String> diffMap = new TreeMap<>();
        for (int i = 0; i < parameters.length ; i++)
            parameters[i] = obs.getListOfParamets().get(i);


            for (int i = 0; i <trainSet.size() ; i++) {
                    double diff = 0;
                for (int j = 0; j <parameters.length ; j++) {
                    diff += Math.pow(parameters[j] - trainSet.get(i).getXParameter(j), 2);
                   if(j == parameters.length-1){
                       diff += Math.pow(parameters[j] - trainSet.get(i).getXParameter(j), 2);
                       diff = Math.sqrt(diff);
                   }


                }
                diffMap.put(diff,trainSet.get(i).getName());
            }
            ArrayList <Double> mapKeys = new ArrayList<>(diffMap.keySet());

        for (int i = 0; i < mapKeys.size(); i++) {
            if (i > k-1)
                diffMap.remove(mapKeys.get(i));
        }
            int setosaCounter = 0;
            int versicolorCounter = 0;
            int virginicaCounter = 0;
            int max;

                for (Map.Entry<Double,String> entry : diffMap.entrySet()) {
                    if (entry.getValue().equals("Iris-setosa"))
                        setosaCounter++;
                    if (entry.getValue().equals("Iris-versicolor"))
                        versicolorCounter++;
                    if (entry.getValue().equals("Iris-virginica"))
                        virginicaCounter++;
                }
                        max = getMaxOfThree(setosaCounter,versicolorCounter,virginicaCounter);
                    String finalClass = "";
                if(max == setosaCounter) {
                    System.out.println(obs.getName() + " assigned to Iris-setosa");
                    finalClass = "Iris-setosa";
                }
                else if(max == versicolorCounter) {
                    System.out.println(obs.getName() + " assigned to Iris-versicolor");
                    finalClass = "Iris-versicolor";
                }
                else if(max == virginicaCounter) {
                    System.out.println(obs.getName() + " assigned to Iris-virginica");
                    finalClass = "Iris-virginica";
                }

                if(finalClass.equals(obs.getName()))
                    counterOfSucc++;



    }

    public static int getMaxOfThree (int n1, int n2, int n3){
        int max;
        if (n1 >= n2 && n1 >= n3)
            max = n1;
        else if (n2 >= n1 && n2 >= n3)
            max = n2;
        else
            max = n3;

        return max;
    }


    }



