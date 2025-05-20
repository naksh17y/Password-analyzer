import java.util.Scanner;

public class PasswordAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        analyzePassword(password);
        scanner.close();
    }

    public static void analyzePassword(String password) {
        boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else hasSpecial = true;
        }

        System.out.println("\nPassword Strength Check:");

        if (password.length() < 8)
            System.out.println("❌ Too short (minimum 8 characters)");
        if (!hasUpper)
            System.out.println("❌ No uppercase letters");
        if (!hasLower)
            System.out.println("❌ No lowercase letters");
        if (!hasDigit)
            System.out.println("❌ No numbers");
        if (!hasSpecial)
            System.out.println("❌ No special characters");

        if (password.length() >= 8 && hasUpper && hasLower && hasDigit && hasSpecial)
            System.out.println("✅ Password is strong!");
        else {
            System.out.println("⚠️ Password is weak. Suggestions:");
            if (password.length() < 8) System.out.println("- Use at least 8 characters");
            if (!hasUpper) System.out.println("- Add uppercase letters");
            if (!hasLower) System.out.println("- Add lowercase letters");
            if (!hasDigit) System.out.println("- Add numbers");
            if (!hasSpecial) System.out.println("- Add special characters (!@#$%^&*)");
        }
    }
}
