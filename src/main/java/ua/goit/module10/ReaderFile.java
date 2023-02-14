package ua.goit.module10;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReaderFile {

    public static void main(String[] args) throws IOException {
        ReaderFile readerFile = new ReaderFile();

        readerFile.fileReader();
    }

    public void fileReader() throws IOException {
        String absolutePath = "/Users/andreyfilimonov21/Documents/GOIT/GOIT/module10/src/main/resources/file";
        String regex1 = "\\d{3}-\\d{3}-\\d{4}";
        String regex2 = "\\((\\d{3})\\)\\s\\d{3}-\\d{4}";

        File file = new File(absolutePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String phoneNumbers = bufferedReader.readLine();
        while (phoneNumbers != null) {
            Pattern pattern1 = Pattern.compile(regex1);
            Pattern pattern2 = Pattern.compile(regex2);
            Matcher matcher1 = pattern1.matcher(phoneNumbers);
            Matcher matcher2 = pattern2.matcher(phoneNumbers);

            if (matcher1.matches() || matcher2.matches()) {
                System.out.println(phoneNumbers);
            }
            phoneNumbers = bufferedReader.readLine();
        }
    }



}
