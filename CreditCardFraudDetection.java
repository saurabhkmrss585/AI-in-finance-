
import java.util.Scanner;

public class CreditCardFraudDetection {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the credit card number: ");
        String creditCardNumber = scanner.nextLine();

        if (isValidCreditCardNumber(creditCardNumber)) {
            System.out.println("Credit card number is valid.");
        } else {
            System.out.println("Credit card number is invalid.");
        }

        scanner.close();
    }

    public static boolean isValidCreditCardNumber(String creditCardNumber) {
        int sum = 0;
        boolean alternate = false;

        for (int i = creditCardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(creditCardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }

        return (sum % 10 == 0);
    }
}