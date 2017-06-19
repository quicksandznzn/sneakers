package sneakers.common.api.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName = "sneakers_index")
public class PageInfo implements Serializable {

    private static final long serialVersionUID = 7906071656568524724L;

    public PageInfo() {}

    public PageInfo(String id, String title, String itemNum, String releaseDate,
            String releasePrice, String imgPath, String pageUrl, String jumpUrl) {
        super();
        this.id = id;
        this.title = title;
        this.itemNum = itemNum;
        this.releaseDate = releaseDate;
        this.releasePrice = releasePrice;
        this.imgPath = imgPath;
        this.pageUrl = pageUrl;
        this.jumpUrl = jumpUrl;
    }

    private @Id @Indexed String id;

    private @Indexed String title;

    private @Indexed String itemNum;

    private @Indexed String releaseDate;

    private @Indexed String releasePrice;

    private @Indexed String imgPath;

    private @Indexed String pageUrl;

    private @Indexed String jumpUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getItemNum() {
        return itemNum;
    }

    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleasePrice() {
        return releasePrice;
    }

    public void setReleasePrice(String releasePrice) {
        this.releasePrice = releasePrice;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJumpUrl() {
        return jumpUrl;
    }

    public void setJumpUrl(String jumpUrl) {
        this.jumpUrl = jumpUrl;
    }

}
