package com.example.sendmessage

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.sendmessage.model.Message

class ViewMessageActivity : AppCompatActivity() {

    companion object {
        const val TAG:String="LosViewMessageActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_message)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvAuthor = findViewById<TextView>(R.id.tvAuthor)
        val tvMessage = findViewById<TextView>(R.id.tvMessage)

        /* 1. Recoger cadena simple desde el Bundle
        val message = intent.extras?.getString("KEY_MESSAGE")
        tvMessage.text = message
        */

        // 2. Recoger objeto Serializable (Message)
        val bundle = intent.extras
        val message = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            bundle?.getSerializable("KEY_MESSAGE", Message::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle?.getSerializable("KEY_MESSAGE") as? Message
        }

        if (message != null) {
            val senderName = "${message.sender.name} ${message.sender.surname}"
            tvAuthor.text = "De: $senderName"
            tvMessage.text = message.content
        }
        supportActionBar?.hide()
    }
    //region Ciclo de Vida de una actividad
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"LosViewMessageActivity -> onStart()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"LosViewMessageActivity -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"LosViewMessageActivity -> onDestroy()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"LosViewMessageActivity -> onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"LosViewMessageActivity -> onPause()")
    }

    //endregion
}