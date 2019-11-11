package com.compalex.bookLibrary.model;

import com.compalex.bookLibrary.api.model.IBookRequest;

public class BookRequest implements IBookRequest {

    private Integer requestId;

    private Integer bookId;
    
    public BookRequest() {
      //used by dao
    }
    
    @Override
    public int getRequestId() {
        return requestId;
    }
    
    @Override
    public int getBookId() {
        return bookId;
    }
}
