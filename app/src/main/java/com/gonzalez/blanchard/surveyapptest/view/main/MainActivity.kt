package com.gonzalez.blanchard.surveyapptest.view.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gonzalez.blanchard.surveyapptest.databinding.ActivityMainBinding
import com.gonzalez.blanchard.surveyapptest.extensions.launchAndCollect

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainActivityViewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainActivityViewModel.viewCreated()
        initActionsListener()
    }

    private fun initActionsListener() {
        this.launchAndCollect(mainActivityViewModel.actions) { actions ->
           /* when (actions) {
                 MainActivityActions.LoadContent -> goToHome()
            }*/
        }
    }
}
