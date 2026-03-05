package com.example.idatdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.idatdemo.adapter.HistorialAdapter
import com.example.idatdemo.entity.Compra

class HistorialActivity : AppCompatActivity() {
    private lateinit var rvHistorial : RecyclerView
    private lateinit var historialAdapter : HistorialAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_historial)

        rvHistorial = findViewById(R.id.rvHistorial)
        val compras = listOf(
            Compra("1","https://picsum.photos/800/600","Pollo", "03/03/2026"),
            Compra("2","https://picsum.photos/800/600","Papa", "04/03/2026"),
            Compra("3","https://picsum.photos/800/600","Arroz", "05/03/2026")

        )
        historialAdapter = HistorialAdapter(compras, this)

        rvHistorial.layoutManager = LinearLayoutManager(this)
//        rvHistorial.layoutManager = GridLayoutManager(this, 2)
        rvHistorial.adapter = historialAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}