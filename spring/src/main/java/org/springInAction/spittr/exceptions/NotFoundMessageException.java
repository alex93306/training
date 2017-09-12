package org.springInAction.spittr.exceptions;

/**
 * Created by alex on 18.03.2016.
 */
public class NotFoundMessageException extends RuntimeException {
    private long messageId;
    public NotFoundMessageException(long messageId) {
        this.messageId=messageId;
    }
    public long getMessageId() {
        return messageId;
    }
}
