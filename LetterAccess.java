package Assignment;

import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class content {
    private String fileName;
    private int[] letterTimes;

    public content(String fileName){
        this.fileName = fileName;
        this.letterTimes = new int[26];
    }
    
    public void retrieveFile() throws FileNotFoundException {
        String fileContent = "";
        File file = new File("/Users/elibo/OneDrive/Desktop/" + fileName);
        Scanner scanFile = new Scanner(file);

        while (scanFile.hasNextLine()) {
            fileContent = fileContent.concat(scanFile.nextLine());
        }
        this.fileName = fileContent.toLowerCase();
        System.out.println(fileName);
    }

    public String charNumber() {
        String alphabets =  "abcdefghijklmnopqrstuvwxyz";
        char[] myAlphabets =  {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int index = 0; index != fileName.length(); index++){
            for(char eachChar: myAlphabets){
                if(eachChar == fileName.charAt(index)){
                    letterTimes[alphabets.indexOf(eachChar)]++;
                }
            }
        }
        return Arrays.toString(letterTimes);
    }
}

public class DemoCode {
    public static void main(String[] args) throws FileNotFoundException{
        content myContent = new content("myself.txt");
        myContent.retrieveFile();
        System.out.println(myContent.charNumber()
        );
    }

}
