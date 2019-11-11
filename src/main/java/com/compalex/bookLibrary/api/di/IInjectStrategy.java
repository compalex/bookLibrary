package com.compalex.bookLibrary.api.di;

import com.compalex.bookLibrary.utility.Constants;

public interface IInjectStrategy {
    Object getInjectObject(Constants.Type type);
}
