public class Policy {
    private String policyNumber;
    private String providerName;
    private String firstName;
    private String lastName;
    private int age;
    private String smokingStatus;
    private double height;
    private double weight;

    /**
     * No-arg constructor that initializes all fields to default values.
     */
    public Policy() {
        this.policyNumber = "";
        this.providerName = "";
        this.firstName = "";
        this.lastName = "";
        this.age = 0;
        this.smokingStatus = "non-smoker";
        this.height = 0.0;
        this.weight = 0.0;
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
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.smokingStatus = smokingStatus;
        this.height = height;
        this.weight = weight;
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
     * Gets the policyholder's first name.
     * @return the policyholder's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the policyholder's last name.
     * @return the policyholder's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the policyholder's age.
     * @return the policyholder's age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the policyholder's smoking status.
     * @return the policyholder's smoking status
     */
    public String getSmokingStatus() {
        return smokingStatus;
    }

    /**
     * Gets the policyholder's height.
     * @return the policyholder's height in inches
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the policyholder's weight.
     * @return the policyholder's weight in pounds
     */
    public double getWeight() {
        return weight;
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
        this.firstName = firstName;
    }

    /**
     * Sets the policyholder's last name.
     * @param lastName the policyholder's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the policyholder's age.
     * @param age the policyholder's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Sets the policyholder's smoking status.
     * @param smokingStatus the policyholder's smoking status
     */
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }

    /**
     * Sets the policyholder's height.
     * @param height the policyholder's height in inches
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Sets the policyholder's weight.
     * @param weight the policyholder's weight in pounds
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Calculate BMI
    /**
     * Calculates and returns the BMI of the policyholder.
     * @return the BMI calculated as (weight * 703) / (height^2)
     */
    public double calculateBMI() {
        return (weight * 703) / (height * height);
    }

    // Calculate price
    /**
     * Calculates and returns the price of the insurance policy.
     * @return the total price including base fee and additional fees
     */
    public double calculatePrice() {
        double price = 600.0;
        if (age > 50) {
            price += 75.0;
        }
        if (smokingStatus.equalsIgnoreCase("smoker")) {
            price += 100.0;
        }
        double bmi = calculateBMI();
        if (bmi > 35) {
            price += (bmi - 35) * 20;
        }
        return price;
    }
}
