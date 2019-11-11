package com.compalex.bookLibrary.service;

import java.util.List;
import com.compalex.bookLibrary.api.annotations.Inject;
import com.compalex.bookLibrary.api.dao.IRequestDAO;
import com.compalex.bookLibrary.api.model.IBook;
import com.compalex.bookLibrary.api.model.IBookRequest;
import com.compalex.bookLibrary.api.service.IRequestService;
import com.compalex.bookLibrary.utility.Constants;

public class RequestService implements IRequestService {
    @Inject(layer = Constants.Layer.DAO, type = Constants.Type.REQUEST) 
    private IRequestDAO requestDAO;
    private static IRequestService instance;

    private RequestService() {
        //just to forbid regular initializing
    }
    
    public static IRequestService getInstance() {
        if(instance == null) {
            instance = new RequestService();
        }
        return instance;
    }
    
    @Override
    public List<IBookRequest> getAllRequests() throws Exception {
        return requestDAO.getAllRequests();
    }

    @Override
    public void deleteRequests(IBook book) throws Exception {
        List<IBookRequest> requests = requestDAO.getAllRequests();
        
        for(IBookRequest request : requests) {
            if(request.getBookId() == book.getId()) {
                requestDAO.deleteRecord(request.getRequestId());
            }
        }
    }
}
