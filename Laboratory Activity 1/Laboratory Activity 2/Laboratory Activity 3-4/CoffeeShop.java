public class CoffeeShop {
    public static void main(String[] args) {

        Customer c1 = new Customer("Joseph", 200);
        Customer c2 = new Customer("Peter", 0);
        Customer c3 = new Customer();

        c2.addPoints(200); 
        c2.addPoints(20);  

        c1.redeemReward();
        c2.redeemReward();
        c3.redeemReward();

        System.out.println("\n== Customer Information ==");
        c1.displayCustomerInfo();
        c2.displayCustomerInfo();
        c3.displayCustomerInfo();
        Customer.displayTotalCustomers();

        System.out.println();
        Customer c4 = new Customer("Diane", 0);
        c4.addPoints(50);

        System.out.println();
        c4.displayCustomerInfo();
        Customer.displayTotalCustomers();

        System.out.println();
        System.out.println("Joseph can redeem " + Customer.getAllowedRewardsRedemption(c1) + " reward(s).");
        System.out.println();
        System.out.println("Peter can redeem " + Customer.getAllowedRewardsRedemption(c2) + " reward(s).");
        System.out.println();
        System.out.println("Unknown can redeem " + Customer.getAllowedRewardsRedemption(c3) + " reward(s).");
        System.out.println();
        System.out.println("Diane can redeem " + Customer.getAllowedRewardsRedemption(c4) + " reward(s).");
    }
}
