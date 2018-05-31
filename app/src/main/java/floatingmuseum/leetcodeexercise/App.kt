package floatingmuseum.leetcodeexercise

import android.app.Application

/**
 * Created by Floatingmuseum on 2018/5/30.
 */
class App : Application(){

    companion object {
        public var context: Application? = null
    }

    override fun onCreate() {
        super.onCreate()

        context = this
    }
}