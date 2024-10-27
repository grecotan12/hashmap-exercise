import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        int[] num1 = {1,2,3,4,5};
        int[] num2 = {0,2,4,6,8};
        System.out.println(intersection(num1, num2));

        String s = "abcdcef";
        String[] arr = s.split("");
        System.out.println(firstDub(arr));

        String b = "the quick brown box jumps over a lazy dog";
        System.out.println(oneLetter(b));

        System.out.println(firstNonDub("minimum"));
    }

    public static String firstNonDub(String s) {
        String[] arr = s.split("");
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String a : arr) {
            if (map.get(a) != null) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        for (String key : map.keySet()) {
            if (map.get(key) < 2) {
                list.add(key);
            }
        }
        return list.get(list.size()-1);
    }

    public static String oneLetter(String alphabet) {
        String a = "abcdefghijklmnopqrstuvwxyz";
        String[] arr = a.split("");
        String res = "";
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, null);
        }
        for (String b : alphabet.split("")) {
            map.put(b, true);
        }
        for (String c : map.keySet()) {
            if (map.get(c) == null) {
                res += c + ", ";
            }
        }
        return res;
    }

    public static ArrayList<String> firstDub(String[] arr) {
        HashMap<String, Boolean> map = new HashMap<>();
        ArrayList<String> arrL = new ArrayList<>();
        for (String s : arr) {
            if (map.get(s) != null) {
                arrL.add(s);
            } else {
                map.put(s, true);
;            }
        }
        return arrL;
    }

    public static List<Integer> intersection(int[] arr1, int[] arr2) {
        int[] larger;
        int[] smaller;
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        if (arr1.length < arr2.length) {
            smaller = arr1;
            larger = arr2;
        } else {
            larger = arr1;
            smaller = arr2;
        }
        for (int n : larger) {
            map.put(n, true);
        }
        for (int i = 0; i < smaller.length; i++) {
            if (map.get(smaller[i]) != null) {
                res.add(smaller[i]);
            }
        }
        return res;
    }
}