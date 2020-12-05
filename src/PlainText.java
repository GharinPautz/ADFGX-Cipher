import java.util.Scanner;

/**
 * This class contains the state and behavior of the plain text we will be encrypting.
 * The PlainText class has one field, which is a String containing the message we will
 * be encrypting.
 */
public class PlainText {
    public String message;

    /**
     * Constructor for PlainText. Makes all letters in message lower case.
     */
    public PlainText() {
        this.message = getUserString().toLowerCase();
    }

    /**
     * Method to read input from user
     *
     * @return A String containing the users input
     */
    public String getUserString() {
        try {
            String line = "";
            System.out.print("Enter a message to encode: ");

            Scanner in = new Scanner(System.in);
            line = in.nextLine();

            return line;
        }
        catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Strips spaces from a String
     *
     * @return A new String with the same letters as the old String, but without spaces
     */
    public String stripSpaces() {
        String str = message.replaceAll("\\s+", "");
        return str;
    }

    /**
     * Overriden toString method to print out PlainText object
     *
     * @return String representation of a PlainText object.
     */
    @Override
    public String toString() {
        return message;
    }
}
