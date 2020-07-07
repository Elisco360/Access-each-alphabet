import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Content {
    private int[] frequencies = new int[26];;
    private String fileContent;


    /**
     * Constructor that reads a file by means of taking filePath and scans its content into fileContent.
     * It also calls on the letterFrequency() method to automatically obtain the frequencies without the user calling it.
     * @param filePath this parameter directs the File class to access the text file for reading.
     * @throws FileNotFoundException this exception is thrown to cater for wrong file paths and names.
     */
    public Content(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner scanFile = new Scanner(file);

        fileContent = "";
        while(scanFile.hasNextLine()){
            this.fileContent = this.fileContent.concat(scanFile.nextLine().toLowerCase());
        }

        letterFrequency();
    }


    /**
     * This method stores the frequencies of each letter by iterating through fileContent and myAlphabets simultaneously
     */
    public void letterFrequency() {
        char[] myAlphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        for (int index = 0; index != fileContent.length(); index++) {
            for (char eachChar : myAlphabets) {
                if (eachChar == fileContent.charAt(index)) {
                    frequencies[new String(myAlphabets).indexOf(eachChar)]++;
                }
            }
        }
    }


    /**
     * This method is responsible for making our frequencies referencable in other files
     * @return it returns the int array of frequencies of each letter in order of alphabets
     */
    public int[] getLetterFrequency() { return frequencies; }
