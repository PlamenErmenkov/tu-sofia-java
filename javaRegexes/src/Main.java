import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        //FileEdit.Edit();
//        zad1();
//        zad2();
//        zad5();
//        zad6();
//        zad7();
        zad8();
    }

    public static void zad1() {
        String filePath = "zad1Text.txt";
        String regex = "ново";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder originalFileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                originalFileContent.append(line).append("\n");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            Matcher matcher = pattern.matcher(originalFileContent);
            String modifiedContent = matcher.replaceAll("Novo");

            writer.write(modifiedContent);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidDate(String date){
        String regex = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);

        return matcher.matches();
    }

    private static void zad2(){
        try(BufferedReader reader = new BufferedReader(new FileReader("zad2Text.txt"))) {
            String line;

            while((line = reader.readLine()) != null){
                if(isValidDate(line)){
                    System.out.println(line + " correct");
                } else {
                    System.out.println(line + " incorrect");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, String> readConfigFile(String filePath) throws FileNotFoundException {
        Map<String, String> configValues = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null){
                String[] parts = line.split("=");
                if(parts.length == 2){
                    configValues.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return configValues;
    }

    public static void zad3(){
        String filePath = "zad3Text.txt";
        try {
            Map<String, String> configValues = readConfigFile(filePath);

            for(Map.Entry<String, String> entry : configValues.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void zad4() {
        String filepath = "zad4Text.txt";
        String prefix = "[app]";

        try{
            ArrayList<String> wordsWithPrefix = findWordsWithPrefix(filepath, prefix);
            for(String word : wordsWithPrefix){
                System.out.println(word);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<String> findWordsWithPrefix(String filepath, String prefix) throws FileNotFoundException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            ArrayList<String> wordsWithPrefix = new ArrayList<>();
            String line;
            Pattern pattern = Pattern.compile("\\b" + prefix + "\\w*");

            while((line = reader.readLine()) != null){
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    wordsWithPrefix.add(line);
                }
            }

            return wordsWithPrefix;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void zad5(){
        String fileDirectory = "C:\\Users\\Plamen\\Documents\\GitHub\\javaRegexes";
        File folder = new File(fileDirectory);

        if(!folder.exists() || !folder.isDirectory()){
            System.out.println("No such file");
        }

        //System.out.println(Arrays.toString(folder.list()));
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("zad5Text.txt"))){
            for(String directory : folder.list()) writer.write(directory + "\n");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void zad6(){
        String regex = "ERROR";
        Pattern pattern = Pattern.compile(regex);

        try(BufferedReader reader = new BufferedReader(new FileReader("zad6Text.txt"))){
            String line;

            while ((line = reader.readLine()) != null){
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()){
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void zad7(){
        String regex = "\\b(?:https?|ftp):\\/\\/[-a-zA-Z0-9+&@#\\/=%~_|$?!:,.]*[-a-zA-Z0-9+&@#\\/=%~_|$]";
        Pattern pattern = Pattern.compile(regex);

        try(BufferedReader reader = new BufferedReader(new FileReader("zad7Text.txt"))){
            String line;
            Matcher matcher;

            while ((line = reader.readLine()) != null){
                matcher = pattern.matcher(line);
                while (matcher.find()){
                    System.out.println(matcher.group());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void zad8(){
        Map<String, Integer> wordCountMap = new HashMap<>();

        try(BufferedReader reader = new BufferedReader(new FileReader("zad8Text.txt"))){
            String line;

            while ((line = reader.readLine()) != null){
                String[] words = line.split("\\s+");

                for(String word : words){
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()){
            if(entry.getValue() > 1) System.out.println("Diplicated word: "+entry.getKey());
        }
    }
}
