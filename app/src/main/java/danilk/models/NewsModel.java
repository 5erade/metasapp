package danilk.models;

/**
 * Created by dan on 1/18/16.
 */
public class NewsModel {

    public String titleNews;
    public String contentNews;
    public String linkNews;

    public NewsModel() {
    }

    public NewsModel(String titleNews, String contentNews, String linkNews) {
        this.titleNews = titleNews;
        this.contentNews = contentNews;
        this.linkNews = linkNews;
    }


    public String getTitleNews() {
        return titleNews;
    }

    public String getContentNews() {
        return contentNews;
    }


    public String getLinkNews(){
        return linkNews;
    }

}



