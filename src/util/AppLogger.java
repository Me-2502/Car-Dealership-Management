package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Lightweight file logger (no frameworks).
 * Appends to dealership.log in the project working directory.
 */
public final class AppLogger {
    private static final Object LOCK = new Object();
    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final String LOG_FILE = "dealership.log";

    private AppLogger() {}

    public enum Level {
        INFO,
        WARN,
        ERROR
    }

    public static void info(String message) {
        log(Level.INFO, message);
    }

    public static void warn(String message) {
        log(Level.WARN, message);
    }

    public static void error(String message) {
        log(Level.ERROR, message);
    }

    public static void log(Level level, String message) {
        String line = String.format("%s [%s] %s", LocalDateTime.now().format(TS), level, message);
        synchronized(LOCK) {
            try(PrintWriter out = new PrintWriter(new FileWriter(new File(LOG_FILE), true))) {
                out.println(line);
            } catch(IOException ignored) {
                // Keep console app resilient: don't crash because logging failed.
            }
        }
    }
}
