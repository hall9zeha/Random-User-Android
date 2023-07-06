package com.barryzea.koinandkator.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.barryzea.koinandkator.R
import com.barryzea.koinandkator.databinding.ActivityMainBinding
import com.barryzea.koinandkator.viewModel.ViewModelMain
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var bind:ActivityMainBinding
    private val viewModel:ViewModelMain by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(
            this,R.layout.activity_main
        )
        setContentView(bind.root)
        setUpObservers()
        setUpDataBinding()
        viewModel.fetchRandomUser()
    }
    private fun setUpDataBinding(){
        bind.lifecycleOwner= this
        bind.viewModel= viewModel
    }
    private fun setUpObservers(){
        viewModel.user.observe(this){
            Log.e("RANDOM-USER", it.toString() )
        }
    }
}