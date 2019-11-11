package com.compalex.bookLibrary.api.service;

import java.util.List;

import com.compalex.bookLibrary.api.model.IBook;
import com.compalex.bookLibrary.api.model.IBookRequest;

public interface IRequestService {
    List<IBookRequest> getAllRequests() throws Exception;
    void deleteRequests(IBook book) throws Exception;
}
