package si.uni_lj.fri.pbd.miniapp3

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class CoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(DebugTree())
    }
}
