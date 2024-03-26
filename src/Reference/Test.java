import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        String workerNumber;
        int outstationDay;
        char jobCategory;
        double distanceTravelled, claim;
        char prompt = 'Y';
        int numOfEmployee = 0;
        float totalClaim = 0;


        while(prompt != 'N') {
            numOfEmployee++;

            System.out.print("Enter your name: ");
            name = input.nextLine();

            System.out.print("Enter your worker number: ");
            workerNumber = input.nextLine();

            System.out.print("**LODGING PER DAY**\nA. RM200.00\nB. RM120.00\nC. RM85.00\n\nEnter your job category: ");
            jobCategory = input.next().charAt(0);

            System.out.print("Enter the number of outstation days: ");
            outstationDay = input.nextInt();

            System.out.print("Enter the distance travelled (KM): ");
            distanceTravelled = input.nextFloat();

            switch (jobCategory) {
                case 'A':
                    claim = (200 * outstationDay) + 60.00;
                    break;
                case 'B':
                    claim = (120 * outstationDay) + 40.00;
                    break;
                case 'C':
                    claim = (85 * outstationDay) + 25.00;
                    break;
                default:
                    claim = 0;
                    System.out.println("Invalid job category!");
                    break;
            }

            if (distanceTravelled <= 500) {
                claim += 0.55 * distanceTravelled;
            } else if (distanceTravelled > 500 && distanceTravelled <= 1000) {
                claim += 0.45 * distanceTravelled;
            } else if (distanceTravelled > 1000) {
                claim += 0.35 * distanceTravelled;
            }

            System.out.println("\nName: " + name);
            System.out.println("Worker number: " + workerNumber);
            System.out.printf("Claim: RM%.2f", claim);
            
            totalClaim += claim;

            System.out.print("\n\nDo you want to continue? (Y/N): ");
            prompt = input.next().charAt(0);
            prompt = Character.toUpperCase(prompt);
//            flush the buffer
            input.nextLine();
        }

        System.out.println("Number of employee: " + numOfEmployee);
        System.out.printf("\nTotal claim: RM%.2f", totalClaim);

        input.close();
    }

}