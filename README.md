# cpsc340_project3
## Insert
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