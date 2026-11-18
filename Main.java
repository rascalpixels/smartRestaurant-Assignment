import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String customerName;
        int customerAge;
        double priceOfMeal;
        double priceOfDrink = 15.50;
        int numOfDrinksOrdered;
        boolean isAStudent = false;
        boolean isASenior = false;
        double tipAmount = 0;
        double totalBill;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Welcome to the Smart Restaurant System");
        System.out.print("Hello user, please enter a name of a customer : ");
        customerName = userInput.nextLine();
        System.out.print("Enter the customer's age : ");
        customerAge = userInput.nextInt();
        System.out.print("Enter the price for the meal he consumed : ");
        priceOfMeal = userInput.nextDouble();
        System.out.print("Enter how many drinks he consumed : ");
        numOfDrinksOrdered = userInput.nextInt();
        userInput.nextLine();

        //checking if a customer is a student
        while (true) {
            System.out.print("Is a customer a student (answer by yes or no): ");
            String isAStudenttemp = userInput.nextLine();
            if (isAStudenttemp.equalsIgnoreCase("yes")) {
                isAStudent = true;
                break;
            } else if (isAStudenttemp.equalsIgnoreCase("no")) {
                isAStudent = false;
                break;
            } else {
                System.out.println("Invalid answer....");
                continue;
            }
        }

        //  //checking if a customer is a senior
        while (true) {
            System.out.print("Is a customer a senior (answer by yes or no) : ");
            String isASeniortemp = userInput.nextLine();
            if (isASeniortemp.equalsIgnoreCase("yes")) {
                isASenior = true;
                break;
            } else if (isASeniortemp.equalsIgnoreCase("no")) {
                isASenior = false;
                break;
            } else {
                System.out.println("Invalid answer....");
                continue;
            }
        }

        double totalDrinkCost = numOfDrinksOrdered * priceOfDrink;
        totalBill = priceOfMeal + totalDrinkCost;

        if (isAStudent) {
            totalBill *= 0.90;
        } else {
            System.out.println("No student discount applied");
        }

        if (isASenior) {
            totalBill *= 0.95;
        } else {
            System.out.println("No senior discount applied");
        }

        // Asking for tip
        while (true) {
            System.out.print("Would you like to tip the servant (Answer by yes or no): ");
            String userTipConfirmation = userInput.nextLine();
            if (userTipConfirmation.equalsIgnoreCase("yes")) {
                System.out.print("How much would you like to tip : ");
                tipAmount = userInput.nextDouble();
                break;
            } else if (userTipConfirmation.equalsIgnoreCase("no")) {
                System.out.println("Thank you!");
                break;
            } else {
                System.out.println("Invalid answer");
                continue;
            }
        }

        // Add tip to final amount
        double customerfinalBill = totalBill + tipAmount;

        printReceipt(customerName, priceOfMeal, totalDrinkCost, tipAmount, customerfinalBill);
        userInput.close();
    }

    static void printReceipt(String customerName, double mealCost, double drinksCost, double tippedAmount, double finalBill) {
        System.out.println("\n--- Here's your receipt ---");
        System.out.printf("Customer Name : %s\nMeal Cost: %.2f\nDrinks Cost: %.2f\nTipped Amount: %.2f\nFinal Bill Amount Cost: %.2f\n",
                customerName, mealCost, drinksCost, tippedAmount, finalBill);
    }
}
