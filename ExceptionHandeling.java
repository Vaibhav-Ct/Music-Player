import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ExceptionHandeling {
    // Function to validate and return a date in the correct format
    public static String getValidDate(Scanner ip) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date;

        while (true) {
            try {
                System.out.println("Enter Song Date (YYYY-MM-DD): ");
                date = ip.nextLine();
                LocalDate.parse(date, formatter);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format! Please enter a valid date in the format YYYY-MM-DD.");
            }
        }

        return date;
    }

}
