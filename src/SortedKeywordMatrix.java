import java.util.*;

public class SortedKeywordMatrix {
    public String key;
    public KeywordMatrix keywordMatrix;
    public String sortedKeywordMatrixStr;

    public SortedKeywordMatrix(String key, KeywordMatrix keywordMatrix){
        this.key = key;
        this.keywordMatrix = keywordMatrix;
        this.sortedKeywordMatrixStr = sortKeywordMatrix();
    }

    public String sortKeywordMatrix() {
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

        // final string with encrypted message
        return sortedKeywordMatrixStr;
    }


    public String toString() {

        String finalStr = "";

        for (char c: sortedKeywordMatrixStr.toCharArray()) {
            if (c != '0') {
                finalStr += c;
            }
        }

        return finalStr;
    }
}
