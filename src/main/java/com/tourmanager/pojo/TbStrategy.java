package com.tourmanager.pojo;

public class TbStrategy {
    private Integer id;

    private String city;

    private String logo;

    private String citytype;

    private String status;

    private String startage;

    private String endage;

    private Integer clicks;

    private String introduction;

    private Integer cid;

    private String title;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getCitytype() {
        return citytype;
    }

    public void setCitytype(String citytype) {
        this.citytype = citytype == null ? null : citytype.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getStartage() {
        return startage;
    }

    public void setStartage(String startage) {
        this.startage = startage == null ? null : startage.trim();
    }

    public String getEndage() {
        return endage;
    }

    public void setEndage(String endage) {
        this.endage = endage == null ? null : endage.trim();
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}