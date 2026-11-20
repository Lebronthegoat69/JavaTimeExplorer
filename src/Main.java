
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n===== JAVA TIME EXPLORER =====");
            System.out.println("1. Show current date and time");
            System.out.println("2. Format a date");
            System.out.println("3. Parse a date from text");
            System.out.println("4. Calculate age or event difference");
            System.out.println("5. Countdown to a future date");
            System.out.println("6. Calculate time duration");
            System.out.println("7. Convert time zones");
            System.out.println("8. Show current timestamp");
            System.out.println("9. Exit");

            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    showCurrentDateAndTime();
                    break;

                case "2":
                    formatDate();
                    break;

                case "3":
                    parseDate();
                    break;

                case "4":
                    calculateAgeOrDifference();
                    break;

                case "5":
                    countdownToFutureDate();
                    break;

                case "6":
                    calculateTimeDuration();
                    break;

                case "7":
                    convertTimeZones();
                    break;

                case "8":
                    showCurrentTimestamp();
                    break;

                case "9":
                    running = false;
                    System.out.println("Thank you for using Java Time Explorer!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    public static void showCurrentDateAndTime() {

        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateTime = LocalDateTime.now();

        System.out.println("\nCurrent Date: " + today);
        System.out.println("Current Time: " + currentTime);
        System.out.println("Current Date and Time: " + currentDateTime);
    }

    public static void formatDate() {

        System.out.println("\n===== DATE FORMATTER =====");

        try {

            System.out.print("Enter a date (YYYY-MM-DD): ");
            String input = scanner.nextLine();

            LocalDate date = LocalDate.parse(input);

            DateTimeFormatter format1 =
                    DateTimeFormatter.ofPattern("MM/dd/yyyy");

            DateTimeFormatter format2 =
                    DateTimeFormatter.ofPattern("MMMM dd, yyyy");

            DateTimeFormatter format3 =
                    DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy");

            System.out.println("\nOriginal Date: " + date);
            System.out.println("Format 1: " + date.format(format1));
            System.out.println("Format 2: " + date.format(format2));
            System.out.println("Format 3: " + date.format(format3));

        } catch (Exception e) {

            System.out.println("Invalid date. Please use YYYY-MM-DD.");
        }
    }

    public static void parseDate() {

        System.out.println("\n===== PARSE A DATE =====");

        try {

            System.out.print("Enter a date (MM/dd/yyyy): ");
            String input = scanner.nextLine();

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("MM/dd/yyyy");

            LocalDate parsedDate = LocalDate.parse(input, formatter);

            System.out.println("\nOriginal Text: " + input);
            System.out.println("Parsed Date: " + parsedDate);
            System.out.println("Day of Week: " + parsedDate.getDayOfWeek());
            System.out.println("Month: " + parsedDate.getMonth());
            System.out.println("Year: " + parsedDate.getYear());

        } catch (Exception e) {

            System.out.println("Invalid date. Please use MM/dd/yyyy.");
        }
    }

    public static void calculateAgeOrDifference() {

        System.out.println("\n===== AGE OR EVENT DIFFERENCE =====");

        try {

            System.out.print("Enter the starting date (YYYY-MM-DD): ");
            String startInput = scanner.nextLine();

            System.out.print("Enter the ending date (YYYY-MM-DD): ");
            String endInput = scanner.nextLine();

            LocalDate startDate = LocalDate.parse(startInput);
            LocalDate endDate = LocalDate.parse(endInput);

            if (endDate.isBefore(startDate)) {

                System.out.println("The ending date must be after the starting date.");

            } else {

                Period difference = Period.between(startDate, endDate);

                long totalDays = ChronoUnit.DAYS.between(startDate, endDate);

                System.out.println("\nStarting Date: " + startDate);
                System.out.println("Ending Date: " + endDate);

                System.out.println("Years: " + difference.getYears());
                System.out.println("Months: " + difference.getMonths());
                System.out.println("Days: " + difference.getDays());

                System.out.println("Total Days: " + totalDays);
            }

        } catch (Exception e) {

            System.out.println("Invalid date. Please use YYYY-MM-DD.");
        }
    }

    public static void countdownToFutureDate() {

        System.out.println("\n===== COUNTDOWN TO A FUTURE DATE =====");

        try {

            System.out.print("Enter a future date (YYYY-MM-DD): ");
            String input = scanner.nextLine();

            LocalDate futureDate = LocalDate.parse(input);
            LocalDate today = LocalDate.now();

            if (futureDate.isBefore(today)) {

                System.out.println("That date is in the past.");

            } else if (futureDate.isEqual(today)) {

                System.out.println("That date is today!");

            } else {

                long daysRemaining = ChronoUnit.DAYS.between(today, futureDate);

                System.out.println("Days Remaining: " + daysRemaining);
            }

        } catch (Exception e) {

            System.out.println("Invalid date format. Use YYYY-MM-DD.");
        }
    }
    public static void calculateTimeDuration() {

        System.out.println("\n===== CALCULATE TIME DURATION =====");

        try {

            System.out.print("Enter starting date and time (YYYY-MM-DDTHH:MM): ");
            String startInput = scanner.nextLine();

            System.out.print("Enter ending date and time (YYYY-MM-DDTHH:MM): ");
            String endInput = scanner.nextLine();

            LocalDateTime start = LocalDateTime.parse(startInput);
            LocalDateTime end = LocalDateTime.parse(endInput);

            if (end.isBefore(start)) {

                System.out.println("The ending date must be after the starting date.");

            } else {

                Duration duration = Duration.between(start, end);

                long days = duration.toDays();
                long hours = duration.toHoursPart();
                long minutes = duration.toMinutesPart();

                System.out.println("\nStarting Date and Time: " + start);
                System.out.println("Ending Date and Time: " + end);

                System.out.println("Total Duration: " + days + " days, "
                        + hours + " hours, and " + minutes + " minutes.");

                System.out.println("Total Hours: " + duration.toHours());
                System.out.println("Total Minutes: " + duration.toMinutes());
            }

        } catch (Exception e) {

            System.out.println("Invalid input. Please use YYYY-MM-DDTHH:MM.");
        }
    }
    public static void convertTimeZones() {

        System.out.println("\n===== TIME ZONE CONVERTER =====");

        try {

            System.out.print("Enter date and time (YYYY-MM-DDTHH:MM): ");
            String input = scanner.nextLine();

            LocalDateTime dateTime = LocalDateTime.parse(input);

            System.out.println("\nAvailable time zones:");
            System.out.println("1. America/Chicago (Central)");
            System.out.println("2. America/New_York (Eastern)");
            System.out.println("3. America/Denver (Mountain)");
            System.out.println("4. America/Los_Angeles (Pacific)");
            System.out.println("5. Europe/London");
            System.out.println("6. Asia/Tokyo");

            System.out.print("Enter starting time zone: ");
            String fromZone = scanner.nextLine();

            System.out.print("Enter destination time zone: ");
            String toZone = scanner.nextLine();

            ZoneId sourceZone = ZoneId.of(fromZone);
            ZoneId destinationZone = ZoneId.of(toZone);

            ZonedDateTime sourceDateTime =
                    dateTime.atZone(sourceZone);

            ZonedDateTime convertedDateTime =
                    sourceDateTime.withZoneSameInstant(destinationZone);

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

            System.out.println("\nOriginal Time: "
                    + sourceDateTime.format(formatter));

            System.out.println("Converted Time: "
                    + convertedDateTime.format(formatter));

        } catch (Exception e) {

            System.out.println("Invalid date, time, or time zone.");
        }
    }
    public static void showCurrentTimestamp() {

        System.out.println("\n===== CURRENT TIMESTAMP =====");

        Instant currentInstant = Instant.now();

        long seconds = currentInstant.getEpochSecond();
        long milliseconds = currentInstant.toEpochMilli();

        System.out.println("Current Instant: " + currentInstant);
        System.out.println("Unix Timestamp (seconds): " + seconds);
        System.out.println("Unix Timestamp (milliseconds): " + milliseconds);
    }
}
