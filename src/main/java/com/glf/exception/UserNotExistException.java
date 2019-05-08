package com.glf.exception;

/**
 * 自定义异常
 *
 * @author jinliang 2019/05/08 15:04
 */
public class UserNotExistException extends RuntimeException {
    private Long id;

    public UserNotExistException(Long id) {
        super("user not exist");
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
