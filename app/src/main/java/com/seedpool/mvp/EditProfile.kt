package com.seedpool.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.seedpool.mvp.fragments.FragmentMyProfile
import com.seedpool.mvp.utils.utils

class EditProfile : AppCompatActivity() {

    var isForAccountCreation = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)


        isForAccountCreation = intent.getBooleanExtra(utils.constants.KEY_IS_ON_ACCOUNT_CREATION, false)

        if(supportActionBar!=null && !isForAccountCreation)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        title = "My Profile"


        supportFragmentManager.beginTransaction()
            .replace(R.id.container_edit_profile,
                FragmentMyProfile().apply { arguments = Bundle().apply { putBoolean(utils.constants.KEY_IS_ON_ACCOUNT_CREATION, isForAccountCreation) } })
            .commit()

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

}
