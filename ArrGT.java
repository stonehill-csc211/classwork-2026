public class ArrGT {

    public static double[] arrGT(double[] arr, double t){
        double[] retval = new double[arr.length];
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > t){
                retval[j] = arr[i];
                j++;
            }
        }
        double[] retval2 = new double[j];
        for(int i = 0; i < j; i++){
            retval2[i] = retval[i];
        }
        return retval2;
    }

    public static void main(String[] args){
        double[] example = {2, 4, 6, 3, 1};
        double t = 3;
        double[] result = arrGT(example, 3);
        for(double d : result){
            System.out.println(d);
        }
    }

}