import java.util.Random;

public class Util {
    static void swap(int data[],int a,int b){
        int temp;
        temp=data[a];
        data[a]=data[b];
        data[b]=temp;
        //System.out.println(a+"--"+b);
    }

    static void print(int data[],long beginMillis,String name){
//        for (int i=0;i<data.length;i++)
//            System.out.print(data[i]+" ");
//        System.out.println();

        long endMillis=System.currentTimeMillis();
        long used=endMillis-beginMillis;
        System.out.println(name+": "+used);
    }

    static int[] getRandomData(int length){
        int[] data=new int[length];
        Random random=new Random(System.currentTimeMillis());
        for (int i=0;i<length;i++){
            data[i]=random.nextInt();
        }
        return data;
    }



}
