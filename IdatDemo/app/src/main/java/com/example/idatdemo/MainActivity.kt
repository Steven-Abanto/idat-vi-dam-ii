package com.example.idatdemo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var tvRegistro : TextView
    private lateinit var ivWeb : ImageView
    private lateinit var ivTelefono : ImageView
    private lateinit var ivMensaje : ImageView
    private lateinit var ivDrive : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//      val tvRegistro : TextView = findViewById(R.id.tvRegistro)
        tvRegistro = findViewById(R.id.tvRegistro)
        ivDrive = findViewById(R.id.ivDrive)

        ivWeb = findViewById(R.id.ivWeb)
        ivTelefono = findViewById(R.id.ivTelefono)
        ivMensaje = findViewById(R.id.ivMensaje)

        ivWeb.setOnClickListener(){
            val intent : Intent = Intent(Intent.ACTION_VIEW)
            intent.setData("https://www.starwars.com/".toUri())
            startActivity(intent)
        }

        ivDrive.setOnClickListener(){
            val intent : Intent = Intent(this, ListaComprasActivity::class.java)
            startActivity(intent)
        }

        ivTelefono.setOnClickListener(){
            val intent : Intent = Intent(Intent.ACTION_CALL)
            intent.setData("tel:+51999999999".toUri())
            startActivity(intent)
        }

        ivMensaje.setOnClickListener(){
            val intent : Intent = Intent(Intent.ACTION_DIAL)
            startActivity(intent)
        }

        tvRegistro.setOnClickListener{
            val intent : Intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}