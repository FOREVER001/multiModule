package client.com.baselibs.http.model.module1;

public class HomeModel {
    private BannerModel mBannerModel;
    private ArticleListModel mArticleListModel;

    public HomeModel(BannerModel bannerModel, ArticleListModel articleListModel) {
        mBannerModel = bannerModel;
        mArticleListModel = articleListModel;
    }

    public BannerModel getBannerModel() {
        return mBannerModel;
    }

    public void setBannerModel(BannerModel bannerModel) {
        mBannerModel = bannerModel;
    }

    public ArticleListModel getArticleListModel() {
        return mArticleListModel;
    }

    public void setArticleListModel(ArticleListModel articleListModel) {
        mArticleListModel = articleListModel;
    }
}
