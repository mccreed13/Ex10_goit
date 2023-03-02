import java.io.FileInputStream;
import java.io.IOException;

public class PhoneReader {
    public static void phoneOutput(String fileName) throws IOException {
        try(FileInputStream fileInputStream = new FileInputStream(fileName)) {
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < buffer.length; i++) {
                stringBuilder.append((char) buffer[i]);
                if(buffer[i] == '\n' || i+1==buffer.length){
                    String number = stringBuilder.toString();
                    if(isValidMobileNo(number)){
                        System.out.println(number.trim());
                    }
                    stringBuilder.setLength(0);
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private static boolean isValidMobileNo(String str) {
        String s = str.trim();
        return (s.matches("[(]\\d{3}[)]\\s\\d{3}-\\d{4}") || s.matches("\\d{3}-\\d{3}-\\d{4}"));
    }
}
