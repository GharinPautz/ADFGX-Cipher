public class KeywordMatrix {
    public String key;
    public String encodedPlainText;
    public char [][] matrix;

    public KeywordMatrix(String key, EncodedPlainText encodedPlainText) {
        this.key = key;
        this.encodedPlainText = encodedPlainText.cipherText;
        this.matrix = generateMatrix();
    }

    public char[][] generateMatrix() {
        int numCols = key.length();
        int numRows = (int) Math.ceil((double)encodedPlainText.length() / numCols);

        char[][] charMatrix = new char[numRows][numCols];


        int plainTextIndex = 0;

        // row
        for (int i = 0; i < numRows; i++) {
            // column
            for (int j = 0; j < numCols; j++) {
                if (plainTextIndex < encodedPlainText.length()) {
                    charMatrix[i][j] = encodedPlainText.charAt(plainTextIndex);
                    plainTextIndex++;
                }
                else {
                    charMatrix[i][j] = '0';
                }
            }
        }
        return charMatrix;
    }

    public String toString() {
        String matrixStr = "";

        String keyStr = "";

        for (char c: key.toCharArray()) {
            keyStr += c;
            keyStr += " ";
        }
        keyStr += "\n";
        for (char c: key.toCharArray()) {
            keyStr += "__";
        }
        keyStr += "\n";

        int numCols = key.length();
        int numRows = (int) Math.ceil((double)encodedPlainText.length() / numCols);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (matrix[i][j] != '0') {
                    matrixStr += matrix[i][j];
                    matrixStr += " ";
                }
            }
            matrixStr += "\n";
        }

        return keyStr + matrixStr;
    }
}
