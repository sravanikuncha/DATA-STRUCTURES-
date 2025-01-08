import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class HuffmannTreeNode{
    int freqCount;
    String data;
    HuffmannTreeNode left;
    HuffmannTreeNode right;

    HuffmannTreeNode(int freqCount,String data){
        this.freqCount=freqCount;
        this.data=data;
    }
}
class TrieNodePractice{
    char data;
    boolean isTerminating;
    int size;
    TrieNodePractice[] dictonaryCharcaters;

    TrieNodePractice(char data, boolean isTerminating,int size){
        this.data=data;
        this.isTerminating=isTerminating;
        this.size=size;
        dictonaryCharcaters=new TrieNodePractice[26];
    }

    void insert(String word){
        TrieNodePractice presentNode=this;
        for(char c:word.toCharArray()){
            int index=c-97;
            TrieNodePractice childCharNode=presentNode.dictonaryCharcaters[index];
            if(childCharNode!=null){
                presentNode=childCharNode;
                continue;
            }
            else{
                TrieNodePractice newNode=new TrieNodePractice(c, false,0);
                presentNode.dictonaryCharcaters[c-97]=newNode;
                presentNode.size+=1;
                presentNode=newNode;
            }
        }

        presentNode.isTerminating=true;
    }

    void suffixTrieinsert(String word,TrieNodePractice rootNode){
        while(word.length()>0){
            TrieNodePractice presentNode=rootNode;
            for(char c:word.toCharArray()){
                int index=c-97;
                TrieNodePractice childCharNode=presentNode.dictonaryCharcaters[index];
                if(childCharNode!=null){
                    presentNode=childCharNode;
                    continue;
                }
                else{
                    TrieNodePractice newNode=new TrieNodePractice(c, false,0);
                    presentNode.dictonaryCharcaters[c-97]=newNode;
                    presentNode.size+=1;
                    presentNode=newNode;
                }
            }

            presentNode.isTerminating=true;
            word=word.substring(1, word.length());
        }
    }

    boolean isPresent(String word){
        TrieNodePractice temp=this;
        for(char c:word.toCharArray()){
            TrieNodePractice childNode=temp.dictonaryCharcaters[c-97];
            if(childNode==null){
                return false;
            }
            else{
                temp=childNode;
            }
        }
    
        return temp.isTerminating;
    }

    private static void autoCompleteRecursion(TrieNodePractice tempNode,String autoComplete){

        if(tempNode.size==0){
            System.out.println(autoComplete);
            return;
        }

        System.out.println(autoComplete);

        for(int i=0;i<tempNode.dictonaryCharcaters.length;i++){
            if(tempNode.dictonaryCharcaters[i]!=null){
                String newString=autoComplete+tempNode.dictonaryCharcaters[i].data;
                autoCompleteRecursion(tempNode.dictonaryCharcaters[i], newString);
                newString=newString.substring(0,newString.length()-1);
            }
        }
    }

    void autoComplete(TrieNodePractice rootNode, String autoComplete){
        TrieNodePractice temp=rootNode;
        for(char c: autoComplete.toCharArray()){
            TrieNodePractice childNode=temp.dictonaryCharcaters[c-97];
            if(childNode==null){
                 return;
            }
            temp=childNode;
        }

       autoCompleteRecursion(temp,autoComplete);
    }

    int countWordsPractice(TrieNodePractice rootNode){
        
        int countWords=0;
        if(rootNode.isTerminating){
            countWords+=1;
        }

        for(int i=0;i<rootNode.dictonaryCharcaters.length;i++){
            if(rootNode.size>0 && rootNode.dictonaryCharcaters[i]!=null){
                countWords+=countWordsPractice(rootNode.dictonaryCharcaters[i]);
            }
        }

        return countWords;
    }

    boolean isPatternMatch( String pattern){

        boolean isPatternMatch=true;
        TrieNodePractice tempNode=this;
        for(char c: pattern.toCharArray()){
            TrieNodePractice childCharNode=tempNode.dictonaryCharcaters[c-97];
            if(childCharNode==null){
                return !isPatternMatch;
            }
            tempNode=childCharNode;
        }

        return isPatternMatch;
    }

}

class HuffmannCompressionAlgorithn{


    void storeVarLengthCodes(HuffmannTreeNode huffmannTreeNode,HashMap<String,String> varlengthCode,String s){
        if(huffmannTreeNode==null){
            return;
        }

        if(huffmannTreeNode.left==null && huffmannTreeNode.right==null){
            varlengthCode.put(huffmannTreeNode.data,s);
            return;
        }

        storeVarLengthCodes(huffmannTreeNode.left,varlengthCode,s+"0");
        storeVarLengthCodes(huffmannTreeNode.right,varlengthCode,s+"1");

    }


    void printHufmannTree(HuffmannTreeNode huffmannRootNode){
        Queue<HuffmannTreeNode> queue=new LinkedList<>();

        if(huffmannRootNode==null){
            return;
        }

        queue.add(huffmannRootNode);

        while(!queue.isEmpty()){
            HuffmannTreeNode frontNode=queue.poll();
            System.out.print(frontNode.freqCount+" ");
            if(frontNode.left==null && frontNode.right==null){
                System.out.print(frontNode.data);
            }
            if(frontNode.left!=null){
                System.out.print(" L:"+frontNode.left.freqCount+" ");
                queue.add(frontNode.left);
            }

            if(frontNode.right!=null){
                System.out.print(" R:"+frontNode.right.freqCount+" ");
                queue.add(frontNode.right);
            }
            System.out.println();
        }
    }

