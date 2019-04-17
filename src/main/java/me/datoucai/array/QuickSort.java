package me.datoucai.array;

public class QuickSort {

    public static void main(String[] args) {
        int[] A = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

        quickSort(A, 0, 9);

        for (int i : A) {

            System.out.print(i);
        }
    }

    /**
     * <p>@MethodName : quickSort</p>
     * <p>@Description: 进行快速排序</p>
     *
     * @param : @param A
     * @return
     * @date : 2016年7月18日 ,下午7:19:20
     * @Version : vx.x
     */
    public static void quickSort(int[] A, int startIdx, int endIdx) {
        int pivot;
        if (startIdx < endIdx) {
            pivot = partition(A, startIdx, endIdx); //将待排序数组一分为二，返回枢轴值pivot

            quickSort(A, startIdx, pivot - 1); //对于弟子表递归排序
            quickSort(A, pivot + 1, endIdx);  //对高子表递归排序
        }
    }


    /**
     * <p>@MethodName : partition</p>
     * <p>@Description: 获取枢轴值位置</p>
     *
     * @param : @param A 待排序数组
     * @param : @param startIdx 开始坐标
     * @param : @param endIdx 结束坐标
     * @param : @return  枢纽坐标位置
     * @date : 2016年7月18日 ,下午11:18:15
     * @Version : vx.x
     */
    public static int partition(int[] A, int startIdx, int endIdx) {
        int pivotkey;

        pivotkey = A[startIdx]; //这里用子表的第一个记录做枢轴记录

        while (startIdx < endIdx) {

            while (startIdx < endIdx && A[endIdx] >= pivotkey) { //此时pivotkey=A[startIdx]
                endIdx--;
            }
            swap(A, startIdx, endIdx);
            //pivotkey = A[endIdx]

            while (startIdx < endIdx && A[startIdx] <= pivotkey) {
                startIdx++;
            }
            swap(A, startIdx, endIdx); //pivotkey=A[startIdx]
        }
        return startIdx;

    }


    /**
     * <p>@MethodName : swap</p>
     * <p>@Description: 交换数组a,b位置的数据</p>
     *
     * @param : @param A
     * @param : @param a
     * @param : @param b
     * @date : 2016年7月18日 ,下午11:37:53
     * @Version : vx.x
     */
    static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

}