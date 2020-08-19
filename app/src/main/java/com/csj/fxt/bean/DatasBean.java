package com.csj.fxt.bean;

import org.greenrobot.greendao.annotation.Entity;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;

@Entity
public class DatasBean {
    /**
     * apkLink :
     * audit : 1
     * author : VIPyinzhiwei
     * canEdit : false
     * chapterId : 294
     * chapterName : 完整项目
     * collect : false
     * courseId : 13
     * desc : 基于 Kotlin 语言仿写「开眼 Eyepetizer」的一个短视频 Android 客户端项目，采用 Jetpack + 协程实现的 MVVM 架构。
     * <p>
     * 值得一提的是，所有 UI 都是经过标注工具测量后的，无论是字体颜色、大小、间距等几乎都是像素级模仿的「开眼 Eyepetizer」Android 客户端 App，对应的 v6.3.1 版本（目前更新版）。
     * descMd :
     * envelopePic : https://www.wanandroid.com/blogimgs/c90df328-30b0-4fc9-906a-c661ed450cad.png
     * fresh : false
     * id : 13976
     * link : https://www.wanandroid.com/blog/show/2774
     * niceDate : 2020-06-22 00:43
     * niceShareDate : 2020-06-22 00:43
     * origin :
     * prefix :
     * projectLink : https://github.com/VIPyinzhiwei/Eyepetizer
     * publishTime : 1592757812000
     * realSuperChapterId : 293
     * selfVisible : 0
     * shareDate : 1592757812000
     * shareUser :
     * superChapterId : 294
     * superChapterName : 开源项目主Tab
     * tags : [{"name":"项目","url":"/project/list/1?cid=294"}]
     * title : 一款高仿 Eyepetizer | 开眼短视频的 MVVM 开源项目
     * type : 0
     * userId : -1
     * visible : 1
     * zan : 0
     */
    @Id
    private long _id;
    private String apkLink;
    private int audit;
    private String author;
    private boolean canEdit;
    private int chapterId;
    private String chapterName;
    private boolean collect;
    private int courseId;
    private String desc;
    private String descMd;
    private String envelopePic;
    private boolean fresh;
    private int id;
    private String link;
    private String niceDate;
    private String niceShareDate;
    private String origin;
    private String prefix;
    private String projectLink;
    private long publishTime;
    private int realSuperChapterId;
    private int selfVisible;
    private long shareDate;
    private String shareUser;
    private int superChapterId;
    private String superChapterName;
    @Unique
    private String title;
    private int type;
    private int userId;
    private int visible;
    private int zan;

    @Generated(hash = 700616137)
    public DatasBean(long _id, String apkLink, int audit, String author, boolean canEdit, int chapterId, String chapterName,
            boolean collect, int courseId, String desc, String descMd, String envelopePic, boolean fresh, int id,
            String link, String niceDate, String niceShareDate, String origin, String prefix, String projectLink,
            long publishTime, int realSuperChapterId, int selfVisible, long shareDate, String shareUser, int superChapterId,
            String superChapterName, String title, int type, int userId, int visible, int zan) {
        this._id = _id;
        this.apkLink = apkLink;
        this.audit = audit;
        this.author = author;
        this.canEdit = canEdit;
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.collect = collect;
        this.courseId = courseId;
        this.desc = desc;
        this.descMd = descMd;
        this.envelopePic = envelopePic;
        this.fresh = fresh;
        this.id = id;
        this.link = link;
        this.niceDate = niceDate;
        this.niceShareDate = niceShareDate;
        this.origin = origin;
        this.prefix = prefix;
        this.projectLink = projectLink;
        this.publishTime = publishTime;
        this.realSuperChapterId = realSuperChapterId;
        this.selfVisible = selfVisible;
        this.shareDate = shareDate;
        this.shareUser = shareUser;
        this.superChapterId = superChapterId;
        this.superChapterName = superChapterName;
        this.title = title;
        this.type = type;
        this.userId = userId;
        this.visible = visible;
        this.zan = zan;
    }

    @Generated(hash = 128729784)
    public DatasBean() {
    }

    public String getApkLink() {
        return apkLink;
    }

    public void setApkLink(String apkLink) {
        this.apkLink = apkLink;
    }

    public int getAudit() {
        return audit;
    }

    public void setAudit(int audit) {
        this.audit = audit;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public boolean isCollect() {
        return collect;
    }

    public void setCollect(boolean collect) {
        this.collect = collect;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDescMd() {
        return descMd;
    }

    public void setDescMd(String descMd) {
        this.descMd = descMd;
    }

    public String getEnvelopePic() {
        return envelopePic;
    }

    public void setEnvelopePic(String envelopePic) {
        this.envelopePic = envelopePic;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }

    public String getNiceShareDate() {
        return niceShareDate;
    }

    public void setNiceShareDate(String niceShareDate) {
        this.niceShareDate = niceShareDate;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getProjectLink() {
        return projectLink;
    }

    public void setProjectLink(String projectLink) {
        this.projectLink = projectLink;
    }

    public long getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(long publishTime) {
        this.publishTime = publishTime;
    }

    public int getRealSuperChapterId() {
        return realSuperChapterId;
    }

    public void setRealSuperChapterId(int realSuperChapterId) {
        this.realSuperChapterId = realSuperChapterId;
    }

    public int getSelfVisible() {
        return selfVisible;
    }

    public void setSelfVisible(int selfVisible) {
        this.selfVisible = selfVisible;
    }

    public long getShareDate() {
        return shareDate;
    }

    public void setShareDate(long shareDate) {
        this.shareDate = shareDate;
    }

    public String getShareUser() {
        return shareUser;
    }

    public void setShareUser(String shareUser) {
        this.shareUser = shareUser;
    }

    public int getSuperChapterId() {
        return superChapterId;
    }

    public void setSuperChapterId(int superChapterId) {
        this.superChapterId = superChapterId;
    }

    public String getSuperChapterName() {
        return superChapterName;
    }

    public void setSuperChapterName(String superChapterName) {
        this.superChapterName = superChapterName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }

    public int getZan() {
        return zan;
    }

    public void setZan(int zan) {
        this.zan = zan;
    }

    public boolean getCanEdit() {
        return this.canEdit;
    }

    public boolean getCollect() {
        return this.collect;
    }

    public boolean getFresh() {
        return this.fresh;
    }

    public long get_id() {
        return this._id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}