    HuffmannTreeNode constructTree(PriorityQueue<Integer> pq, HashMap<String,Integer> hm){
        
        HashMap<String,HuffmannTreeNode> node=new HashMap<>();
        HuffmannTreeNode thirdNode=null;
        if(pq.size()==0){
            return null;
        }

        if(pq.size()==1){
            Set<String> s=hm.keySet();
            for(String s1:s){
                thirdNode=new HuffmannTreeNode(pq.poll(),s1);
                break;
            }
        }

        while(pq.size()>1){
            int firstMin=pq.poll();
            int secondMin=pq.poll();

            String firstChar=null,secondChar=null;
            //Get the characters of both min and delete them.
            Set<String> chars=hm.keySet();
            for(String c:chars){
                int value=hm.get(c);
                if(value==firstMin && firstChar==null && c!=secondChar){
                    firstChar=c;
                }
                if(value==secondMin && secondChar==null && c!=firstChar){
                    secondChar=c;
                }
            }

            hm.remove(firstChar);
            hm.remove(secondChar);

            HuffmannTreeNode firstNode,secondNode;
            if(node.containsKey(String.valueOf(firstChar))){
                firstNode=node.get(String.valueOf(firstChar));
            }
            else{
                firstNode=new HuffmannTreeNode(firstMin,firstChar);
            }

            if(node.containsKey(String.valueOf(secondChar))){
                secondNode=node.get(String.valueOf(secondChar));
            }
            else{
                secondNode=new HuffmannTreeNode(secondMin, secondChar);
            }

            thirdNode=new HuffmannTreeNode(firstMin+secondMin, firstChar+secondChar);
            thirdNode.left=firstNode;
            thirdNode.right=secondNode;
            pq.add(firstMin+secondMin);
            node.put(firstChar+secondChar,thirdNode);
            hm.put(firstChar+secondChar,firstMin+secondMin);
       
        }
    return thirdNode;
}

    void huffmannCompressionAlgoImpl(String paragraph){

        //Step1: frequeuncy store
        HashMap<String,Integer> freq=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(char c:paragraph.toCharArray()){
            if(freq.containsKey(String.valueOf(c))){
                int value=freq.get(String.valueOf(c));
                freq.put(String.valueOf(c), value+1);
            }
            else{
                freq.put(String.valueOf(c), 1);
            }
        }

        //Step2: MinHeap
        //we can minimise more if we try to keep hufmannode as priorityqueue instead of just numbers or frequency , more memory is sved and less compllex . 
        Set<String> freqKeys=freq.keySet();
        for(String c:freqKeys){
            pq.add(freq.get(c));
        }

        //Step3: formTree
        HuffmannTreeNode huffmannNode=constructTree(pq,freq);
        printHufmannTree(huffmannNode);

        //Step4: getCodes
        HashMap<String,String> varlengthCode=new HashMap<>();
        storeVarLengthCodes(huffmannNode,varlengthCode,"");
        
       //Write in Compressed Format:
        for(char c:paragraph.toCharArray()){
            System.out.print(varlengthCode.get(String.valueOf(c)));
        }
       
    }   
}



public class TriesandHuffmannCodingPractice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // String s=sc.nextLine();
        // String[] words=s.split(" ");
        
        //tries and huffmann coding and it is a good data structure for immplementing dictionary
        // TrieNodePractice rootNode=new TrieNodePractice('\u0000', false,0);
        // for(String eachWord: words){
        //     rootNode.insert(eachWord);
        // }

        // System.out.println("Enter a word to find if in a dictionary/Trie if presnet or not ");
        // String findWord=sc.nextLine();
        // boolean isWordPresent=rootNode.isPresent(findWord);
        // System.out.println(isWordPresent);

        // String autoComplete=sc.nextLine();
        // System.out.println("Autocompleteing the give word from dictionary");
        // rootNode.autoComplete(rootNode,autoComplete);

        // int nrofWords=rootNode.countWordsPractice(rootNode);
        // System.out.println(nrofWords);

        // System.out.println("Suffix trie Creation");
        // TrieNodePractice suffixTrie=new TrieNodePractice('\u0000', false,0);
        // for(String eachWord: words){
        //     suffixTrie.suffixTrieinsert(eachWord,suffixTrie);
        // }

        // System.out.println("pattern Matching");
        // s=sc.nextLine();
        // boolean isPatternPresent=suffixTrie.isPatternMatch(suffixTrie,s);
        // System.out.println(isPatternPresent);

        // System.out.println("Palindrome Trie");
        // TrieNodePractice palindromeRootNode=new TrieNodePractice('\u0000', false,0);
        // boolean isPalindromePresent=palindromeRootNode.isPalindromePresent(words);
        

        System.out.println("Huffmann Coding");
        String paragraph=sc.nextLine();
        //aaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbrrrrrrrrrrrryyyyyyyy
        HuffmannCompressionAlgorithn compressionAlgo=new HuffmannCompressionAlgorithn();
        compressionAlgo.huffmannCompressionAlgoImpl(paragraph);

        sc.close();
   }
}
