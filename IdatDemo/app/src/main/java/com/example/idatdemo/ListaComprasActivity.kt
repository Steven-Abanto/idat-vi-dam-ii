package com.example.idatdemo

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class ListaComprasActivity : AppCompatActivity() {
    private lateinit var tietProducto : TextInputEditText
    private lateinit var btnGuardar : Button
    private lateinit var lvCompras : ListView

    private var listaCompras = mutableListOf<String>()
    private lateinit var listAdapter : ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lista_compras)

        tietProducto = findViewById(R.id.tietProducto)
        btnGuardar = findViewById(R.id.btnGuardar)
        lvCompras = findViewById(R.id.lvCompras)

        //Inicializa adaptador
        listAdapter = ArrayAdapter(
            this, //Activity donde se va a ejeutar
            android.R.layout.simple_list_item_1, //Diseño reutilizado para cada elemento
            listaCompras //Lista con datos
        )

        //Asignación de adaptador a ListView
        lvCompras.adapter = listAdapter

        btnGuardar.setOnClickListener{
            val producto = tietProducto.text?.trim().toString()
            if(producto.isNotEmpty()){
                listaCompras.add(producto)
                listAdapter.notifyDataSetChanged()
                tietProducto.text?.clear()
            }
            else {
                Toast.makeText(this,"Ingrese un texto",Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}