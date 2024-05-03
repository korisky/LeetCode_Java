package Ex1_300.Ex151_to_180.Ex165_CompareVersionNumbers;

public class AnotherSol {

    /**
     * 版本号对比
     */
    public static int compareVersion(String version1, String version2) {

        String[] v1Arr = version1.split("\\.");
        String[] v2Arr = version2.split("\\.");

        int v1Idx = 0;
        int v2Idx = 0;

        // 第一轮判断
        while (v1Idx < v1Arr.length && v2Idx < v2Arr.length) {
            int v1Num = Integer.parseInt(v1Arr[v1Idx++]);
            int v2Num = Integer.parseInt(v2Arr[v2Idx++]);
            if (v1Num != v2Num) {
                return v1Num - v2Num > 0 ? 1 : -1;
            }
        }

        // 长度不一致/仍无法对比
        while (v1Idx < v1Arr.length) {
            int v1Num = Integer.parseInt(v1Arr[v1Idx]);
            if (v1Num > 0) {
                return 1;
            } else {
                v1Idx++;
            }
        }

        while (v2Idx < v2Arr.length) {
            int v2Num = Integer.parseInt(v2Arr[v2Idx]);
            if (v2Num > 0) {
                return -1;
            } else {
                v2Idx++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(compareVersion("1.0.1", "1.0.2"));
//        System.out.println(compareVersion("1.2.1", "1.1.9"));
//        System.out.println(compareVersion("1.0.1", "1.0.1"));
//        System.out.println(compareVersion("1.0", "1.0.2"));
//        System.out.println(compareVersion("1.0", "1.0.0"));
        System.out.println(compareVersion("1.05", "1.1"));
    }
}
