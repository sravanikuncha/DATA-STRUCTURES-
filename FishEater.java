public class FishEater {
    public static void main(String[] args) {

        int[] fishes={4 ,4, 2, 4};
        int start=0,j=0,count=0,countBefore=fishes.length;
        while(start<fishes.length){
        for(int i=start;i+1<fishes.length;i=i+2){
            if(fishes[i]==0)
                break;
            if(fishes[i]>fishes[i+1])
                fishes[i+1]=0;                      
        }
        
        count=movezerostoend(fishes);
       
        printArray(fishes);
      
        if(count==countBefore) { 
            start= j+1;
            j=start;        
        }  
        
        countBefore=count;
            
        
         
    }

System.out.println(count);
    }
    public static int movezerostoend(int[] fishes){

        int count=0;
        for(int z=0,nz=0;z<fishes.length;){
            
            
            if(fishes[z]==0){
                z++;                
            }
            else{
                swap(fishes,nz,z);
                z++;
                nz++;
            }
            
        }

        for(int i=0;i<fishes.length;i++){
            if(fishes[i]!=0)
                count++;
        }
        return count;
    }
    

    	public static void swap(int[] arr, int nz, int z){
			int temp=arr[nz];
			arr[nz]=arr[z];
			arr[z]=temp;

	}

    public static void printArray(int[] fishes){

        for(int i:fishes)
            System.out.print(i+" ");
        
        System.out.println();
    }
    }

