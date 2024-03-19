package git.chdeepakkumar;

import git.chdeepakkumar.exception.InvalidFileException;
import lombok.Builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

@Builder
public class CsvReader {

    File csvFile;

    private static final String CSV = "csv";
    private CsvReader() {}

    public void loadCsv(File csvFile) throws InvalidFileException {
        if(!csvFile.exists())
            throw new InvalidFileException("File does not exist");
        if (csvFile.isDirectory())
            throw new InvalidFileException("Not a file");
        if(!isCsvFile(csvFile))
            throw new InvalidFileException("Not a CSV file");
        this.csvFile = csvFile;
    }

    public void loadCsv(String filePath) throws InvalidFileException {
        File csvFile = new File(filePath);
        loadCsv(csvFile);
    }

    public static String getFileExtension(File file) {
        if(!file.exists())
            return null;
        if (file.isDirectory())
            return null;
        String filePath = file.getAbsolutePath();
        return getFileExtension(filePath);
    }

    public static String getFileExtension(String filePath) {
        int lastDotIndex = filePath.lastIndexOf(".");
        if (lastDotIndex == -1)
            return null;
        return filePath.substring(lastDotIndex+1);
    }

    public static boolean isCsvFile(File file) {
        return Objects.equals(getFileExtension(file), CSV);
    }

    public static boolean isCsvFile(String filePath) {
        return Objects.equals(getFileExtension(filePath), CSV);
    }

    public void read() throws IOException {
        FileReader fileReader = new FileReader(this.csvFile);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (Objects.nonNull(line)) {

        }
    }
}
