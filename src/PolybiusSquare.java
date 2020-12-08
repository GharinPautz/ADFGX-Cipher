import java.util.*;

/**
 * This class contains the state and behavior of a Polybius Square.
 * This represents the second step in the ADFGX cipher where we create
 * a 5x5 key for the encryption, which is generated from the plain text.
 */
public class PolybiusSquare {
    public String key;
    public char[][] square = new char[5][5];

    /**
     * Constructor for Polybius Square Object
     *
     * @param key is the key we are using to create the Polybius Square
     */
    public PolybiusSquare(String key) {
        this.key = key;
        this.square = generateSquare();
    }

    /**
     * Generates the polybius square given the input plain text.
     *
     * @return 5x5 array populated with plain text and remaining letters of alphabet
     *      Example:
     *          Plain text: Elephant Kings
     *          Square: e l p h a
     *                  n t k i g
     *                  s b c d f
     *                  m o q r u
     *                  v w x y z
     */
    public char[][] generateSquare() {
        // remove spaces from key
        String text = key.replaceAll("\\s+", "");
        text = removeRepeatLetter(text);

        // Get all available letters in the alphabet
        List<Character> list = new ArrayList<>();
        for (char a = 'a'; a <= 'z'; a++) {
            list.add(a);
        }

        // remove 'j' from list
        list.remove('j' - 'a');

        Queue<Character> ptQueue = new LinkedList<>();

        // for each letter in the message
        // add the letter to the queue and remove from array list
        for (char c: text.toCharArray()) {
            ptQueue.add(c);

            // remove letter from array list
            list.remove((Character)c);
        }

        char textLastLetter = text.charAt(text.length() - 1);
        char listStartingLetter = (char) ((int)(textLastLetter) + 1);

        // increment letter while it does not exist in list
        while(!list.contains(listStartingLetter)){
            listStartingLetter = (char) ((int) (listStartingLetter) + 1);
        }

        // get index of starting letter in list
        int listStartingLetterIndex = 0;
        for (int index = 0; index < list.size(); index++) {
            if(list.get(index) == listStartingLetter) {
                listStartingLetterIndex = index;
            }
        }

        // add remaining letters in array list
        // start with next letter in alphabet after last letter of message
        for(int i = listStartingLetterIndex; i <= list.size() - 1; i++){
            ptQueue.add(list.get(i));
        }

        // add remaining letters in array list
        // end with starting letter of previous loop
        for(int c = 0; c < listStartingLetterIndex; c++){
            ptQueue.add(list.get(c));
        }

        // row
        for (int i = 0; i < 5; i++) {
            // column
            for (int j = 0; j < 5; j++) {
                square[i][j] = ptQueue.peek();
                ptQueue.remove();
            }
        }
        return square;
    }

    /**
     * Removes repeat letters in PlainText string
     *
     * @param str is String object of message we are encrypting
     * @return String object with the letters in the original string in same order
     *  without repeat letters
     */
    public String removeRepeatLetter(String str) {
        Set<Character> chars = new HashSet<>();
        StringBuilder output = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (chars.add(ch)) { output.append(ch);
            }
        }
        return output.toString();
    }

    /**
     * Overriden toString method to represent generated polybius square
     *
     * @return String representation of generated polybius square
     */
    @Override
    public String toString() {
        String squareStr = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                squareStr += square[i][j];
                squareStr += " ";
            }
            squareStr += "\n";
        }

        return squareStr;
    }


}
