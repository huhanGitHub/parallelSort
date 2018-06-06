import java.util.LinkedList;

public class Sort_Serial {
//串行冒泡排序
    public int [] bubbleSort(int data[]){
        int n=data.length;
        if (n==0) return null;
        for (int i=0;i+1<n;i++)
            for (int j=0;j+1<n-i;j++){
                if (data[j]>data[j+1])
                    Util.swap(data,j,j+1);
            }
        Util.print(data);
        return data;
    }

//串行选择选择排序
    public int [] selectionSort(int data[]){
        int n=data.length;
        if (n==0) return null;
        int min;
        for (int i=0;i<n;i++){
            min=i;
            for (int j=i+1;j<n;j++){
                if(data[j]<min) {
                    min=j;
                }
            }
            if (min!=i){
                Util.swap(data,i,min);
            }
        }
        Util.print(data);
        return data;
    }

    //串行插入排序
    public int [] insertSort(int data[]){
        int n=data.length;
        if (n==0) return null;
        int j,temp;
        for (int i=1;i<n;i++){
            j=i-1;
            temp=data[i];
            while (j>0 && temp<data[j]){
                data[j+1]=data[j];
                j--;
            }
            data[j+1]=temp;
        }
        Util.print(data);
        return data;
    }

    //希尔排序
    public int []shellSort(int[] data){
        int n=data.length;
        if (n==0) return null;
        int h=0;
        int j,temp;
        while (h<=n){
            h=3*h+1;
        }
        while (h>=1){
            for (int i=h;i<n;i++){
                j=i-h;
                temp=data[i];
                while (j<=0 && data[i]>temp){
                    data[j+h]=data[j];
                    j=j-h;
                }
                data[j+h]=temp;
            }
            h=(h-1)/3;
        }

        Util.print(data);
        return data;
    }


}
