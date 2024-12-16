package com.kemat.yasin

import com.kemat.yasin.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity
import com.kemat.yasin.databinding.ActivityMainBinding

class MainActivity :  AppCompatActivity() {

    companion object{


        const val EXTRA_NICKNAME = "extra_nickname"
    }
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        onClick()
    }





    private fun onClick() {
        val btn1= findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            val intent = Intent(this, PrepareActivity::class.java)
            intent.getStringExtra(EXTRA_NICKNAME)
            startActivity(intent)
        }
    }
    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.are_you_sure))

            .setPositiveButton(getString(R.string.yes)){ dialog, _->
                dialog.dismiss()

                finishAffinity()
                super.onBackPressed()
            }
            .setNegativeButton(getString(R.string.no)){ dialog, _->
                dialog.dismiss()
            }
            .show()
    }

}