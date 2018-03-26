package com.ljs.pojo.weChat;



import java.util.List;

public class NewsMessage extends BaseMessage{
    private int ArticleCount;
    private List<Article> Articles;

    public NewsMessage() {
    }

    public int getArticleCount() {
        return this.ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        this.ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return this.Articles;
    }

    public void setArticles(List<Article> articles) {
        this.Articles = articles;
    }
}
