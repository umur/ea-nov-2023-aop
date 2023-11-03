package com.assginments.lab.aspect;

import lombok.experimental.StandardException;

@StandardException
public class AopIsAwesomeHeaderException extends Throwable {

    public AopIsAwesomeHeaderException() {
        super();
    }

    public AopIsAwesomeHeaderException(String message) {
        super(message);
    }
}
