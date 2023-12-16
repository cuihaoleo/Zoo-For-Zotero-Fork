package me.cvhc.zooforzotero

import android.app.Application
//import com.facebook.flipper.android.AndroidFlipperClient
//import com.facebook.flipper.android.utils.FlipperUtils
//import com.facebook.flipper.plugins.databases.DatabasesFlipperPlugin
//import com.facebook.flipper.plugins.inspector.DescriptorMapping
//import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
//import com.facebook.soloader.SoLoader
import me.cvhc.zooforzotero.di.component.ApplicationComponent
import me.cvhc.zooforzotero.di.component.DaggerApplicationComponent
import me.cvhc.zooforzotero.di.module.ApplicationModule

class ZooForZoteroApplication : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

//        SoLoader.init(this, false)
//
//        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
//            val client = AndroidFlipperClient.getInstance(this)
//            client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
//            client.addPlugin(DatabasesFlipperPlugin(this));
//            client.start()
//        }


        component = me.cvhc.zooforzotero.di.component.DaggerApplicationComponent.builder().applicationModule(
            ApplicationModule(this)
        ).build()
    }

}
