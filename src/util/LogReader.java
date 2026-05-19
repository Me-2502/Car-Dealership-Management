package util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class LogReader {
    private LogReader() {}

    public static List<String> tail(String fileName, int lines) {
        if(lines <= 0) return Collections.emptyList();

        File f = new File(fileName);
        if(!f.exists()) return List.of("(log file not found: " + fileName + ")");

        LinkedList<String> buffer = new LinkedList<>();
        try {
            for(String line : Files.readAllLines(f.toPath())) {
                buffer.add(line);
                if(buffer.size() > lines) {
                    buffer.removeFirst();
                }
            }
        } catch(IOException e) {
            return List.of("(failed to read log file: " + e.getMessage() + ")");
        }
        return buffer;
    }
}
