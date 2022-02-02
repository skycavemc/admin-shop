package de.leonheuer.skycave.adminshop.utils;

public class ArrayUtils {

    /**
     * Searches the string array for matches and replaces every of them.
     * @param strings The string array
     * @param regex The regex used for searching matches
     * @param replacement The replacement
     * @return The string array with the altered strings
     */
    public static String[] replaceAll(String[] strings, String regex, String replacement) {
        String[] output = new String[strings.length];
        for (int i = 0; i < strings.length; i++) {
            output[i] = strings[i].replaceAll(regex, replacement);
        }
        return output;
    }

}
