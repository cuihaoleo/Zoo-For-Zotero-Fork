package me.cvhc.zooforzotero.di.component

import android.content.Context
import me.cvhc.zooforzotero.AttachmentManager.AttachmentManagerModel
import me.cvhc.zooforzotero.LibraryActivity.Fragments.LibraryListFragment
import me.cvhc.zooforzotero.LibraryActivity.LibraryActivityModel
import me.cvhc.zooforzotero.SettingsActivity
import me.cvhc.zooforzotero.ZoteroAPI.Syncing.SyncManager
import me.cvhc.zooforzotero.ZoteroStorage.AttachmentStorageManager
import me.cvhc.zooforzotero.ZoteroStorage.ZoteroDB.ZoteroDB
import me.cvhc.zooforzotero.di.module.ApplicationModule
import me.cvhc.zooforzotero.di.module.DatabaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DatabaseModule::class))
interface ApplicationComponent {
    val context: Context
    fun inject(libraryActivityModel: LibraryActivityModel)
    fun inject(settingsActivity: SettingsActivity)
    fun inject(attachmentManagerModel: AttachmentManagerModel)
    fun inject(attachmentStorageManager: AttachmentStorageManager)
    fun inject(syncManager: SyncManager)
    fun inject(zoteroDB: ZoteroDB)
    fun inject(libraryListFragment: LibraryListFragment)
}