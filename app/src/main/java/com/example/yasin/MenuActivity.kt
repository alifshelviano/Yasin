package com.example.yasin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

import androidx.appcompat.app.AppCompatActivity
import com.example.yasin.databinding.ActivityMenuBinding



class MenuActivity : AppCompatActivity() {


    private lateinit var menuBinding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        menuBinding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(menuBinding.root)
        val intent = intent
        val nickname = intent.getStringExtra("Nama")

        if (nickname in listOf("alif","zearmy","yudis","bintang","dhika","putri","desi")) {
            menuBinding.tvNickname.text = "Assalamu'alaikum "+ nickname + " Status Anda Cucu"
        }else if(nickname in listOf("tono","kartono","ani","cicis","siswanto","marto","momo")){
            menuBinding.tvNickname.text = "Assalamu'alaikum "+nickname + " Status Anda Anak"
        }else if(nickname in listOf("erna","widi","titi","riyan","nazar")) {
            menuBinding.tvNickname.text = "Assalamu'alaikum "+nickname + " Status Anda Menantu"
        }else if(nickname in listOf("akmal","arka","sila")){
            menuBinding.tvNickname.text = "Assalamu'alaikum "+nickname + " Status Anda cicit"
        }else if(nickname in listOf("sumi")){
            menuBinding.tvNickname.text = "Assalamu'alaikum "+nickname + " Status istri"
        }else{
            menuBinding.tvNickname.text = "Assalamu'alaikum "+nickname
        }

        val nicknameToImageMap = mapOf(
            "memi" to R.drawable.zearmy,
            "zearmy" to R.drawable.zearmy,
            "alif" to R.drawable.alif,
            "bintang" to R.drawable.bintang,
            "yudis" to R.drawable.yudis,
            "dhika" to R.drawable.dhika,
            "dika" to R.drawable.dhika,
            "arka" to R.drawable.arka,
            "akmal" to R.drawable.akmal,
            "sila" to R.drawable.sila
        )

        val imageResourceId = nicknameToImageMap.getOrDefault(nickname, R.drawable.defaultprofile)
        menuBinding.imageView.setImageResource(imageResourceId)

        menuBinding.btnDoa.setOnClickListener {
            val intent = Intent(this, ActivityDoa::class.java)
            startActivity(intent)

        }
        menuBinding.btnList.setOnClickListener {
            val intent = Intent(this, Tampil::class.java)
            startActivity(intent)

        }




    }







}