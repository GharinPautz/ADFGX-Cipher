public class EncodedPlainText {
    public static PlainText plainText;
    public static PolybiusSquare pbSquare;
    public static String cipherText;

    public EncodedPlainText(PolybiusSquare pbSquare, PlainText plainText) {
        this.plainText = plainText;
        this.pbSquare = pbSquare;
        this.cipherText = getCipherText();
    }

    public static String getCipherText() {
        String cipherText = "";
        String plainTextStr = plainText.toString().replaceAll("\\s+", "");
        for (char c: plainTextStr.toCharArray()) {
            // find position of c in pbSquare
            String position = findCharPosition(c);

            // convert position to ADFGX pair
            String ADFGXPosition = convertPositionPair(position);

            // append pair to cipherText string
            cipherText += ADFGXPosition;
        }
        return cipherText;
    }

    public static String findCharPosition(char c) {
        String returnStr = "";
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(pbSquare.square[i][j] == c){
                    returnStr = Integer.toString(i) + Integer.toString(j);
                    return  returnStr;
                }
            }
        }
        return returnStr;
    }
    /*
      A   D   F   G   X
    A 00  01  02  03  04
    D 10  11  12  13  14
    F 20  21  22  23  24
    G 30  31  32  33  34
    X 40  41  42  43  44
     */
    public static String convertPositionPair(String pair) {
        char firstLetterIndex = pair.charAt(0);
        char secondLetterIndex = pair.charAt(1);

        String returnStr = "";

        switch (firstLetterIndex){
            case '0':
                returnStr += 'A';
                break;
            case '1':
                returnStr += 'D';
                break;
            case '2':
                returnStr += 'F';
                break;
            case '3':
                returnStr += 'G';
                break;
            case '4':
                returnStr += 'X';
                break;
        }

        switch (secondLetterIndex){
            case '0':
                returnStr += 'A';
                break;
            case '1':
                returnStr += 'D';
                break;
            case '2':
                returnStr += 'F';
                break;
            case '3':
                returnStr += 'G';
                break;
            case '4':
                returnStr += 'X';
                break;
        }
        return  returnStr;
    }

    public String toString() {
        return cipherText;
    }
}
