package sneakers.data.spider.util;

import java.io.File;

public class FileUtil {

    /**
     * @param filePath
     * @return boolean
     */
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return deleteFile(file);
    }

    private static boolean deleteFile(File file) {
        File[] files = file.listFiles();
        if (files == null) {
            return Boolean.TRUE;
        }
        for (File deleteFile : files) {
            if (deleteFile.isDirectory()) {
                if (!deleteFile(deleteFile)) {// if this is file deleteFile
                    return Boolean.FALSE;
                }
            } else {
                if (!deleteFile.delete()) {
                    return Boolean.FALSE;
                }
            }
        }
        return file.delete();
    }

}
