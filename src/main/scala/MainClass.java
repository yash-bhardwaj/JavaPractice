import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {

        int []a = {3,2}, b = {3,4}, c = {2,2}, d = new int[2];

        d = findD(a, b, c);

        int steps = countStepsFromNtoZero(7);

        int[] nums = {13,35,21,26,22,8,40,50,59};

        int u = findUniq(nums);
        int p = countPrimes(nums);
        Integer []pair = findPerfectSumPair(nums, 60, 12);
        // tree level order traversal using queue
        // tree mirror sides -> hashmap

        /*
        * Find count of complete given word which can be created from a given sentence by using its characters.
        *  Similar to collage creation by using newspaper headlines.
            Example:
            Given sentence: "Everyday is a wonderful day"
            Given word: Day
            Output: 3
         */

        // convert the string to lower
        // directly find occurences of target word.tolowercase count and remove them
        // try make the word from given / try find the given char and remove
        // stack
        String string = "Everyday is a wonderful day";
        String word = "Day";

        //int noOcc = findWordCount(string.toLowerCase(), word.toLowerCase());
        System.out.println(pair[0] + " " + pair[1]);

    }

    private static Integer[] findPerfectSumPair(int[] songs, int timeLimit, int endThreshold) {
        Arrays.sort(songs);
        int givenSum = timeLimit - endThreshold;

        int left = 0, right = songs.length-1, sum = 0, i = 0;
        List<Integer[]> pairs = new ArrayList<>();

        while(left< right) {
            sum = songs[left] + songs[right];
            if(sum == givenSum) {
                pairs.add(new Integer[]{songs[left], songs[right]});
                i++;
                left++;
                right--;
            } else if (sum > givenSum) {
                right--;
            } else {
                left++;
            }
        }
        pairs.sort(Comparator.comparingInt(a -> a[0]));
        return pairs.get(0);
    }

    private static int countPrimes(int[] nums) {
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = i; i < nums.length; i++) {}

        }

        ZonedDateTime.parse(LocalDate.now().toString(), DateTimeFormatter.ISO_DATE);
        return count;

    }

    private static int findUniq(int[] nums) {
        /*Map<Integer, Integer> numbers = new HashMap<>();
        for (int i : nums) {
            if (numbers.containsKey(i)) {
                numbers.put(i, numbers.get(i)+1);
            } else numbers.put(i, 1);
        }
        return numbers.entrySet().stream()
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toList())
                .get(0)
                .getKey();*/
        int single = nums[0];
        for (int i = 1 ; i< nums.length; i++) {
            single = single ^ nums[i];
        }
        return single;
    }

    private static int countStepsFromNtoZero(int i) {
        int count = 0;
        while (i > 0) {
            i &= i-1;
            count++;
        }
        return count;
    }

    private static int[] findD(int[] a, int[] b, int[] c) {
        class Pair<K,V> {
            K key;
            V value;
            Pair(K k, V v) {
                key = k;
                value = v;
            }
        }
        int ac_x = a[0] + c[0] - b[0];
        int ac_y = a[1] + c[1] - b[1];
        int ab_x = a[0] + b[0] - c[0];
        int ab_y = a[1] + b[1] - c[1];
        int bc_x = b[0] + c[0] - a[0];
        int bc_y = b[1] + c[1] - a[1];
        List<Pair<Integer, Integer>> pairs = Arrays.asList(new Pair<>(ac_x, ac_y), new Pair<>(ab_x, ab_y), new Pair<>(bc_x, bc_y));
        pairs.sort(Comparator.comparingInt(m -> m.key));
        return new int[]{pairs.get(0).key, pairs.get(0).value};
    }

    private static int findWordCount(String string, String word) {
        String[] strings = string.split(" ");
        int totalWords = strings.length;
        strings = (String[]) Arrays.asList(strings).stream().filter(str -> str != word).toArray();
        int count = totalWords - strings.length;
        String currentStr;
        for (int i = 0; i < strings.length; i++) {
            currentStr = strings[i];
            if(currentStr.contains(word)) {
                strings[i] = currentStr.replace(word, "");
                count++;
            }
        }

        string = "";
        for (int i = 0; i < strings.length; i++) {
            string += strings[i];
        }

        for (int i = 0; i < word.length(); i++) {
            String s = word.charAt(i) + "";
            if (string.contains(s)) {
                string.replace(s, "");
            }
        }

        return count;
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        // find consecutive charaters > 1
        // init = 0
        // while(i  < steps)
        //  if(i== U) { i++} else { map.put(s.substring(init,i)); init = i; i++;}
        // for(map.entry entry : map) if(entry.value.length > 1) count++
        // UDDDUDUU
        int i = 0, init = 0, count = 0;
        int seaLevel = 0;
        Map<Integer, String> map = new HashMap<>();

        while (i < steps) {
            if (path.charAt(i) == 'D') {
                seaLevel -= 1;
            } else {
                seaLevel += 1;
                if(seaLevel == 0) {
                    count++;
                }
            }
            i++;
        }
        return count;
    }

    private int countDuplicateConsecutiveCharacterFrequency(int length, String str) {
        int i = 0, init = 0, count = 0;
        int seaLevel = 0;
        Map<Integer, String> map = new HashMap<>();

        while (i < length) {
            if (str.charAt(i) == 'D') {
                seaLevel -= 1;
            } else {
                seaLevel += 1;
                if(seaLevel == 0) {
                    String key = str.substring(init, i);
                    map.put(i, key);
                    init = i+1;
                }
            }
            i++;
        }
        return count;
    }

}
