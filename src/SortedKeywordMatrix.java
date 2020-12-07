import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class SortedKeywordMatrix {
    public String key;
    public KeywordMatrix keywordMatrix;
    public char[][] sortedKeywordMatrix;

    public SortedKeywordMatrix(String key, KeywordMatrix keywordMatrix){
        this.key = key;
        this.keywordMatrix = keywordMatrix;
        this.sortedKeywordMatrix = sortKeywordMatrix();
    }

    public char[][] sortKeywordMatrix() {
        int numCols = key.length();
        int numRows = (int) Math.ceil((keywordMatrix.encodedPlainText.length() * 2)/ numCols);
        sortedKeywordMatrix = new char[numRows][numCols];

        // sort key
        char [] tempArray = key.toCharArray();
        Arrays.sort(tempArray);
        System.out.println(tempArray);

        // create arraylist of each column array
        // [[col 1],[col2],[col3]...]
        ArrayList<ArrayList<Character>> colsMatrix = new ArrayList<>(numCols);
        // row
        for (int i = 0; i < numCols; i++) {
            ArrayList<Character> colArray = new ArrayList<>();
            // column
            for (int j = 0; j < numRows; j++) {
                colArray.add(keywordMatrix.matrix[j][i]);
            }
            colsMatrix.add(colArray);
        }
        System.out.println(colsMatrix);

        // rearrange columns according to sorted key (tempArray)

        return sortedKeywordMatrix;
    }

    public String toString() {
        String matrixStr = "";
        int numCols = key.length();
        int numRows = (int) Math.ceil((keywordMatrix.encodedPlainText.length() * 2)/ numCols);

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrixStr += sortedKeywordMatrix[i][j];
                matrixStr += " ";
            }
            matrixStr += "\n";
        }

        return matrixStr;
    }
}
