import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        PhoneReader.phoneOutput("file.txt");
        UserCreator.createUserJson("file2.txt");
        WordCounter.count("words.txt");
    }
}
