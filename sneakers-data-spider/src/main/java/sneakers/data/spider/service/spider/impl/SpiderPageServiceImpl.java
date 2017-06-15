package sneakers.data.spider.service.spider.impl;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import sneakers.common.api.model.PageInfo;
import sneakers.data.spider.service.spider.SpiderPageService;
import sneakers.data.spider.util.FileUtil;
import sneakers.data.spider.util.ImageUtil;

@Service
public class SpiderPageServiceImpl implements SpiderPageService {

    private static final Logger LOG = LoggerFactory.getLogger(SpiderPageServiceImpl.class);

    /**
     * html to pageinfo about
     */
    private static final String IMG_CLASS = "i_pic";
    private static final String IMG_TAG = "img";
    private static final String IMG_SRC = "src";
    private static final String IMG_REPLACE = "//";
    private static final String TITLE_CLASS = ".i_title";
    private static final String ITEMNUM_SELECT = ".i_introtext div:eq(0)";
    private static final String TITEMNUM_REPLACE = "货号:";
    private static final String RELEASEDATE_SELECT = ".i_introtext div:eq(1)";
    private static final String RELEASEDATE_REPLACE = "发布日期:";
    private static final String RELEASEPRICE_SELECT = ".i_introtext div:eq(2)";
    private static final String RELEASEPRICE_REPLACE = "发售价:";
    private static final String BLANK = "";
    private static final String FLIGHTCLUB_URL = "http://www.flightclub.cn";
    private static final String IMG_SUFFIX = ".jpg";
    private static final String URL_PREFIX = "http://";

    @Value("${img_save_path}")
    private String IMG_SAVE_PATH;

    /**
     * spider http://www.fightclub.cn
     */
    @Override
    public List<PageInfo> spiderFightClubReleasePage(String pageUrl) {
        List<PageInfo> pageInfoList = Lists.newArrayList();
        try {
            boolean flag = FileUtil.deleteFile(IMG_SAVE_PATH);
            Document document = Jsoup.connect(pageUrl).get();
            Elements elements = document.getElementsByClass("pitem");
            for (int i = 0; i < elements.size(); i++) {
                String id = UUID.randomUUID().toString();
                String itemNum = "";
                String releaseDate = "";
                String releasePrice = "";
                String title = elements.get(i).select(TITLE_CLASS).text();
                String imgPath = elements.get(i).getElementsByClass(IMG_CLASS).get(0)
                        .getElementsByTag(IMG_TAG).attr(IMG_SRC);
                imgPath = imgPath.replace(IMG_REPLACE, BLANK);
                imgPath = URL_PREFIX + imgPath;
                if (flag) {
                    ImageUtil.download(imgPath, title + IMG_SUFFIX, IMG_SAVE_PATH);
                }
                int divNum = elements.get(i).getElementsByClass("i_introtext").get(0)
                        .getElementsByTag("div").size();
                String jumpUrl = elements.get(i).select(TITLE_CLASS).get(0).getElementsByTag("a")
                        .attr("href");
                jumpUrl = FLIGHTCLUB_URL + jumpUrl;
                if (divNum == 4) {
                    itemNum = elements.get(i).select(ITEMNUM_SELECT).text();
                    itemNum = itemNum.replace(TITEMNUM_REPLACE, BLANK).trim();
                    releaseDate = elements.get(i).select(RELEASEDATE_SELECT).text();
                    releaseDate = releaseDate.replace(RELEASEDATE_REPLACE, BLANK).trim();
                    releasePrice = elements.get(i).select(RELEASEPRICE_SELECT).text();
                    releasePrice = releasePrice.replace(RELEASEPRICE_REPLACE, BLANK).trim();
                }
                pageInfoList.add(new PageInfo(id, title, itemNum, releaseDate, releasePrice,
                        imgPath, pageUrl, jumpUrl));
            }
        } catch (IOException e) {
            LOG.error("SPIDER FIGHTCLUBPAGE INTERFACE ERROR ========", e);
        }
        return pageInfoList;
    }

}
