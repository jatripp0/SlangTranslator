package edu.frostburg.cosc310.Tripp;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains methods for translating an input sentence
 * to common 90's slang terms using various helper methods to
 * alter the sentence according to various rules, such as replacing
 * portions of some words with "izzle", and changing occurences of
 * the words "cool" and "fun" to "fly".
 * @author Johnathan Tripp (╯°□°）╯︵ ┻━┻
 */
public class SlangRules {
    
    private static StringBuilder sb;
    private static final Random r = new Random();
    private static Pattern p;
    private static Matcher m;
    public static String REGEX = "cool|fun";
    public static String SplitReg = "\\P{L}+";
    
    /**
     * A method for processing an input string using various
     * helper methods to alter the string in various ways. A
     * StringBuilder is used to manipulate the string throughout
     * the helper methods, and its final string is returned.
     * @param s The input string
     * @return The 90's slang translation, created by the StringBuilder
     */
    public static String processString(String s){
        sb = new StringBuilder(s);
        insertYo();
        replacePhrase(REGEX, "fly");
        replacePhrase("for", "fo");
        toIzzle();
        yadda();
        return sb.toString();
    }
    
    /**
     * This is a helper method that has a 50% chance of inserting
     * the word "Yo" in front of the input sentence when called.
     */
    private static void insertYo(){
        if(r.nextBoolean()){
            sb.insert(0, "Yo! ");
        }
    }
    
    /**
     * This method is a general purpose method for replacing a portion
     * of a string inside a StringBuilder using a regular expression and
     * a replacement string.
     * @param target A regular expression to match the StringBuider string.
     * @param replacement A string to replace matches in the original string.
     */
    private static void replacePhrase(String target, String replacement){
        p = Pattern.compile(target);
        m = p.matcher(sb.toString());
        while(m.find()){
            sb.replace(m.start(), m.end(), replacement);
        }
    }
    
    /**
     * This method replaces parts of words longer than three letters
     * with "izzle" by scanning for the first occurrence of a vowel in
     * a word, then replacing the rest of the string from that vowel to
     * the end of the word. This method splits the input string to an
     * array for processing, but restores the altered words to their positions
     * in the StringBuilder.
     */
    private static void toIzzle(){
        int start, end;
        p = Pattern.compile("[aeiou]");
        String[] ar = sb.toString().split(SplitReg);
        for(String s : ar){
            if(s.length() > 3){
                m = p.matcher(s);
                if(m.find()){
                    if(s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u")){
                        m.find();
                    }
                    start = sb.indexOf(s) + m.start();
                    end = sb.indexOf(s) + s.length();
                    sb.replace(start, end, "izzle");
                }
            }
        }
    }
    
    /**
     * This method replaces all words after the tenth word in the input
     * string with "yadda, yadda, yadda...".
     */
    public static void yadda(){
        int start, end, indexCtr = 0;
        String str = sb.toString();
        String[] ar = sb.toString().split(SplitReg);
        if(ar[0].equals("Yo")){
            if(ar.length > 11){
                for(int i=0; i<10; i++){
                    indexCtr += ar[i].length();
                }
                start = str.indexOf(ar[11], indexCtr);
                end = str.length();
                sb.replace(start, end, "yadda, yadda, yadda...");
            }
        } else {
            if(ar.length > 10){
                for(int i=0; i<9; i++){
                    indexCtr += ar[i].length();
                }
                start = str.indexOf(ar[10], indexCtr);
                end = str.length();
                sb.replace(start, end, "yadda, yadda, yadda...");
            }    
        }
    }
}
