import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DNAtree {
    private FileInputStream file;
    private Scanner scan;

    /**
     * Validates filename inputted from std in
     * @param filename - filename to be validated
     * @return true if file is valid and scanner object was properly created, false if file is invalid
     */
    public boolean validateFile(String filename) {
        try {
            file = new FileInputStream(filename);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            return false;
        }
        return true;
    }

    /**
     * Method reads in the data from each file
     */
    public void readFile() {
        while (scan.hasNext()) {
            String token = scan.next();
            System.out.println("Token:" + token);
            if (token.equals("insert")) {
                token = scan.next();
                insert(token);
            } else if (token.equals("print")) {
                print();
            }
        }

    }

    /**
     * Method prints the contents of the tree
     */
    public void print() {
        System.err.println("Urg");
    }

    /**
     * Method takes the inputted DNA string and attempts to insert it into the tree
     * @param token - DNA string to be inserted
     * @return level the string was inserted at, -1 if the string already exists
     */
    public int insert(String token) {
        return -1;
    }


    //instance variables and constructor by Matt
    private Node head;

    //new DNAtrees have 1 node with level 0
    DNAtree(){
        head=new Node(0);
    }


    public static void main(String args[]) {
        DNAtree tree = new DNAtree();
        if (args.length == 0 || args[0].trim().isEmpty()) {
            System.err.println("No file inputted from command line");
        }
        boolean result = tree.validateFile(args[0]);
        if (!result) {
            System.err.println("Error, invalid file");
        }
        tree.readFile();
    }
}
