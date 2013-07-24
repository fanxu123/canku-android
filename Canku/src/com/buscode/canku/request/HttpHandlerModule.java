package com.buscode.canku.request;

import com.buscode.canku.storage.Today;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class HttpHandlerModule {
    @Provides
    @Named("today")
    HttpHandler<Today> provideHttpHandler() {
        return new TodayHttpHandler();
    }
}