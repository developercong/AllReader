package com.congzibank.allreader.home.data;

/**
 * @author wangcong
 * book that is selected
 */
public class SelectBook {+

    private String bookName;
    private String bookUrl;
    private int bookType;

    public SelectBook(String bookName, String bookUrl, int bookType) {
        this.bookName = bookName;
        this.bookUrl = bookUrl;
        this.bookType = bookType;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }

    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }
}
