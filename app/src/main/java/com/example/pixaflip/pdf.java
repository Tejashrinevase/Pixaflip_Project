package com.example.pixaflip;

public class pdf {
    private String pdfName;
    private String Url;


    public pdf(String pdfName, String Url) {
        this.pdfName = pdfName;
        this.Url = Url;
    }

    public String getPdfName() {
        return pdfName;
    }

    public void setPdfName(String pdfName) {
        this.pdfName = pdfName;
    }

    public String getUrl() {
        return Url;
    }

    public void setPdfUrl(String pdfUrl) {
        this.Url = Url;
    }
}