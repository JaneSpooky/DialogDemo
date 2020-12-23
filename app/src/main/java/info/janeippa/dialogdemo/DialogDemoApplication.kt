package info.janeippa.dialogdemo

import android.app.Application
import android.content.Context

class DialogDemoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        DialogDemoApplication.applicationContext = applicationContext
    }

    companion object {
        lateinit var applicationContext: Context
    }
}