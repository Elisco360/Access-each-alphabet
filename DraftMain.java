package Assignment;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BarChart extends JPanel {
    private content file;

    BarChart(content file){ this.file = file; }

    public void paintComponent(Graphics graphics) {

        super.paintComponent(graphics);

        graphics.setColor(Color.BLACK);
        graphics.drawLine(45,10,45,785);//Y-Axis
        graphics.drawLine(45,785,1105,785);//X-Axis
        graphics.setColor(Color.BLUE);

        int j = 65;
        for(int i = 0; i != file.getLetterTimes().length; i++) { graphics.fillRect(j,785 - this.file.getLetterTimes()[i], 30,this.file.getLetterTimes()[i]); j+=40; }

        graphics.setColor(Color.BLACK);
        j = 75;
        String[] alphabets = { "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        for(String eachLetter : alphabets){ graphics.drawString(eachLetter,j,798); j+=40;}

        j = 785;
        String[] numbers = {"0","50","100","150","200","250","300","350","400","450","500","550","600","650","700","750"};
        for(String eachNumber : numbers){ graphics.drawString(eachNumber,16,j); j-=50; }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the file name: ");
        String userFile = input.nextLine();
        content myFile = new content(userFile);
        System.out.println(myFile.retrieveFile());

        BarChart chart = new BarChart(myFile);
        JFrame jf = new JFrame();

        jf.setTitle("Bar Chart");
        jf.setSize(1135,850);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(chart);
    }
}
