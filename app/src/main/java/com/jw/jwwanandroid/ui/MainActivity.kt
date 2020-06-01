package com.jw.jwwanandroid.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.jw.jwwanandroid.R
import com.jw.jwwanandroid.databinding.ActivityMainBinding
import com.jw.jwwanandroid.model.MUser

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        var user = MUser("张三", 20)
        mBinding.user = user

        mBinding.button.setOnClickListener {
            user.userAge += 1
            Toast.makeText(this@MainActivity, "${user.userAge}", Toast.LENGTH_SHORT).show()
        }
    }
}
