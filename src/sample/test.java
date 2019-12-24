package sample;

public class test {


    public static void main(String[] args) {
        System.out.println(maxNameLength());


    }
    static int maxNameLength() {
        String[] dataCenter={"ali","hosein","mohammad","abbas"};
        int max = 0;
        for (int j = 0; j < dataCenter.length; j++)
            if (dataCenter[j].length() > max)
                max = dataCenter[j].length();
        return max;
    }
        static String spaceGenerator(int n) {
        String str = "";
        while (n > 0) {
            str += " ";
        n--;}
        return str;
    }

    static double findThirdNumber() {
        double[] avreges = {1, 2, 3, 4, 5, 6};
//        for (int h = 0; h < i; h++)
        double first = avreges[0], second = Integer.MIN_VALUE,
                third = Integer.MIN_VALUE;


        for (int i = 1; i < avreges.length; i++) {
            /* If current element is greater than first,
        then update first, second and third */
            if (avreges[i] > first) {
                third = second;
                second = first;
                first = avreges[i];
            } /* If arr[i] is in between first and second */
            else if (avreges[i] > second) {
                third = second;
                second = avreges[i];
            } /* If arr[i] is in between second and third */
            else if (avreges[i] > third) {
                third = avreges[i];
            }
        }
//

        return third;
    }
}
