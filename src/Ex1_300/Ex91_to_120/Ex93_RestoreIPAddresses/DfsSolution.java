package Ex1_300.Ex91_to_120.Ex93_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * 用dfs的思想来实现可能的ip地址搜索, 主要思想就是, 每次都通过curIndex作为目前这一位slot的取值开头,
 * 其中for循环去进行从这个index往后取, 取一位, 两位, 三位这样. 每次取的时候首先进行validate确认合法,
 * 当发现合法了, 那就加入slot存储到临时list中, 然后dfs选择当前index+i的位置作为下一个的开头, 需要注意的是,
 * 这里递归回来要移除上一次传进去的内容(那个临时slot)
 *
 * 而当我们递归dfs时, 如果slot的层数已经大于4, 已经不是合法的ip地址了, 终止遍历返回
 * 而一旦当前index已经到达length, 并且slot层数刚好是4, 就是我们需要记录下来的内容
 */
public class DfsSolution {

    public List<String> restoreIpAddresses(String s) {
        List<String> curSlots = new ArrayList<>();
        List<String> results = new ArrayList<>();

        dfs(s, 0, curSlots, results);

        return results;
    }

    private void dfs(String totalStr, int curIndex, List<String> curSlots, List<String> allResults) {
        // reach end of input Str, record valid ip address
        if (totalStr.length() == curIndex && 4 == curSlots.size()) {
            StringBuilder sb = new StringBuilder();
            for (String curSlot : curSlots) {
                sb.append(".").append(curSlot);
            }
            allResults.add(sb.substring(1));
        }
        if (4 == curSlots.size()) {
            // have 4 slot, but not totally using the input string
            return;
        }
        for (int i = curIndex; i < totalStr.length(); i++) {
            // possible slot selection
            String chosenSlot = totalStr.substring(curIndex, i + 1);
            // only when the chosen slot is a valid number
            if (!isValid(chosenSlot)) {
                return;
            }
            // add success slot
            curSlots.add(chosenSlot);
            // doing dfs
            dfs(totalStr, i + 1, curSlots, allResults);
            // remove last chosen
            curSlots.remove(curSlots.size() - 1);
        }
    }

    private boolean isValid(String numStr) {
        if ("".equals(numStr)) {
            return false;
        }
        int parsedNum = Integer.parseInt(numStr);
        if (parsedNum > 255
                || (parsedNum != 0 && numStr.startsWith("0"))
                || (parsedNum == 0 && !"0".equals(numStr))) {
            return false;
        }
        return true;
    }

}


