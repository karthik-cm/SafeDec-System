package util;

import java.net.URL;

public class FileUtil {

    private FileUtil() { }

    public static URL getPathWithName(String name) {
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        return classLoader.getResource(name);
    }

}