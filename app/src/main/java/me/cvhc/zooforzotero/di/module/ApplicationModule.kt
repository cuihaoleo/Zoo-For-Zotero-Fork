package me.cvhc.zooforzotero.di.module

import android.content.Context
import me.cvhc.zooforzotero.PreferenceManager
import me.cvhc.zooforzotero.ZooForZoteroApplication
import me.cvhc.zooforzotero.ZoteroStorage.AttachmentStorageManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val app: ZooForZoteroApplication) {

    @Provides
    fun provideContext(): Context {
        return app
    }

    @Singleton
    @Provides
    fun providesAttachmentStorageManager(
        context: Context,
        preferenceManager: PreferenceManager
    ): AttachmentStorageManager {
        return AttachmentStorageManager(context, preferenceManager)
    }

    @Singleton
    @Provides
    fun providePreferenceManager(context: Context): PreferenceManager {
        return PreferenceManager(context)
    }
}