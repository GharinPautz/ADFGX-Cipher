import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlainText message = new PlainText();

        System.out.print("Plain text: ");
        System.out.println(message);
        System.out.println();

        String key1 = getPolybiusSquareKey();
        PolybiusSquare pbSquare = new PolybiusSquare(key1);

        System.out.println("Polybius Square");
        System.out.println(pbSquare);

        EncodePlainText encode = new EncodePlainText(pbSquare, message);
        System.out.println(encode);
    }

    public static String getPolybiusSquareKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a keyword to create the Polybius Square: ");
        String key = scanner.nextLine();
        return key;
    }
}
