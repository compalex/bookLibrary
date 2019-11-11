package com.compalex.bookLibrary.api.service;

import java.util.List;
import com.compalex.bookLibrary.api.model.IBookInStock;

public interface IStockService {
    List<IBookInStock> getStock() throws Exception;
}
