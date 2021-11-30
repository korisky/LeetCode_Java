package Ex300_LongestIncreasingSubsequence;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 */
public class PatientSortSolution {

    class PointingNode {
        int val;
        PointingNode preLessNode;

        public PointingNode(int val, PointingNode preLessNode) {
            this.val = val;
            this.preLessNode = preLessNode;
        }
    }


    public int lengthOfLIS(int[] nums) {
        ArrayList<LinkedList<PointingNode>> pileList = new ArrayList<>();
        // Step A: build up all piles, left -> right
        for (int num : nums) {
            // each loop, should looking from left pile to right
            int pileIdx = 0;
            // travel all piles to find right position to this nums[i]
            while (true) {
                // A1. do initialization for each new pile
                if (pileIdx > pileList.size() - 1) {
                    pileList.add(new LinkedList<>());
                }
                // A2. get the pile
                LinkedList<PointingNode> curPile = pileList.get(pileIdx);
                // A3. when pile is empty, or curPile's first val > nums[i],
                // we still adding cur nums[i] as the first node of this pile
                if (curPile.isEmpty() || curPile.getFirst().val > num) {
                    // construct new node
                    PointingNode pre = null;
                    // if we have last pile, we need to do traverse
                    if (pileIdx > 0) {
                        // travel from tail to head, find the first just < than cur num
                        LinkedList<PointingNode> lastPile = pileList.get(pileIdx - 1);
                        for (int i = lastPile.size() - 1; i >= 0; i--) {
                            PointingNode lastPileNode = lastPile.get(i);
                            if (lastPileNode.val < num) {
                                pre = lastPileNode;
                                break;
                            }
                        }
                    }
                    curPile.addFirst(new PointingNode(num, pre));
                    break;
                } else {
                    // A4. if cur piles's first node's val < nums[i], means nums[i] should be put into next pile,
                    // can just pileIdx + 1 to move forward
                    pileIdx++;
                }
            }
        }

        // Step B: find longest decreasing sub-str, right -> left
        int maxLen = 0;
        for (int pileIdx = pileList.size() - 1; pileIdx >= 0; pileIdx--) {
            LinkedList<PointingNode> curPile = pileList.get(pileIdx);
            for (PointingNode node : curPile) {
                int sinLen = 1;
                while (node.preLessNode != null) {
                    sinLen++;
                    node = node.preLessNode;
                }
                maxLen = Math.max(maxLen, sinLen);
            }
        }

        // return max length of increasing sub-str
        return maxLen;
    }

    public static void main(String[] args) {
        PatientSortSolution s = new PatientSortSolution();
        int[] test = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(s.lengthOfLIS(test));
    }
}
