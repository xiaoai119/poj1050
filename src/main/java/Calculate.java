import java.util.Arrays;

/**
 * Created By xfj on 2018/10/27
 */
public class Calculate {
    public static int solve(int[][]data,int size){
        int max=Integer.MIN_VALUE;
        for(int index1=1;index1<=size;index1++){
            //index1表示选取矩阵的行数
            for(int rowStart=0;rowStart<size-index1+1;rowStart++){
                int[] rowSum=new int[size];
                int rowEnd=rowStart+index1-1;
                for(int index2=rowStart;index2<=rowEnd;index2++){
                    for(int index3=0;index3<size;index3++){
                        rowSum[index3]+=data[index2][index3];
                    }
                }
                int maxValue = getMaxValue(rowSum);
                if(max<maxValue){max=maxValue;}
            }
        }
        return max;
    }

    private static int getMaxValue(int[] rowSum) {
        int[]maxValue=new int[rowSum.length];
        maxValue[0]=rowSum[0];
        for(int i=1;i<rowSum.length;i++){
            maxValue[i]=Math.max(rowSum[i],maxValue[i-1]+rowSum[i]);
        }
        return Arrays.stream(maxValue).max().getAsInt();
    }
}

