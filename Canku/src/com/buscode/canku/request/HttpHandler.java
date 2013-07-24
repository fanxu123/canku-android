package com.buscode.canku.request;

public interface HttpHandler<T> {
    public T request() throws Exception;
}
