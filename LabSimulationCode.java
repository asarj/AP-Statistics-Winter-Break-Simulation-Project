import java.util.*;

// Made by Ajay Sarjoo for the AP Statistics Winter Break Simulation Project
// Made with IntelliJ Idea

public class LabSimulationCode {

    public static void main(String[] args) {
        //variable declarations
        Scanner sc = new Scanner(System.in); // Declares scanner
        String trial = ""; // Declares an empty trial of digits
        int count = 0; // Declares the counter
        double percent = 0; // Declares the percentage
        int consecutive = 1; // Declares the consecutive counter
        String streakOfCatches = ""; // Declares the actual streak of catches as a string

        // Prompts for 28 trial in trial
        System.out.println("Please enter a trial of 28 digits");
        trial = sc.nextLine();

        // Checks for the occurrence of digits 1-3 in the trial
        for (int i = 0; i < trial.length(); i++) {
            if ((trial.substring(i, i + 1)).equals("1") || (trial.substring(i, i + 1)).equals("2") || (trial.substring(i, i + 1)).equals("3")) {
                count++;
            }
        }

        //checks for the occurrence of trial 1-3 in consecutive order
        for (int x = 0; x < trial.length(); x++) {
            if (((trial.substring(x, x + 1)).equals("1")) || ((trial.substring(x, x + 1)).equals("2")) || ((trial.substring(x, x + 1)).equals("3"))) {
                consecutive++;
                streakOfCatches += trial.substring(x, x + 1);
                if (streakOfCatches.length() == 7) {
                    break;
                }
            }
            else {
                consecutive = 0;
                streakOfCatches = "";
            }

        }
        //displays results
        percent = (((double) count / 28) * 100);
        System.out.println("Pass Litening threw " + count + "/28 completions in the game, or " + percent + "%");
        System.out.println("The number of consecutive completions Pass Litening had in this trial was " + consecutive);
        System.out.println("The trial of digits in consecutive order are " + streakOfCatches);
        if ((percent >= 75.0) && (streakOfCatches.length() == 7)) {
            System.out.println("Pass Litening threw 75%+ completion rate and threw 7 completions in a row in the same game");
        }
        else {
            System.out.println("Pass Litening is a one hit wonder, feat not accomplished");
        }
    }
}
