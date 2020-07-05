package com.abhay.shadicardmatcher

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.abhay.shadicardmatcher.base.BaseActivity
import com.abhay.shadicardmatcher.ui.ShadiCardMatcherFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    ShadiCardMatcherFragment.newInstance(),
                    ShadiCardMatcherFragment::class.java.getName()
                )
                .commitNow()
        }
    }
}