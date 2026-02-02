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

        // Display information for each policy
        int smokerCount = 0;
        int nonSmokerCount = 0;
        for (int i = 0; i < policies.size(); i++) {
            Policy policy = policies.get(i);
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Provider Name: " + policy.getProviderName());
            System.out.println("Policyholder's First Name: " + policy.getFirstName());
            System.out.println("Policyholder's Last Name: " + policy.getLastName());
            System.out.println("Policyholder's Age: " + policy.getAge());
            System.out.println("Policyholder's Smoking Status (smoker/non-smoker): " + policy.getSmokingStatus());
            System.out.println("Policyholder's Height: " + policy.getHeight() + " inches");
            System.out.println("Policyholder's Weight: " + policy.getWeight() + " pounds");
            System.out.printf("Policyholder's BMI: %.2f\n", policy.calculateBMI());
            System.out.printf("Policy Price: $%.2f\n", policy.calculatePrice());
            System.out.println();

            // Count smokers and non-smokers
            if (policy.getSmokingStatus().equalsIgnoreCase("smoker")) {
                smokerCount++;
            } else {
                nonSmokerCount++;
            }
        }

        // Display counts
        System.out.println("The number of policies with a smoker is: " + smokerCount);
        System.out.println("The number of policies with a non-smoker is: " + nonSmokerCount);
    }
}