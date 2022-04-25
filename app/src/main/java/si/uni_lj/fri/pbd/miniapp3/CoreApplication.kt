package si.uni_lj.fri.pbd.miniapp3

import android.app.Application
import androidx.databinding.library.BuildConfig
import timber.log.Timber
import timber.log.Timber.DebugTree

class CoreApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        plantTimber()
    }

    private fun plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(DebugTree())
        }
    }
}
