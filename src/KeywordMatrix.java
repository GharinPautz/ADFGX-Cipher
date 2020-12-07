public class KeywordMatrix {
    public String key;
    public String encodedPlainText;
    public char [][] matrix;

    public KeywordMatrix(String key, EncodedPlainText encodedPlainText) {
        this.key = key;
        this.encodedPlainText = encodedPlainText.toString();
        this.matrix = generateMatrix();
    }

    public char[][] generateMatrix() {
        int numCols = key.length();
        int numRows = (int) Math.ceil((encodedPlainText.length() * 2)/ numCols);
        matrix = new char[numRows][numCols];

        int plainTextIndex = 0;

        // row
        for (int i = 0; i < numRows; i++) {
            // column
            for (int j = 0; j < numCols; j++) {
                if (plainTextIndex < encodedPlainText.length()) {
                    matrix[i][j] = encodedPlainText.charAt(plainTextIndex);
                    plainTextIndex++;
                } else {
                    return matrix;
                }
            }
        }
        return matrix;
    }

    public String toString() {
        String matrixStr = "";
        int numCols = key.length();
        int numRows = (int) Math.ceil((encodedPlainText.length() * 2)/ numCols);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrixStr += matrix[i][j];
                matrixStr += " ";
            }
            matrixStr += "\n";
        }

        return matrixStr;
    }
}
