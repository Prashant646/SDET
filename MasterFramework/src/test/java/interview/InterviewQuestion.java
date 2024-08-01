package interview;

import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.Test;
import org.testng.collections.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewQuestion {


    @Test
    public void reverseArray() {

        int[] inputArr = new int[]{1, 3, 5, 7, 8, 9};
        int length = inputArr.length;

        //To reverse an array
        for (int i = 0; i <= length / 2; i++) {
            int temp = inputArr[i];
            inputArr[i] = inputArr[length - 1];
            inputArr[length - 1] = temp;
            length--;
        }
        for (int o : inputArr) {
            System.out.println(o);
        }
    }

    @Test
    public void fileWordReverse() throws IOException {

        String filePath = System.getProperty("user.dir") + File.separator + "WordCount.txt";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            if (CollectionUtils.hasElements(lines)) {

                for (String line : lines) {
                    String[] words = line.split(" ");
                    String revString = "";
                    for (int i = words.length - 1; i >= 0; i--) {
                        revString += words[i] + " ";
                    }
                    System.out.println(revString.trim());

                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read for the file", e);
        }
    }

    @Test
    public void testCodesForInterview() {
        String arr[] = new String[]{"Prashant", "Prabhat", "Pran", "Pranshu"};
        System.out.println(longestCommonPrefix(arr));
    }

    @Test
    public void streamApiInDepth() {

        //Prashant , Prabhat , Prakash
        //Streams enable us to perform operations like filtering , mapping , reducing and Sorting
        int[] a1 = new int[]{1, 2, 3, 4, 5};
        int[] a2 = new int[]{1, 4, 7, 8, 9, 10};

        OptionalInt maxInt = Arrays.stream(a1).max();
        System.out.println(maxInt.getAsInt());
    }

    private String longestCommonPrefix(String[] array) {
        String longestCommonString = array[0];
        for (String s : array) {
            while (s.indexOf(longestCommonString) != 0) {
                longestCommonString = longestCommonString.substring(0, longestCommonString.length() - 1);
                if (longestCommonString.isEmpty()) {
                    return "-1";
                }
            }
        }
        return longestCommonString;
    }

    private boolean isPallan(String str) {

        if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String cannot be null or empty");
        }

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {

            if (!(str.charAt(start) == str.charAt(end))) {
                return false;
            }
            start++;
            end--;

        }
        return true;
    }

    private int secondMaxOfArray(int arr[]) {

        int length = arr.length;

        if (length == 0) {
            throw new IllegalArgumentException("Null or empty array");
        }

        if (length == 1) {
            return arr[0];
        }

        int max = arr[0];
        int secondMax = arr[1];

        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];
            if (max < num) {
                secondMax = max;
                max = num;
            }
            if (num < max && num > secondMax) {
                secondMax = num;
            }

        }
        return secondMax;
    }


    public static void swapVariables(int a, int b) {
        System.out.println("Before swapping: a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After swapping: a = " + a + ", b = " + b);
    }

    /**
     * @param s1
     * @param s2
     * @return
     */
    public boolean isAnagram(String s1, String s2) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        char[] charArr = s1.toCharArray();

        for (char c : charArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return true;
    }

    public String removeDuplicates(String s) {

        Set<Character> set = new HashSet<>();
        String withoutDups = "";

        for (int i = 0; i < s.length(); i++) {

            if (set.add(s.charAt(i))) {
                withoutDups += s.charAt(i);
            }
        }
        return withoutDups;
    }

    public static int[] findTwoSum(int[] array, int target) {
        // HashMap to store the number and its index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = target - array[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Store the index of the current element in the map
            map.put(array[i], i);
        }

        // If no pair is found, return null
        return null;
    }


    public int longestSubWORepeatingChars(String str) {

        int maxLength = 0;
        //Prashant
        for (int i = 0; i < str.length(); i++) {
            StringBuilder currentSubstring = new StringBuilder();
            for (int j = i; j < str.length(); j++) {
                if ((currentSubstring.indexOf(String.valueOf(str.charAt(j))) != -1)) {
                    break;
                }
                currentSubstring.append(str.charAt(j));
                maxLength = Math.max(maxLength, currentSubstring.length());
            }
        }
        return maxLength;
    }

    private static int minDistanceBtwNumbers(int[] array, int a, int b) {

        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (!(hashmap.containsKey(array[i]))) {
                hashmap.put(array[i], i);
            }
        }

        if (!hashmap.containsKey(a) || !hashmap.containsKey(b)) {
            return -1;
        }
        int diff = hashmap.get(a) - hashmap.get(b);
        if (diff < 0) {
            return -diff;
        }
        return diff;
    }

    public String gcdOfStrings(String str1, String str2) {

        if (str1.equals(str2)) {
            return str1;
        }

        int length1 = str1.length();
        int length2 = str2.length();

        if (length2 > length1) {
            return gcdOfStrings(str2, str1);
        }

        if (!str1.startsWith(str2)) {
            return "";
        }

        return gcdOfStrings(str1.substring(str2.length()), str2);
    }

    private String longestRepeatingSubstring(String str) {
        String longestRepeating = "";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String subString = str.substring(i, j);
                int lenghtCurrentSubs = subString.length();
                if (str.indexOf(subString) != str.lastIndexOf(subString) && lenghtCurrentSubs > longestRepeating.length()) {
                    longestRepeating = subString;
                }
            }
        }
        return longestRepeating;
    }

    private String reverseVowels(String str) {
        return "";
    }

    private static Character secondMostFrequent(String str) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            charMap.put(str.charAt(i), charMap.getOrDefault(str.charAt(i), 0) + 1);
        }

        Character firstCharacter = str.charAt(0);
        Character secondCharcater = str.charAt(0);
        int firstFreq = 0;
        int secondFreq = 0;

        for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
            int i = entry.getValue();
            if (firstFreq < i) {
                secondCharcater = firstCharacter;
                secondFreq = firstFreq;
                firstFreq = i;
                firstCharacter = entry.getKey();
            } else if (i > secondFreq && entry.getKey() != firstCharacter) {
                secondFreq = i;
                secondCharcater = entry.getKey();
            }
        }
        return secondCharcater;
    }

    private static void secondMostFrequent2(String str) {
        int noc = 256;
        int[] count = new int[noc];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
    }

    private void sortStrings(String[] strArr) {
        String s1 = "P";
        String s2 = "S";

        System.out.println(s1.compareTo(s2));
    }

    private static String removeStars(String str) {
        //leet**cod*e
        char[] charArr = str.toCharArray();
        String newString = "";

        for (int i = 0; i < charArr.length - 1; i++) {
            if (charArr[i] == '*') {
                i = i + 1;
            } else if (charArr[i + 1] == '*') {
                i = i + 1;
            } else {
                newString += charArr[i];
            }
        }
        return newString;
    }

    private static String removeStars1(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i)) == '*' && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }

        }
        String finalString = "";
        for (Character chr : stack) {
            finalString += chr;
        }
        return finalString;
    }

    private static void fibonacciUptoGivenNumber(int number) {
        // 0 , 1 , 1, 2 , 3 , 5

        int first = 0, second = 1, next;

        for (int i = 0; i <= number; i++) {
            System.out.print(first + " ");
            next = first + second;
            first = second;
            second = next;
        }
    }

    public static void bubbleSort(int[] arr) {
        boolean swap;
        for (int i = 0; i < arr.length - 1; i++) {
            swap = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    public static List<String> generateCombinations(String str) {
        List<String> combinations = new ArrayList<>();
        generateCombinationsHelper("", str, 0, combinations);
        return combinations;
    }

    private static void generateCombinationsHelper(String prefix, String str, int start, List<String> combinations) {
        int n = str.length();
        for (int i = start; i < n; i++) {
            combinations.add(prefix + str.charAt(i));
            generateCombinationsHelper(prefix + str.charAt(i), str, i + 1, combinations);
        }
    }

    private String wordCountInString(String str, String word) {
        return null;
    }


}

