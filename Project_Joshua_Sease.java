import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class Project_Joshua_Sease {
    public static void main(String[] args) {
        ArrayList<Policy> policies = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("PolicyInformation.txt"));

            while (scanner.hasNextLine()) {
                String policyNumber = scanner.nextLine().trim();
                if (policyNumber.isEmpty()) continue;

                String providerName = scanner.nextLine().trim();
                String firstName = scanner.nextLine().trim();
                String lastName = scanner.nextLine().trim();
                int age = Integer.parseInt(scanner.nextLine().trim());
                String smokingStatus = scanner.nextLine().trim();
                double height = Double.parseDouble(scanner.nextLine().trim());
                double weight = Double.parseDouble(scanner.nextLine().trim());

                Policy policy = new Policy(policyNumber, providerName, firstName, lastName, age, smokingStatus, height, weight);
                policies.add(policy);

                // Skip blank line if present
                if (scanner.hasNextLine()) {
                    scanner.nextLine();
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Display information for each policy using implicit toString
        int smokerCount = 0;
        int nonSmokerCount = 0;
        for (Policy policy : policies) {
            System.out.println(policy);
            System.out.println();

            // Count smokers and non-smokers
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        // Display counts
        System.out.println("There were " + Policy.getPolicyCount() + " Policy objects created.");
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}