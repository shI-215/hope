package com.example.hope.bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Oji
 * @Date: 2020/03/01/9:32
 * @Description:
 */
public class Help {
    private int helpId;
    private int userId;
    private int actId;

    @Override
    public String toString() {
        return "Help{" +
                "helpId=" + helpId +
                ", userId=" + userId +
                ", actId=" + actId +
                '}';
    }

    public int getHelpId() {
        return helpId;
    }

    public void setHelpId(int helpId) {
        this.helpId = helpId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }
}
