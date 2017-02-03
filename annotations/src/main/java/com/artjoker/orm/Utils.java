package com.artjoker.orm;


public class Utils {
    
    public static String separateWords(String words, String separator) {

        String[] r = words.split("(?=\\p{Lu})");
        StringBuilder ds = new StringBuilder();
        boolean first = false;
        for (String s : r) {
            if (first) {
                ds.append(separator);
            } else {
                first = true;
            }
            ds.append(s.toLowerCase());
        }
        return ds.toString();
    }

}
