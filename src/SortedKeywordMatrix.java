import java.util.*;

public class SortedKeywordMatrix {
    public String key;
    public KeywordMatrix keywordMatrix;
    public char[][] sortedKeywordMatrix;
    public String encryptedMessage;

    public SortedKeywordMatrix(String key, KeywordMatrix keywordMatrix){
        this.key = key;
        this.keywordMatrix = keywordMatrix;
        this.sortedKeywordMatrix = sortKeywordMatrix();
    }

    public char[][] sortKeywordMatrix() {
        int numCols = key.length();
        int numRows = (int) Math.ceil((double)keywordMatrix.encodedPlainText.length()/ numCols);

        char[][] sortedMatrix = new char[numRows][numCols];

        // sort key
        char[] tempArray = key.toCharArray();

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

        // make hash map with letter in keyWord as the key, arrayList of chars at value
        HashMap<Character, ArrayList<Character>> hmap = new HashMap<>();

        for (int i = 0; i < numCols; i++) {
            hmap.put(tempArray[i], colsMatrix.get(i));
        }

        // rearrange columns according to sorted key (tempArray)
        Arrays.sort(tempArray);

        String sortedKeywordMatrixStr = "";

        // go through the key values in the hash map
        // these are sorted letters of the keyWord
        for (char c: tempArray) {
            // navigate through each letter in array list values and append to string
            for (char d: hmap.get(c)) {
                sortedKeywordMatrixStr += d;
            }
        }

        int tempIndex = 0;

        for (int col = 0; col < numCols; col++) {

            for (int row = 0; row < numRows; row++) {
                if (tempIndex < sortedKeywordMatrixStr.length()) {
                    sortedMatrix[row][col] = sortedKeywordMatrixStr.charAt(tempIndex);
                    tempIndex++;
                }
            }
        }

        String finalStr = "";
        char[] finalChars = sortedKeywordMatrixStr.toCharArray();

        for (char c: finalChars) {
            if (c != '0') {
                finalStr += c;
            }
        }
        encryptedMessage = finalStr;

        // final matrix with encrypted message
        return sortedMatrix;
    }

/*
    public String toString() {

        String finalStr = "";

        for (char c: sortedKeywordMatrixStr.toCharArray()) {
            if (c != '0') {
                finalStr += c;
            }
        }

        return finalStr;
    }

 */

    @Override
    public String toString() {
        String str = "";

        int numCols = key.length();
        int numRows = (int) Math.ceil((double)keywordMatrix.encodedPlainText.length()/ numCols);

        char[] sortedKey = key.toCharArray();
        Arrays.sort(sortedKey);

        for (char c: sortedKey) {
            str += c;
            str += " ";
        }
        str += "\n";
        for (char c: sortedKey) {
            str += "__";
        }
        str += "\n";

        for (int row = 0; row < numRows; row++) {

            for (int col = 0; col < numCols; col++) {
                if (sortedKeywordMatrix[row][col] != '0') {
                    str = str + sortedKeywordMatrix[row][col] + " ";
                }
                else {
                    str += "  ";
                }
            }
            str += "\n";
        }

        return str;
    }
}
