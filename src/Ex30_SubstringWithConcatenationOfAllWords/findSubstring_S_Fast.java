package Ex30_SubstringWithConcatenationOfAllWords;

import java.util.*;

/*
Instead of counting all possible permutations of WORDS,
we can count frequency of each word, and check whether word's length substring
in s, appear in WORDS or not
 */


public class findSubstring_S_Fast {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0 || s.length() == 0 || s == "")
            return new ArrayList<>();

        int strLen = s.length();
        int listLen = words.length;
        int wordLen = words[0].length();

        if (strLen < listLen * wordLen)
            return new ArrayList<>(); // if word's total len already greater than strLen

        HashMap<String, Integer> listContain = new HashMap<>();
        for (String curStr : words) {
            // here use getOrDefault, we can reduce: if (list.contains.... then....)
            // remember to +1
            listContain.put(curStr, listContain.getOrDefault(curStr, 0) + 1);
        }

        List<Integer> validIndexs = new ArrayList<>();
        for (int i = 0; i < wordLen; i++) {
            // think about we have s: "ABCDEFG", words: "BC", "DE"
            // when we going to traverse: j = i, j < ... , j += wordLen
            // AB, CD, EF, G
            // BC, DE, FG,
            // we only need to traverse like this, won't skip any possible situation
            for (int j = i; j <= strLen - wordLen * listLen; j += wordLen) {
                // strlen - wordlen * listlen, we can think as: cur scanning from j -> j + wordLen * listLen
                // thus, if j > strLen - wordLen * listLen, we must have no enough remaining length for
                // whole length of words[]
                HashMap<String, Integer> strOccur = new HashMap<>();
                for (int numOfWord = listLen - 1; numOfWord >= 0; numOfWord--) {
                    // we try to compare current strings' frequency in s and words[] from decreasing order
                    // numOfWord means which number of word (in words[]) currently we are using
                    String subWordLenString = s.substring(j + numOfWord * wordLen, j + (numOfWord + 1) * wordLen);
                    // above line is to get word-Length string in s
                    // above line: record current what we meet
                    int curRealStringOccTime = strOccur.getOrDefault(subWordLenString, 0) + 1;
                    if (curRealStringOccTime > listContain.getOrDefault(subWordLenString, 0)) {
                        // two situations here, e.g.  1. we meet "BAC" but no "BAC" in words[]
                        // 2. we meet "BAC" >= 2, but only have 1 "BAC" in words[]
                        j += numOfWord * wordLen; // means, we can skip and start over at here
                        break;
                    }
                    // only it's not violate the above stuff, we can only add it into StrOccur
                    strOccur.put(subWordLenString, curRealStringOccTime);
                    if (numOfWord == 0) { // means cur substring of s, contains all ele in words[]
                        validIndexs.add(j);
                    }
                }
            }
        }
        return validIndexs;
    }

    public static void main(String[] args) {
        findSubstring_S_Fast use = new findSubstring_S_Fast();
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo", "bar"};
//        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
//        String[] words = new String[]{"dhvf", "sind", "ffsl", "yekr", "zwzq", "kpeo", "cila", "tfty", "modg", "ztjg", "ybty", "heqg", "cpwo", "gdcj", "lnle", "sefg", "vimw", "bxcb"};
        List<Integer> result = use.findSubstring(s, words);
        for (int i : result)
            System.out.println(i);
    }
}
