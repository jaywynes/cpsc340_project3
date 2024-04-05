import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class DNAtree {
    private FileInputStream file;
    private Scanner scan;

    //instance variables and constructor by Matt
    private Node head;

    //new DNAtrees have 1 node with level 0
    DNAtree(){
        head=new Node(0);
        file=null;
        scan=null;
    }

    /**
     * Validates filename inputted from std in
     * @param filename - filename to be validated
     * @return true if file is valid and scanner object was properly created, false if file is invalid
     * @author Jayden W.
     */
    public boolean validateFile(String filename) {
        try {
            // Attempts to instantiate FileInputStream and Scanner
            file = new FileInputStream(filename);
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            // If file is invalid/can't properly setup a scanner on the file
            return false;
        }
        return true;
    }

    /**
     * Method reads in the data from each file
     * @author Jayden W
     */
    public void readFile() {
        while (scan.hasNext()) {
            String token = scan.next();
            // System.out.println("Token:" + token);
            if (token.equals("insert")) {
                // if next word is insert, takes next word (the DNA string) and inserts it
                token = scan.next();
                int result = insert(head, token, 0);
                if (result >= 0) {
                    // If the string was inserted at a level
                    System.out.println("sequence " + token + " inserted at level " + result);
                } else {
                    // If the string already exists, insert method return -1 in this case
                    System.out.println("Sequence " + token + " already exists");
                }
            } else if (token.equals("print")) {
                // Calls print on current tree
                System.out.println("tree dump:\n" + print(head, 0));
            }
        }

    }

    /**
     * Method prints the contents of the tree
     * "  ".repeat(level) prints out 2 spaces per level of tree
     * @author Jayden W
     */
    public String print(Node root, int level) {
        if (root == null) {
            // empty leaf node
            return ("  ".repeat(level) + "E");
        } else if (root.isLeaf()) {
            // Filled leaf node, prints sequence
            return ("  ".repeat(level) + root.getSequence());
        } else {
            // Creates next branch of tree for internal node
            String s = "  ".repeat(level) + "I\n";
            // Recursively calls print on each child to move down tree
            for (int i = 0; i < 4; i++) {
                s+= print(root.getChild(i), level + 1) + "\n";
            }
            // remove extra newline character on 5th child
            s+= print(root.getChild(4), level + 1);
            return s;
        }
    }

    /**
     * Method takes the inputted DNA string and attempts to insert it into the tree
     * @param root - current node
     * @param sequence - DNA string to be inserted
     * @param level - current level in tree
     * @return level the string was inserted at, -1 if the string already exists
     * @author Matt
     */
    //insert by Matt
    //returns level of insertion, if duplicate returns -1
    public int insert(Node root,String sequence,Integer level){
        if (sequence.equals(root.getSequence())){
            return -1;
        }
        if (root.isLeaf() && root.getSequence()==null){
            root.setSequence(sequence);
            return root.getLevel();
        }
        //recursive case
        //if child is null, make a new child
        if (root.getChild(findChild(sequence,level))==null){
            root.setChild(new Node(level+1),findChild(sequence,level));
        }
        //update current node
        if (root.isLeaf()){
            insert(head,root.setInternal(),0);
        }
        //call insert on appropriate child
        Integer temp=insert(root.getChild(findChild(sequence,level)),
                sequence,level+1);
        return temp;
    }

    /**
     * Returns the position insert should recursively call
     * @param sequence - DNA string to be analyzed
     * @param level - current level
     * @return correct child to call insert into
     * @author Matt
     */
    //returns the position insert should recursively call
    //A=0,C=1,G=2,T=3,$=4
    Integer findChild(String sequence,Integer level){
        //sequence ended
        if (sequence.length()==level){
            return 4;
        }
        char child=sequence.charAt(level);
        if (child=='A'){
            return 0;
        } else if (child=='C'){
            return 1;
        } else if (child=='G'){
            return 2;
        }
        //T is only remaining option
        return 3;
    }


    /**
     * Main function, takes in a filename from command line and tests its validity. If valid,
     * it executes every command in the file through readFile() method
     * @param args - Filename inserted from command line
     */
    public static void main(String args[]) {
        DNAtree tree = new DNAtree();
        if (args.length == 0 || args[0].trim().isEmpty()) {
            // If there is no file inputted from the command line
            System.err.println("No file inputted from command line");
        }
        boolean result = tree.validateFile(args[0]);
        if (!result) {
            // If the filename was invalid
            System.err.println("Error, invalid file");
        }
        // Executing commands in file
        tree.readFile(); 
    }
}
