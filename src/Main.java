public class Main {
    public static void main(String[] args) {
        PlainText message = new PlainText();

        System.out.print("Plain text: ");
        System.out.println(message);
        System.out.println();

        PolybiusSquare pbSquare = new PolybiusSquare(message);

        System.out.println("Polybius Square");
        System.out.println(pbSquare);
    }
}
