import java.util.Scanner;
import java.util.InputMismatchException;

public class a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seats = getInput(scanner, "Please input number (seat): ");
        int mediumSeats = getInput(scanner, "Please input Medium car seating capacity: ");
        int mediumCost = getInput(scanner, "Please input Medium car cost: ");
        int largeSeats = getInput(scanner, "Please input Large car seating capacity: ");
        int largeCost = getInput(scanner, "Please input Large car cost: ");

        
        calculateOptimizedCost(seats, mediumSeats, largeSeats, mediumCost, largeCost);
    }

    private static int getInput(Scanner scanner, String prompt) {
        int input = -1;
        while (true) {
            try {
                System.out.print(prompt);
                input = scanner.nextInt();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }
        return input;
    }

    private static void calculateOptimizedCost(int seats, int mediumSeats, int largeSeats, int mediumCost, int largeCost) {
        int minCost = Integer.MAX_VALUE;
        String result = "";

      
        for (int l = 0; l <= seats / largeSeats; l++) {
            for (int m = 0; m <= seats / mediumSeats; m++) {
                int totalSeats = l * largeSeats + m * mediumSeats;

                
                if (totalSeats >= seats) {
                    int cost = l * largeCost + m * mediumCost;

                    
                    if (cost < minCost) {
                        minCost = cost;
                        result = (m > 0 ? "M x " + m + "\n" : "") + (l > 0 ? "L x " + l + "\n" : "");
                    }
                }
            }
        }

        System.out.println(result + "Total = PHP " + minCost);
    }
}
