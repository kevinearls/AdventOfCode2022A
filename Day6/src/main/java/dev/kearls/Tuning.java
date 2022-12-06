package dev.kearls;


public class Tuning {
    public boolean hasRepeatingCharacters(String s) {
        //System.out.println("---------- substrings -----");
        for (int i=0; i < s.length() - 1; i++) {
            //System.out.println(s.charAt(i) + ": " + s.substring(i + 1));
            String target = String.valueOf(s.charAt(i));
            String rest = s.substring(i+1);
            //System.out.println("Looking for [" + target + "] in [" + rest +"]");
            if (rest.contains(target)) {
                return true;
            }
        }
        return false;
    }

    public int findFirstMarker(String s, int size) {
        for (int i=0; i < s.length() - size + 1; i++) {
            String candidate = s.substring(i, i+size);
            //System.out.println(i + ": [" + candidate +"] " + hasRepeatingCharacters(candidate));
            if (!hasRepeatingCharacters(candidate)) {
                return i + size;
            }
        }
        return -1;
    }
}
