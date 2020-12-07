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

        EncodedPlainText encodedPlainText = new EncodedPlainText(pbSquare, message);
        System.out.println(encodedPlainText);

        String key2 = getMatrixKey();
        KeywordMatrix keywordMatrix = new KeywordMatrix(key2, encodedPlainText);
        System.out.println(keywordMatrix);
    }

    public static String getPolybiusSquareKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a keyword to create the Polybius Square: ");
        String key = scanner.nextLine();
        return key;
    }

    public static String getMatrixKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a keyword to create the keyword matrix: ");
        String key = scanner.nextLine();
        return key;
    }
}
