package com.compalex.bookLibrary.api.di;

import com.compalex.bookLibrary.utility.Constants;

public interface InjectStrategy {
    Object getInjectObject(Constants.Type type) throws Exception;
}
