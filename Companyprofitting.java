import java.util.Scanner;
import java.util.ArrayList;

public class Companyprofitting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int worker;

        clearConsole();
        System.out.print("How many currently available workers? ");
        worker = scanner.nextInt();
        ArrayList<Long> taskProfit = new ArrayList<>();
        ArrayList<Integer> taskWorker = new ArrayList<>();
        int numTasks = -1;

        clearConsole();

        int choice;
        do {

            System.out.println("=========================================================");
            System.out.println("=                                                       =");
            System.out.println("=                    Company Profiting                  =");
            System.out.println("=                       0/1 Knapsack                    =");
            System.out.println("=                                                       =");
            System.out.println("=                  Worker Available: " + worker + "                 =");
            System.out.println("=                                                       =");
            System.out.println("=                        [1] Start                      =");
            System.out.println("=                                                       =");
            System.out.println("=                        [2] Calculate                  =");
            System.out.println("=                                                       =");
            System.out.println("=                        [3] Exit                       =");
            System.out.println("=                                                       =");
            System.out.println("=                        [4] Clear Terminal             =");
            System.out.println("=                                                       =");
            System.out.println("=========================================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    clearConsole();
                    System.out.println("        ========        ");
                    System.out.println("        = TASK =        ");
                    System.out.println("        ========        ");
                    System.out.print("Enter how many tasks: ");
                    numTasks = scanner.nextInt();
                    taskProfit.clear();
                    taskWorker.clear();

                    for (int i = 1; i <= numTasks; i++) {
                        clearConsole();
                        System.out.println("        ==========      ");
                        System.out.println("        = PROFIT =      ");
                        System.out.println("        ==========");
                        System.out.print("Enter profit for task " + i + ": ");
                        long profit = scanner.nextLong();
                        clearConsole();
                        System.out.println("        ===========     ");
                        System.out.println("        = WORKERS =     ");
                        System.out.println("        ===========");
                        System.out.print("Enter how many worker for task " + i + ": "); 
                        int workersNeeded = scanner.nextInt();


                        taskProfit.add(profit);
                        taskWorker.add(workersNeeded);
                    }
                    break;
                case 2:
                    clearConsole();
                if (taskProfit.isEmpty() || taskWorker.isEmpty()) {
                    System.out.println("======================================================================");
                    System.out.println("=                                                                    =");
                    System.out.println("= There are currently no data to calculate. Please input data first. =");
                    System.out.println("=                                                                    =");
                    System.out.println("======================================================================");
            } else {
                long[][] dp = new long[numTasks + 1][worker + 1]; 

                    for (int i = 1; i <= numTasks; i++) {
                        for (int w = 0; w <= worker; w++) {
                            if (taskWorker.get(i - 1) <= w) {
                                dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - taskWorker.get(i - 1)] + taskProfit.get(i - 1)); 
            } else {
                                dp[i][w] = dp[i - 1][w];
                }
            }
        }

                    long maxProfit = dp[numTasks][worker]; 
                    ArrayList<Integer> selectedTasks = new ArrayList<>();
                    int w = worker;
                    for (int i = numTasks; i > 0 && maxProfit > 0; i--) {
                        if (maxProfit != dp[i - 1][w]) {
                            selectedTasks.add(i);
                            maxProfit -= taskProfit.get(i - 1);
                            w -= taskWorker.get(i - 1);
            }
        }   
                            
                        System.out.println("        ======================== ");
                        System.out.println("        =     Calculation      = ");
                        System.out.println("        ======================== ");
                    System.out.println("Max Profit: " + dp[numTasks][worker]);
                    System.out.print("Worker used:  " + (worker - w) + "\nTasks used:  ");
                    for (int i = selectedTasks.size() - 1; i >= 0; i--) {
                        System.out.print("task " + selectedTasks.get(i));
                        if (i > 0) {
                            System.out.print(", ");
            }
        }
                    System.out.println();
    }
                break;
                case 3:
                    clearConsole();
                    System.out.println("=========================================================");
                    System.out.println("=                                                       =");
                    System.out.println("=            Thank you for using this program           =");
                    System.out.println("=                     Made by: Group 6                  =");
                    System.out.println("=                                                       =");
                    System.out.println("=          2602208750 - Wan Mohamad Axel Rinaldi        =");
                    System.out.println("=          2602196611 - Santana Mena                    =");
                    System.out.println("=          2602203674 - Liunadi Rizky Hidayat           =");
                    System.out.println("=          2602204582 - Diandra Priandita Sastro N      =");
                    System.out.println("=                                                       =");
                    System.out.println("=========================================================");
                    break;

                case 4:
                    clearConsole();
                    break;

                default:
                    clearConsole();
                    System.out.println("=================================================");
                    System.out.println("=                                               =");
                    System.out.println("= Invalid choice. Please select a valid option. =");
                    System.out.println("=                                               =");
                    System.out.println("=================================================");
            }   
        } while (choice != 3);

        scanner.close();
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
   
