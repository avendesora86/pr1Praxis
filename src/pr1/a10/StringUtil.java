package pr1.a10;                                 // Shari Wagner (ehem. Donath)
                                                 // Matr.Nr. 860836

import java.io.File;
import java.util.Scanner;
import schimkat.berlin.lernhilfe2016ws.io.DirtyFileReader;

/**
 * Created by shari on 14.01.2017.
 */
public class StringUtil {

    public static void main (String[] args){

        String[] testStrings = createTestStrings01();

        for(String bla  : testStrings) {
            System.out.println(countUpperCaseChar(bla));
        }

        File file = new File("./data/testfiles/Util.txt");
        System.out.println(getRatioWhitespaceToAll(file));

    }


    public static int countUpperCaseChar(String s){

        if (s == null){
            return 0;
        }
        if (s.equals("")){
            return 0;
        }
        int upperCaseNumber = 0;
        char[] myChars = s.toCharArray();

        for (char ch : myChars){
            if(Character.isUpperCase(ch)){
                upperCaseNumber++;
            }
        }

        return upperCaseNumber;
    }

    public static double getRatioWhitespaceToAll(String s){
        if (s == null){
            return 0;
        }
        if (s.equals("")){
            return 0;
        }
        int sum = 0;

        for (int i = 0; i < s.length(); i++){
            if(Character.isWhitespace(s.charAt(i))){
                sum++;
            }
        }
        double whiteSpaceRatio = sum * 100 / s.length();

        return whiteSpaceRatio;
    }

    public static String[] createTestStrings01(){
        return new String [] {" a b c d E f G H I j K l m n O P q R s T u v W",     //contains upperCase+lowerCase+Whitespace
                "AAAFSOF",                                                          //contains only upperCase
                " e jgoe eow ",                                                     //contains lowerCase and Whitespace
                "",                                                                 //contains empty string
                "123",                                                              //contains numbers, no whitespace or letters
                "       ",                                                          //contains only whitespace
                null};                                                              //check if there was any input
    }

    public static int countUpperCaseChar(File textfile){

        int upperCaseNumber = 0;

        Scanner file = new Scanner(new DirtyFileReader(textfile));

        while(file.hasNext()){
            if(file.hasNextLine()){
                upperCaseNumber += countUpperCaseChar(file.nextLine());
            }
        }
        return upperCaseNumber;

    }

    public static double getRatioWhitespaceToAll(File textfile){
        double whiteSpaceRatio = 0;
        int totalWhitespaces = 0;
        int totalChars = 0;
        Scanner file = new Scanner(new DirtyFileReader(textfile));

        while(file.hasNext()){
            if(file.hasNextLine()){
                String line = file.nextLine();
                totalChars += line.length() + 1; //adding linebreak
                totalWhitespaces += countWhitespaces(line) + 1;//linebreak = whitespace --> add +1
            }
        }
        totalChars--; //no linebreak in last line
        totalWhitespaces--;//no linebreak in last line

        whiteSpaceRatio = (double)totalWhitespaces / (double)totalChars * 100;

        return whiteSpaceRatio;
    }
    public static int countWhitespaces(String s) {

        if (s == null) {
            return 0;
        }
        if (s.equals("")) {
            return 0;
        }
        int whitespaceNumber = 0;
        char[] myChars = s.toCharArray();

        for (char ch : myChars) {
            if (Character.isWhitespace(ch)) {
                whitespaceNumber++;
            }
        }
        return whitespaceNumber;
    }
}
