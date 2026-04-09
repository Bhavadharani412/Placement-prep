/*
[0, 1, 1, 1, 1, 1, 0, 0, 0]
ind         0 1 2 3 4 5 6 7 8 
num         0 1 1 1 1 1 0 0 0
zc          1 1 1 1 1 1 2 3 4
oc          0 1 2 3 4 5 5 5 5
diff        1 0 -1 -2 -3 -4 -3 -2 -1
 case i --> if all 1 diff will be size ( -9)
case ii --> if all 0 diff will be size ( +9)
so if I have an array of 2 * size then I can store them in the form of diff and index
if same repeats we can find length of subarray and keep the min index in arr

 */
import java.util.Arrays;
public class longest_subarr_equal_zeros_ones {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0};
        int size = arr.length;
        int max = 0;
        int[] diff = new int[2 * size + 1];
        Arrays.fill(diff, size + 1);
        diff[0] = -1;
        int zeroCount = 0;
        int oneCount = 0;
        for(int i : diff) i = -1;
        for(int i = 0; i < size; i++){
            if(arr[i] == 0) {
                zeroCount++;
            }
            else {
                oneCount++;
            }
            int d = zeroCount - oneCount;
            if(d < 0){
                d = -d;
                d = size + d;
            }
            if(diff[d] == -1){
                diff[d] = i;
            }
            else{
                int len = i - diff[d];
                if(len > max) max = len;

            }
        }
        System.out.println(max);
    }
}
