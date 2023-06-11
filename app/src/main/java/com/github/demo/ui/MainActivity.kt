package com.github.demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.demo.hilt.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {

//    @ProfileMessage // Cюда мы можем зайнжектить все что @SingletonComponent и @ActivityComponent
//    @Inject
//    lateinit var profileMessage: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
