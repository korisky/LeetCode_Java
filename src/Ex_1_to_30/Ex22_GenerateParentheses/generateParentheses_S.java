package Ex_1_to_30.Ex22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/*
By using recursion to find out all posible combinations
we got three situations :
                1. ( and ) 's number all equal to n, we need to record it
                2. ('s num equal to n, but we still get ), we need to parse all )
        IMP!!!  3. If ( and ) < n, then we can traverse by: left delete then right then delete
                    BUT, if current ( > ), which means: e.g. ()), ()()), we using ) more than (
                    which is incorrect, thus, we need : ( & ) > n && ( < )
 */

public class generateParentheses_S {
    private List<String> stores;
    public List<String> generateParenthesis(int n) {
        stores = new ArrayList<>();
        if (n > 0)
            pushBra(n, n, new StringBuffer());
        return stores;
    }
    public void pushBra(int leftRemaining, int rightRemaining, StringBuffer sb) {
        if (leftRemaining == 0 && rightRemaining == 0) {
            stores.add(sb.toString());
        } else if (leftRemaining == 0 && rightRemaining != 0) {
            pushBra(leftRemaining, rightRemaining - 1, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        } else if (leftRemaining != 0 && rightRemaining != 0 && leftRemaining <= rightRemaining) {
            pushBra(leftRemaining - 1, rightRemaining, sb.append("("));
            sb.deleteCharAt(sb.length() - 1);
            pushBra(leftRemaining, rightRemaining - 1, sb.append(")"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        generateParentheses_S use = new generateParentheses_S();
        List<String> results = use.generateParenthesis(1);
        for (String s : results)
            System.out.println(s);
    }
}
