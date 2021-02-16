package com.seedpool.mvp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.seedpool.mvp.utils.FirebaseUtils
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric
import java.lang.Exception

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        if(FirebaseUtils.isLoggedIn()){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
            try {
                if (Fabric.isInitialized())
                    Crashlytics.setUserIdentifier(FirebaseUtils.getUid())
            }
            catch (e:Exception){e.printStackTrace()}
        }


    }


    fun onGetStartedClick(v: View){
        startActivity(Intent(this, MobileLoginActivity::class.java))
    }
}
