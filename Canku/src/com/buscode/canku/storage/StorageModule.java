package com.buscode.canku.storage;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module()
public class StorageModule {

    @Provides
    @Singleton
    Storage provideStorage() {
        return new Storage();
    }
}
