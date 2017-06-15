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
     * @param urlString url地址
     * @param filename 文件名
     * @param savePath 保存位置
     * @throws Exception
     */
    public static void download(String urlString, String filename, String savePath) {
        filename = filename.replace("/", "");
        filename = filename.replace(" ", "");
        OutputStream os = null;
        InputStream is = null;
        try {
            URL url = new URL(urlString);// 构造URL
            URLConnection con = url.openConnection();// 打开连接
            con.setConnectTimeout(5 * 1000); // 设置请求超时为5s
            con.setRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)"); // 防爬又如何 破解防爬
            is = con.getInputStream(); // 输入流
            byte[] bs = new byte[1024];// 1K的数据缓冲
            int len; // 读取到的数据长度

            File sf = new File(savePath); // 输出的文件流
            if (!sf.exists()) {
                sf.mkdirs();
            }
            os = new FileOutputStream(sf.getPath() + "/" + filename);

            while ((len = is.read(bs)) != -1) {// 开始读取
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
