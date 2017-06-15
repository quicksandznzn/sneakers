package sneakers.data.spider.util;

import java.io.File;

public class FileUtil {

    /**
     * 删除此路径名表示的文件或目录。 如果此路径名表示一个目录，
     * 
     * 则会先删除目录下的内容再将目录删除，
     * 
     * 所以该操作不是原子性的。 如果目录中还有目录，则会引发递归动作。
     * 
     * @param filePath 要删除文件或目录的路径。
     * @return 当且仅当成功删除文件或目录时，返回 true；否则返回 false。
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
                if (!deleteFile(deleteFile)) {// 如果是文件夹，则递归删除下面的文件后再删除该文件夹
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
