package utils;

import java.io.*;

public class JsonToStringUtil {
    public static String readFileAsString(String filePath) {
        String fileName = System.getProperty("user.dir") + filePath;
        String fileAsString = null;
        try {
            fileAsString = readConfigFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return fileAsString;
    }

    private static String readConfigFile(String fileName) throws IOException {
        InputStream is = new FileInputStream(fileName);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        String fileAsString = sb.toString();


        return fileAsString;
    }
}
