public class PermutationSTrings {
    public static void main(String[] args) {

       String  str1="race",str2="rate";
        int[] count=new int[26];
		int asciiValue=97;

		for(int i=0;i<str1.length();i++){
			int index=str1.charAt(i)-asciiValue;
			count[index]+=1;
		}

		for(int i=0;i<str2.length();i++){
			int index=str2.charAt(i)-asciiValue;
			count[index]-=1;
		}

	boolean isPermutation=true;
		for(int i=0;i<26;i++){
			if(count[i]!=0) 
				System.out.println(!isPermutation);
		}

		System.out.println(isPermutation);
        


        System.out.println(0+'a');
    }
}
