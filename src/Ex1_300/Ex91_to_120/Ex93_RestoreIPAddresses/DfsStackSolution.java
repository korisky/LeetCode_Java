package Ex1_300.Ex91_to_120.Ex93_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 用Stack来替代List, 但发现实际运行时间会慢一些, 可能是因为引入了Stack包导致
 */
public class DfsStackSolution {

    public List<String> restoreIpAddresses(String s) {
        Stack<String> curSlots = new Stack<>();
        List<String> results = new ArrayList<>();

        dfs(s, 0, curSlots, results);

        return results;
    }

    private void dfs(String totalStr, int curIndex, Stack<String> curSlots, List<String> allResults) {
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
            curSlots.push(chosenSlot);
            // doing dfs
            dfs(totalStr, i + 1, curSlots, allResults);
            // remove last chosen
            curSlots.pop();
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


