package edu.frostburg.cosc310.Tripp;

import java.util.Scanner;

/**
 * This class is the driver class for my 90's Slang Translator.
 * The main method of this class collects user input in the form
 * of a sentence and translates it using common 90's slang phrases.
 * If the user presses the enter key instead, the program exits.
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class SlangTranslator {
    
    /**
     * The main method for the Slang Translator program.
     * This method gathers user input using a scanner and
     * passes that input to the SlangRules class, which is
     * responsible for translating the input sentence to
     * the appropriate output sentence.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a message to be translated:");
        String input = sc.nextLine();
        if(input.isEmpty())
            System.exit(0);
        System.out.println(SlangRules.processString(input));
    }
    
}
