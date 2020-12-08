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

        String key2 = getMatrixKey();
        KeywordMatrix keywordMatrix = new KeywordMatrix(key2, encodedPlainText);
        System.out.println(keywordMatrix);

        System.out.println("Encryped message");
        SortedKeywordMatrix sortedKeywordMatrix = new SortedKeywordMatrix(key2, keywordMatrix);
        System.out.println(sortedKeywordMatrix);
    }

    public static String getPolybiusSquareKey() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a keyword to create the Polybius Square: ");
        String key = scanner.nextLine();
        return key;
    }

    public static String getMatrixKey(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a keyword to create the keyword matrix: ");
        String key = scanner.nextLine();
        System.out.println();
        return key;
    }
}
