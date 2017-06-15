package sneakers.data.spider.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 
     * @param urlString
     * @param filename
     * @param savePath
     * @throws Exception
     */
    public static void download(String urlString, String filename, String savePath) {
        filename = filename.replace("/", "");
        filename = filename.replace(" ", "");
        OutputStream os = null;
        InputStream is = null;
        try {
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();
            con.setConnectTimeout(5 * 1000);
            con.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)"); // haha
            is = con.getInputStream();
            byte[] bs = new byte[1024];// 1K data cache
            int len; // data length

            File sf = new File(savePath);
            if (!sf.exists()) {
                sf.mkdirs();
            }
            os = new FileOutputStream(sf.getPath() + "/" + filename);

            while ((len = is.read(bs)) != -1) {// read
                os.write(bs, 0, len);
            }
        } catch (Exception e) {
            LOG.error("IMAGEUTIL DOWNLOAD ERROR", e);
        } finally {
            try {
                os.close();
                is.close();
            } catch (IOException e) {
                LOG.error("IMAGEUTIL DOWNLOAD CLOSE ERROR", e);
            }
        }
    }

}
