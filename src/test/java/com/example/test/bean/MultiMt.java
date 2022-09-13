package com.example.test.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="Mailto:davidsangpower@163.com">author</a>
 * @location com.montnets.common.entity.msgrecv
 * @date 2019/5/28 14:53
 * @description 个性化信息详情
 * @since 1.0
 */
public class MultiMt implements Serializable {
    private List<Receiver> receiver;
    private List<Receiver> copyreceiver;
    private List<Receiver> secretreceiver;
    private String content;
    private String title;

    public List<Receiver> getCopyreceiver() {
        return copyreceiver;
    }

    public void setCopyreceiver(List<Receiver> copyreceiver) {
        this.copyreceiver = copyreceiver;
    }

    public List<Receiver> getSecretreceiver() {
        return secretreceiver;
    }

    public void setSecretreceiver(List<Receiver> secretreceiver) {
        this.secretreceiver = secretreceiver;
    }

    public List<Receiver> getReceiver() {
        return receiver;
    }

    public void setReceiver(List<Receiver> receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public MultiMt() {
    }

    @Override
    public String toString() {
        return "MultiMt{" +
                "receiver=" + receiver +
                ", content='" + content + '\'' +
                ", emailtitle='" + title + '\'' +
                '}';
    }

    public MultiMt(List<Receiver> receiver, String content, String title) {
        this.receiver = receiver;
        this.content = content;
        this.title = title;
    }
}
