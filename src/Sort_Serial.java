class Sort_Serial {
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
        for (int i=0;i<n-1;i++){
            min=i;
            for (int j=i+1;j<n;j++){
                if(data[j]<data[min]) {
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
            while (j>=0 && temp<data[j]){
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
                while (j>=0 && data[i]>temp){
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

    //MergeSort
    private void merge(int[] data,int left,int mid,int right){
        int n=mid-left+1;
        int m=right-mid;
        int []merge=new int[n+m];
        int i=left,j=mid+1,k=0;
        while ( i<=mid  && j<=right){
            if (data[i]<=data[j]){
                merge[k]=data[i];
                k++;
                i++;
            }else{
                merge[k]=data[j];
                k++;
                j++;
            }
        }
        while (i<=mid){
            merge[k]=data[i];
            k++;
            i++;
        }
        while (j<=right){
            merge[k]=data[j];
            k++;
            j++;
        }

        for (int ii=0;ii<m+n;ii++){
            data[left]=merge[ii];
            left++;
        }
    }

    private void mergeAll(int[]data,int left,int right){
        if (left==right) return;
        int mid=(left+right)/2;
        mergeAll(data,left,mid);
        mergeAll(data,mid+1,right);
        merge(data,left,mid,right);
    }

    public int[] mergeSort(int []data){
        int left=0;
        int right=data.length-1;
        mergeAll(data,left,right);
        Util.print(data);
        return data;
    }



}
