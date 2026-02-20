/**
 * The Policy class represents an insurance policy for one person.
 */
public class Policy {
    private String policyNumber;
    private String providerName;
    private PolicyHolder policyHolder;
    private static int policyCount = 0;

    /**
     * No-arg constructor that initializes all fields to default values.
     */
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.policyHolder = new PolicyHolder();
        policyCount++;
    }

    /**
     * Constructor that accepts arguments to fully initialize the Policy object.
     * @param policyNumber the policy number
     * @param providerName the provider name
     * @param firstName the policyholder's first name
     * @param lastName the policyholder's last name
     * @param age the policyholder's age
     * @param smokingStatus the policyholder's smoking status ("smoker" or "non-smoker")
     * @param height the policyholder's height in inches
     * @param weight the policyholder's weight in pounds
     */
    public Policy(String policyNumber, String providerName, String firstName, String lastName, int age, String smokingStatus, double height, double weight) {
        this.policyNumber = policyNumber;
        this.providerName = providerName;
        this.policyHolder = new PolicyHolder(firstName, lastName, age, smokingStatus, height, weight);
        policyCount++;
    }

    // Getters
    /**
     * Gets the policy number.
     * @return the policy number
     */
    public String getPolicyNumber() {
        return policyNumber;
    }

    /**
     * Gets the provider name.
     * @return the provider name
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * Gets the policyholder.
     * @return a copy of the policyholder
     */
    public PolicyHolder getPolicyHolder() {
        // Return defensive copy to minimize security risks
        return new PolicyHolder(policyHolder.getFirstName(), policyHolder.getLastName(), 
                                policyHolder.getAge(), policyHolder.getSmokingStatus(), 
                                policyHolder.getHeight(), policyHolder.getWeight());
    }

    /**
     * Gets the policyholder's first name.
     * @return the policyholder's first name
     */
    public String getFirstName() {
        return policyHolder.getFirstName();
    }

    /**
     * Gets the policyholder's last name.
     * @return the policyholder's last name
     */
    public String getLastName() {
        return policyHolder.getLastName();
    }

    /**
     * Gets the policyholder's age.
     * @return the policyholder's age
     */
    public int getAge() {
        return policyHolder.getAge();
    }

    /**
     * Gets the policyholder's smoking status.
     * @return the policyholder's smoking status
     */
    public String getSmokingStatus() {
        return policyHolder.getSmokingStatus();
    }

    /**
     * Gets the policyholder's height.
     * @return the policyholder's height in inches
     */
    public double getHeight() {
        return policyHolder.getHeight();
    }

    /**
     * Gets the policyholder's weight.
     * @return the policyholder's weight in pounds
     */
    public double getWeight() {
        return policyHolder.getWeight();
    }

    // Setters
    /**
     * Sets the policy number.
     * @param policyNumber the policy number
     */
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    /**
     * Sets the provider name.
     * @param providerName the provider name
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    /**
     * Sets the policyholder's first name.
     * @param firstName the policyholder's first name
     */
    public void setFirstName(String firstName) {
        policyHolder.setFirstName(firstName);
    }

    /**
     * Sets the policyholder's last name.
     * @param lastName the policyholder's last name
     */
    public void setLastName(String lastName) {
        policyHolder.setLastName(lastName);
    }

    /**
     * Sets the policyholder's age.
     * @param age the policyholder's age
     */
    public void setAge(int age) {
        policyHolder.setAge(age);
    }

    /**
     * Sets the policyholder's smoking status.
     * @param smokingStatus the policyholder's smoking status
     */
    public void setSmokingStatus(String smokingStatus) {
        policyHolder.setSmokingStatus(smokingStatus);
    }

    /**
     * Sets the policyholder's height.
     * @param height the policyholder's height in inches
     */
    public void setHeight(double height) {
        policyHolder.setHeight(height);
    }

    /**
     * Sets the policyholder's weight.
     * @param weight the policyholder's weight in pounds
     */
    public void setWeight(double weight) {
        policyHolder.setWeight(weight);
    }

    // Calculate BMI
    /**
     * Calculates and returns the BMI of the policyholder.
     * @return the BMI calculated as (weight * 703) / (height^2)
     */
    public double calculateBMI() {
        return policyHolder.calculateBMI();
    }

    // Calculate price
    /**
     * Calculates and returns the price of the insurance policy.
     * @return the total price including base fee and additional fees
     */
    public double calculatePrice() {
        double price = 600.0;
        if (policyHolder.getAge() > 50) {
            price += 75.0;
        }
        if (policyHolder.getSmokingStatus().equalsIgnoreCase("smoker")) {
            price += 100.0;
        }
        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }
        return price;
    }

    /**
     * Gets the total number of Policy objects created.
     * @return the number of Policy objects
     */
    public static int getPolicyCount() {
        return policyCount;
    }

    /**
     * Returns a string representation of the Policy.
     * @return a string containing all policy information
     */
    @Override
    public String toString() {
        return "Policy Number: " + policyNumber + "\n" +
               "Provider Name: " + providerName + "\n" +
               policyHolder.toString() + "\n" +
               String.format("Policy Price: $%.2f", calculatePrice());
    }
}
