class TrieNode{
    char data;
    boolean isTerminalNode;
    TrieNode children[];
    int childCount;


    public TrieNode(char data){
        this.data=data;
        this.isTerminalNode=false;
        this.children=new TrieNode[26];
        this.childCount=0;
    }
}

class TrieFunctions {
    public TrieNode root;


    public TrieFunctions(){
        root=new TrieNode('\0');
    }

    public void add(String word){
        addHelper(root,word);
    }

    private void addHelper(TrieNode root, String word){
        if(word.isEmpty()){
            root.isTerminalNode=true;
            return;
        }
        int childIndex=word.charAt(0)-'A';
        TrieNode child=root.children[childIndex];
        if(child==null){
            TrieNode newNode=new TrieNode(word.charAt(0));
            root.children[childIndex]=newNode;
            root.childCount++;
        }
        
        addHelper(root.children[childIndex], word.substring(1));
    }

    public boolean search(String word){
       return  searchHelper(root,word);
    }

    private boolean searchHelper(TrieNode root,String word){
        if(word.length()==0)
            return root.isTerminalNode;
        int childIndex=word.charAt(0)-'A';
        TrieNode child=root.children[childIndex];
        if(child==null)
            return false;
        return searchHelper(child, word.substring(1));
    }

    public void remove( String word){
        removeHelper(root,word);
    }

    private void removeHelper(TrieNode root, String word){
        if(word.length()==0){
            root.isTerminalNode=false;
            return;
        }
        int childIndex=word.charAt(0)-'A';
        TrieNode chidlNode=root.children[childIndex];
        if(chidlNode==null){
            return;
        }
        removeHelper(chidlNode, word.substring(1));
        //improve solution by actually deleting the nodes and freeing up memory,  asked in interviews 
    }
}

public class TrieImplementation{
    public static void main(String[] args) {
        TrieFunctions tf=new TrieFunctions();
        tf.add("AND");
        tf.add("ANT");
        tf.add("NOTE");
        tf.add("NOTES");

        System.out.println(tf.search("NOTESI"));
        System.out.println(tf.search("AND"));
        
        tf.remove("AND");
        System.out.println(tf.search("AND"));
    }
   
}
