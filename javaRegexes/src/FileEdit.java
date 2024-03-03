import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class FileEdit {

    public static void Edit() {
        String filePath = "zad1Text.txt";

        String oldContent = "старо";
        String newContent = "novo";
        try {
            Path path = Paths.get(filePath);

            String content = Files.readString(path, StandardCharsets.UTF_8);

            String modifiedContent = content.replaceAll(Pattern.quote(oldContent), Matcher.quoteReplacement(newContent));

            Files.write(path, modifiedContent.getBytes(StandardCharsets.UTF_8));

            System.out.println("Faila e uspeshno redaktiran");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}