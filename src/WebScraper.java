import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class WebScraper {
    public static void main(String[] unused) {
        String file = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(wordCounter(file));
        System.out.println(specificWord(file, "Prince"));

    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;

    }

    /**
     * Retrieve the contents of a string and returns the number of words in it.
     *
     * @param contents string of words to do a word count on
     * @return the number of words in the string
     */
    public static int wordCounter(String contents) {
        //sets initial count to 0
        int number = 0;

        //creates a new string that strips the original string of all the punctuation
        String cleanContents = contents.replaceAll("\\W", " ");
        //takes the string and converts it into an array
        //each new word is a new string in the array
        String[] words = cleanContents.split("\\s+");

        //goes through the array and adds 1 to the count
        for (int i = 0; i < words.length; i++) {
            number += 1;
        }

        return number;
    }

    /**
     * Retrieve the contents of a string and returns the number of occurrences of a certain word in it.
     *
     * @param contents string of words to search for a word in
     * @param word the word to search the text for
     * @return the number of occurrences of the word in the string
     */
    public static int specificWord(String contents, String word) {
        //initializes and sets the number of occurrences of the word to 0
        int numOccurrences = 0;

        //creates a new string that strips the original string of all the punctuation
        String cleanContents = contents.replaceAll("\\W", " ");
        //takes the string and converts it into an array
        //each new word is a new string in the array
        String[] script = cleanContents.split("\\s+");

        //goes through each word of the script
        for (int i = 0; i < script.length; i++) {
            //if the word is found in any case
            //adds one to the count
            if (script[i].equalsIgnoreCase(word)) {
                numOccurrences += 1;
            }
        }


        return numOccurrences;
    }

}