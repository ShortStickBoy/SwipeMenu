package com.sunzn.menu.swipe.sample;

public class ModelBean {

    private String mainText;

    private String subsText;

    public ModelBean(String mainText, String subText) {
        this.mainText = mainText;
        this.subsText = subText;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getSubsText() {
        return subsText;
    }

    public void setSubsText(String subsText) {
        this.subsText = subsText;
    }
    
}
