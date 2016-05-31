package net.fauxpark.jisho.util;

import java.io.File;

import android.content.Context;

public class DatabaseUtil {
    public static boolean makeDirs(String path) {
        File file = new File(path);

        return file.isDirectory() || file.mkdirs();
    }

    public static String getDatabasePath(Context context) {
        return context.getDatabasePath("jisho.db").getParent() + "/";
    }
}
