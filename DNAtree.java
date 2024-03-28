public class DNAtree {
    //instance variables and constructor by Matt
    private Node head;

    //new DNAtrees have 1 node with level 0
    DNAtree(){
        head=new Node(0);
    }
    
    //insert by Matt
    //returns level of insertion, if duplicate returns -1
    Integer insert(Node root,String sequence,Integer level){
        if (sequence.equals(root.getSequence())){
            return -1;
        }
        if (root.isLeaf() && root.getSequence()==null){
            root.setSequence(sequence);
            return root.getLevel();
        }
        //recursive case
        Integer temp=insert(root.getChild(findChild(sequence,level)),
               sequence,level);
        //update current node
        if (root.isLeaf()){
            insert(head,root.setInternal(),0);
        }
        return temp;
    }
    
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

    public static void main(String args[]) {               

    }
}
