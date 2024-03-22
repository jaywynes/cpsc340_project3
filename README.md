# cpsc340_project3
## Work Division
Jayden: Print & Files

Matt: Insert & Classes

## Files
readFile method

Reads in line by line, looking for keywords insert and print
Lines will be correct upon insert


## Cases
### Case 1: null tree 
Tree has null root

If root.element == null/empty and leaf array == null, then 
insert string into root.element

### Case 2: Existing Node
Root has a string when trying to insert

Examine current character in the string, and 
send each string down to the node of the associated character
ACGT
becomes
```
I 
  ACGT
  CAGT
  E
  E
  E
```

### Case 3: Same Chars
ACGT and AC
If current node.element != null/empty, then assign root.Node 
to the inserted string, then call insert on the current root.element 

ACGT
Becomes
```
I
  I: A branch
    I: C branch
      E
      E
      ACGT
      E
      AC
```

### Case 4: Same sequence
if root.element == sequence, return -1

### Case 5: Same seq, diff level
Same process as Case 4, just down a level(s)

## Algorithm
What I think I know:
•	After root node, each depth of node-1 = relevant character (depth of 1 looks at first character) (human reading)
•	Depth=char for child
Attempted Algo:
Returns depth of insertion, otherwise returns -1
Integer insert(String sequence, int depth)- depth starts at 0
If (sequence.equals(root.sequence)- if it equals, return -1
If (root.isLeaf() and root.sequence==null)- set null sequence to sequence and return //base case
If (root.child(charAt(depth)==null)- make a new child if null, find a way to check for $
Make new Node at child of charAt(depth);
Insert(sequence,depth+1);
If (root.isLeaf())
Move(root);

Move(Node root)- moves existing sequence to new place (can be done in insert, separated for now for easier visualization)
String sequence=root.getSequence()
Root.setSequence(null);
Insert(sequence,0);
Assumptions about nodes:
New sequences are null, and new Nodes are leaves
Algo Case 1:
Works
Algo Case 2:
Works
Algo Case 3:
Null
Null 	E	E	E	E
E	Null	E	E	E
E	E	ACGT	E	AC
