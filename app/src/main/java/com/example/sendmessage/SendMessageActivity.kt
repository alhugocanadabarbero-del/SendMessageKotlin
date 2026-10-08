package com.example.sendmessage

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import com.example.sendmessage.model.Person
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.sendmessage.model.Message
/**
 * Esta es la primera actividad de la aplicación que realiza las operaciones:
 * <ul>
 *          <li>Crear un componente EditText y Button en XML</li>
 *          <li>Lanzar un evento en un componente Visual</li>
 *          <li>Crea el Intent junto con el Bundle para pasar a otra actividad</li>
 *          <li>El ciclo de vida de la <code>Activity</code></li>
 *          <li>Ver la pila de Actividades</li>
 * </ul>
 *
 * <p>Captura de pantalla de la pantalla de envío:</p>
 * <p><img src="../../Recursos/sendmessageimagen.png" alt="SendMessageActivity Screenshot"/></p>
 *
 * @author Hugo Cañada
 * @version 1.0
 * @see android.widget.EditText
 * @see android.widget.Button
 * @see android.os.Bundle
 * @see Intent
 */
class SendMessageActivity : AppCompatActivity() {
        lateinit var etMessageText: EditText
        lateinit var btSend: FloatingActionButton
    companion object {
        const val TAG:String="LosSendMessageActivity"
    }

    /**
     * Método de creacion de una Actividad
     * @param android.os.Bundle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message)


        etMessageText = findViewById<EditText>(R.id.etMessage)
        val btSend = findViewById<Button>(R.id.btSend)

        btSend.setOnClickListener {
            /* 1.Pasar dato a dato en un Bundle
            val intent = Intent(this, ViewMessageActivity::class.java)
            val bundle = Bundle()
            bundle.putString("KEY_MESSAGE",etMessageText.text.toString())
            intent.putExtras(bundle)
            startActivity(intent)
             */
            sendMessage()
        }
        //Se ecriben mensajes de depuracion en la consola LogCat
        Log.d("SendMessageActivity","LosSendMessageActivity -> onCreate()")


    }

    /**
     * Funcion que crea un mensaje con la informacion de la persona que envia y de la persona que recoge el mensaje
     */
    private fun sendMessage(){
        //1.Crear el Intent
        val intent = Intent(this, ViewMessageActivity::class.java)
        //2.Crear el bundle
        val bundle = Bundle()
        //3. La informacion del mesnaje
        val sender = Person("123123123A","Hugo","Cañada")
        val receiver= Person("8712312312P","Pepe","Perez")

        val message = Message(1, etMessageText.text.toString(), sender, receiver)
        bundle.putParcelable("KEY_MESSAGE", message)
        intent.putExtras(bundle)
        startActivity((intent))
    }




    //region Ciclo de Vida de una actividad
    override fun onStart() {
        super.onStart()
        Log.d(TAG,"LosSendMessageActivity -> onStart()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"LosSendMessageActivity -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"LosSendMessageActivity -> onDestroy()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"LosSendMessageActivity -> onResume)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"LosSendMessageActivity -> onPause()")
    }

    //endregion
}