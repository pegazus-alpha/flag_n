package com.example.flag;

public class chap_model {
    private String chapName;
    private String chapTitle;
    private  String chapResume;

    public chap_model(String a,String b,String c){
        chapName=a;
        chapTitle=b;
        chapResume=c;
    }
    public void setChapName(String chapName) {
        this.chapName = chapName;
    }

    public void setChapResume(String chapResume) {
        this.chapResume = chapResume;
    }

    public void setChapTitle(String chapTitle) {
        this.chapTitle = chapTitle;
    }

    public String getChapName() {
        return chapName;
    }

    public String getChapResume() {
        return chapResume;
    }

    public String getChapTitle() {
        return chapTitle;
    }
}
