package Extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/*
IMP: if we return String.valueOf(char[]), that is something we can 'see'
       But if we return char[].toString, that would be an address.
 */

public class Permutations {

    public ArrayList<String> allPerm;

    public ArrayList<String> getAllPermutations(String str) {
        if (str == null || str == "" || str.length() == 0)
            return null;
        allPerm = new ArrayList<>();
        permutationsRuning(str, 0, str.length() - 1);
        return allPerm;
    }

    public void permutationsRuning(String str, int left, int right) {
        if (left == right) {
            allPerm.add(str);
        } else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i); // swap each possible ele with current ele
                permutationsRuning(str, left + 1, right); // keep finding possible swaps
                str = swap(str, left, i); // after the 'dfs', we need tp swap back to original
            }
        }
    }

    public String swap(String str, int i, int j) {
        char[] chaStr = str.toCharArray();
        char temp = chaStr[i];
        chaStr[i] = chaStr[j];
        chaStr[j] = temp;
        return String.valueOf(chaStr);
    }

    // here is trying to get permutation of Arrays / Lists
    private ArrayList<String> listComb = new ArrayList<>();
    public void getPermutations_List(List<String> strList, int left, int right) {
        if (left == right) {
            String onePermu = "";
            for (String s : strList)
                onePermu += s;
            listComb.add(onePermu);
        } else {
            for (int i = left; i <= right; i++) {
                Collections.swap(strList, left, i);
                getPermutations_List(strList, left + 1, right);
                Collections.swap(strList, left, i);
            }
        }
    }

    public ArrayList<String> getPerList_Calling(List<String> strList){
        getPermutations_List(strList, 0, strList.size() - 1);
        return listComb;
    }


    public static void main(String[] args) {
        Permutations test = new Permutations();

        String perList_1 = "ABC";
        String perList_2 = "t2";
        String perList_3 = "604";
        List<String> listInput = new ArrayList<>();
        listInput.add(perList_1);
        listInput.add(perList_2);
        listInput.add(perList_3);
        ArrayList<String> listResults = test.getPerList_Calling(listInput);
        for (int i = 0; i < listResults.size(); i++)
            System.out.println(listResults.get(i));

    }
}
