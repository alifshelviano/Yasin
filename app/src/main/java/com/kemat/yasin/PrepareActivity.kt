package com.kemat.yasin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kemat.yasin.MainActivity.Companion.EXTRA_NICKNAME
import com.kemat.yasin.databinding.ActivityPrepareBinding
import com.kemat.yasin.MenuActivity


class PrepareActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NICKNAME = "extra_nickname"}
    private lateinit var prepareBinding: ActivityPrepareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        prepareBinding = ActivityPrepareBinding.inflate(layoutInflater)
        setContentView(prepareBinding.root)
        onClick()
    }
    private fun onClick() {

        prepareBinding.btnStart.setOnClickListener {
            val nickname = prepareBinding.etNickname.text.toString()

            val intent = Intent(this, MenuActivity::class.java)

            if (checkvalidation(nickname)) {

                intent.putExtra("Nama", nickname.lowercase())
                startActivity(intent)

            }
        }
    }
        private fun checkvalidation(nickname: String): Boolean {
            return if (nickname.isEmpty()) {
                prepareBinding.etNickname.error = getString(R.string.please_field_your_nickname)
                false
            } else {
                true
            }
        }


}