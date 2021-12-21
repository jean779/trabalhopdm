package com.example.trabalhounidade01.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.trabalhounidade01.R
import com.example.trabalhounidade01.databinding.ActivityMainBinding
import com.example.trabalhounidade01.model.Jogo
import com.example.trabalhounidade01.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainActivityViewModel

    private val activityForResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            when (it.resultCode) {
                RESULT_OK -> {
                    val params = it.data?.extras
                    when(params?.getInt("escolha")){
                    2 -> {
                        this.viewModel.jogo.value!!.setVelocidadeDaCobrinha(params!!.get("dificuldade") as Int)
                        this.viewModel.jogo.value!!.setMapaTipo(params!!.get("tipoMapa")as Int)
                    }}
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        /*
            binding.viewmodel = viewModel
            binding.lifecycleOwner = this*/

        val botaoConfigur : Button = findViewById(R.id.botaoConfiguracao)
        botaoConfigur.setOnClickListener{
            val intent = Intent(this@MainActivity, TelaConfiguracoesActivity::class.java)
                intent.putExtra("jogo", viewModel.jogo.value)
                activityForResult.launch(intent)
        }

        val novoJogo : Button = findViewById(R.id.botaoNovoJogo)
        novoJogo.setOnClickListener{
            val intent = Intent(this@MainActivity, TelaJogoActivity::class.java)
                intent.putExtra("jogo", viewModel.jogo.value)
                activityForResult.launch(intent)
        }


    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStart() {
        super.onStart()
        val preferencias = getSharedPreferences("MinhasPreferencias", MODE_PRIVATE)

        viewModel.jogo.value!!.setVelocidadeDaCobrinha(preferencias.getString("dificuldade", "2")!!.toInt());
        viewModel.jogo.value!!.setMapaTipo(preferencias.getString("tipoMapa", "2")!!.toInt());

    }

    override fun onStop() {
        super.onStop()
        getSharedPreferences("MinhasPreferencias", MODE_PRIVATE).edit().apply {
            putString("dificuldade", viewModel.jogo.value!!.getVelocidadeDaCobrinha().toString())
            putString("tipoMapa", viewModel.jogo.value!!.getMapaTipo().toString())
            apply()
        }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }

    /*override fun onStop() {

    }*/
}