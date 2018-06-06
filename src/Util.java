public class Util {
    static void swap(int data[],int a,int b){
        int temp;
        temp=data[a];
        data[a]=data[b];
        data[b]=temp;
        //System.out.println(a+"--"+b);
    }

    static void print(int data[]){
        for (int i=0;i<data.length;i++)
            System.out.print(data[i]+" ");
        System.out.println();
    }


}
