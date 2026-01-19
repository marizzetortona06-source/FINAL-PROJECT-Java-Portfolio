public class Customer {
    String name;
    int points;
    static int totalCustomers = 0;

    public Customer() {
        this.name = "Unknown";
        this.points = 0;
        totalCustomers++;
    }

    public Customer(String name, int points) {
        this.name = name;
        this.points = points;
        totalCustomers++;
    }

    public void addPoints(int earnedPoints) {
        this.points += earnedPoints;
        System.out.println(this.name + " earned " + earnedPoints + " points. Total points: " + this.points);
    }

    public void redeemReward() {
        if (this.points >= 100) {
            this.points -= 100;
            System.out.println("\nCongratulations " + this.name + "! You can redeemed a free drink!");
            System.out.println("Remaining points: " + this.points);
        } else {
            System.out.println("\n" + this.name + " Sorry does not have enough points to redeem a drink");
        }
    }

    public void displayCustomerInfo() {
        System.out.println("Customer: " + this.name);
        System.out.println("Points: " + this.points);
        System.out.println("-------------------");
    }

    public static void displayTotalCustomers() {
        System.out.println("Total Registered Customer: " + totalCustomers);
        System.out.println("-------------------");
    }

    public static int getAllowedRewardsRedemption(Customer customer) {
        return customer.points / 100;
    }
}
