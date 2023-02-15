package ua.goit.module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordsCounter {

    public static void main(String[] args) throws IOException {
        File inputFile = new File("src/main/resources/file");

        FileReader fileReader = new FileReader(inputFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuilder stringBuilder = new StringBuilder();
        String str = bufferedReader.readLine();
        while (str != null) {
            stringBuilder.append(str);
            stringBuilder.append(" ");
            str = bufferedReader.readLine();
        }

        String strFromStrBuilder = stringBuilder.toString();
        String[] words = strFromStrBuilder.split(" ");
        HashMap<String, Integer> result = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String equalWord = words[i];
            int counter = 0;
            for (int j = 0; j< words.length; j++) {
                if (equalWord.equals(words[j])) {
                    counter++;
                }
            }
            result.put(equalWord, counter);
        }
        Stream<Entry<String,Integer>> sorted = result.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        sorted.forEach(System.out::println);
    }
}

