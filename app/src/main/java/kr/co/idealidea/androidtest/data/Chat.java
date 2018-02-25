package kr.co.idealidea.androidtest.data;

import java.io.Serializable;

/**
 * Created by Administrator on 2018-02-25.
 */

public class Chat implements Serializable {

    boolean isMyMessage; // true 내가입력 : false 컴퓨터
    String content; // 대화 내용

    public Chat(boolean isMyMessage, String content) {
        this.isMyMessage = isMyMessage;
        this.content = content;
    }

    public boolean isMyMessage() {
        return isMyMessage;
    }

    public void setMyMessage(boolean myMessage) {
        isMyMessage = myMessage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
