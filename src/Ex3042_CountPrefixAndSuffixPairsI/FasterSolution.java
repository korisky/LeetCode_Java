package Ex3042_CountPrefixAndSuffixPairsI;

public class FasterSolution {

    /**
     * 由于数据集原因, 直接选用内嵌循环速度会更快
     */
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String prefix = words[i];
            String suffix = words[i];

            for (int j = i + 1; j < words.length; j++) {
                if (words[j].startsWith(prefix) && words[j].endsWith(suffix)) {
                    count++;
                }
            }
        }
        return count;
    }
}
