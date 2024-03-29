//Made by Matt
public class Node {
    private boolean isLeaf;
    private String sequence;
    private Integer level;
    private Node[] children;
    
    //new Nodes are leaf Nodes with null sequences
    Node(Integer level){
        isLeaf=true;
        sequence=null;
        this.level=level;
        children=null;
    }

    //returns true if leaf node
    boolean isLeaf(){
        return isLeaf;
    }

    //returns sequence
    String getSequence(){
        return sequence;
    }

    //sets the Node's sequence
    void setSequence(String sequence){
        this.sequence=sequence;
    }

    //returns level
    Integer getLevel(){
        return level;
    }

    //changes a leaf node to an internal node
    void setLeaf(){
        isLeaf=false;
        //internal nodes have a null level
        level=null;
    }
    
    //sets the proper child to Node n
    void setChild(Node n,Integer pos){
        //initialize array if null
        if (children==null){
            children=new Node[5];
        }
        //sets proper child to Node n
        children[pos]=n;
    }
}
