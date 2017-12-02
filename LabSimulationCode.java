import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Made by Ajay Sarjoo for the AP Statistics Winter Break Simulation Project
// Made with IntelliJ Idea

public class LabSimulationCode {

    public static void main(String[] args) {
        //variable declarations
        try {
            File digitTable = new File("sampledata.txt");
            Scanner sc = new Scanner(digitTable); // Declares scanner
            int numTrials = 0;
            int percentageCount = 0; // Declares the counter
            int digitCounter = 1;
            int masterCount = 0;
            int streaksCounter = 0;
            int consecutive = 0; // Declares the consecutive counter
            double masterAverage = 0;
            double percent = 0; // Declares the percentage
            String streakOfCatches = ""; // Declares the actual streak of catches as a string

            System.out.println("TRIAL\tDIGITS IN TRIAL\t\t\t\t\t\tMAKE\tTOTAL\tPCT%\tSTREAK\tSTREAK DIGITS\tCONCLUSION");

            while (sc.hasNextLine() && (numTrials < 101)) {
                String trial = ""; // Declares an empty trial of digits
                String trialConclusion = "";

                if (!sc.hasNext()) {
                    sc.close();
                    try {
                        sc = new Scanner(digitTable);
                    } catch (FileNotFoundException f) {
                        System.out.println("File not found");
                    }
                }
                /** This code below is needed if data is not organized **/
//                    while(digitCounter < 28){
//                        int retrievedData = sc.nextInt();
//                        if (retrievedData < 10){
//                            trial += Integer.toString(retrievedData);
//                            digitCounter++;
//                        }
//                        else{
//                            String manipulation = Integer.toString(retrievedData);
//                            for(int i = 0; i < manipulation.length(); i++){
//                                trial += manipulation.substring(i, i + 1);
//                                digitCounter++;
//                            }
//                        }
//                    }
                /** This code above is needed if data is not organized **/
                trial = sc.nextLine();
                // Checks for the occurrence of digits 1-3 in the trial
                for (int i = 0; i < trial.length(); i++) {
                    if ((trial.substring(i, i + 1)).equals("1") ||
                            (trial.substring(i, i + 1)).equals("2") ||
                            (trial.substring(i, i + 1)).equals("3")) {
                        percentageCount++;
                    }
                }

                //checks for the occurrence of trial 1-3 in consecutive order
                for (int x = 0; x < trial.length(); x++) {
                    if (((trial.substring(x, x + 1)).equals("1")) ||
                            ((trial.substring(x, x + 1)).equals("2")) ||
                            ((trial.substring(x, x + 1)).equals("3"))) {
                        consecutive++;
                        streakOfCatches += trial.substring(x, x + 1);

                        if (streakOfCatches.length() == 7) {
                            break;
                        }

                    } else {
                        consecutive = 0;
                        streakOfCatches = "";
                    }

                }
                if (streakOfCatches.length() < 7) {
                    streakOfCatches = "";
                }
                //displays results
                percent = (((double) percentageCount / 28.0) * 100);
                if (percent < 75.0 || streakOfCatches.length() != 7) {
                    trial = "";
                    percentageCount = 0;
                    percent = 0;
                    consecutive = 0;
                    trialConclusion += "Feat not accomplished";
                }
                else {
                    masterCount += percentageCount;
                    numTrials++;
                    trialConclusion += "Feat Accomplished";
                    streaksCounter++;
                    System.out.println(numTrials + "\t\t" + trial + "\t\t" + percentageCount + "\t\t28\t\t" + Math.round(percent) + "\t\t" + ((consecutive == 7) ? "true" : "false") + "\t" + streakOfCatches + "\t\t\t" + trialConclusion);
                    trial = "";
                    percentageCount = 0;
                    consecutive = 0;
                }

            }
            masterAverage = masterCount / 28;
            System.out.println("\nPass Litening averaged " + Math.round(masterCount/100.0) + "/28 completions per game, or (" + masterAverage + "%)");
            System.out.println("The number of games in which Litening had 7 or more completions in a game is " + numTrials);
        }
        catch(FileNotFoundException f){
            System.out.println("File not found");
        }
    }
}
