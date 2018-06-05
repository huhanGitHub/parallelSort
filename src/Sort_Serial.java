public class Sort_Serial {



    public int [] bubbleSort(int data[]){
        int n=data.length;
        for (int i=0;i+1<n;i++)
            for (int j=0;j+1<n-i;j++){
                if (data[j]>data[j+1])
                    Util.swap(data,j,j+1);
            }
        Util.print(data);
        return data;
    }




}
