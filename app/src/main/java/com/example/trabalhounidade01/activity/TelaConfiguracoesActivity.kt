package com.example.trabalhounidade01.activity;
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.trabalhounidade01.R;
import com.example.trabalhounidade01.databinding.ActivityTelaconfiguracoesBinding
import com.example.trabalhounidade01.model.Jogo
import com.example.trabalhounidade01.viewmodel.TelaConfiguracoesActivityViewModel

class TelaConfiguracoesActivity : AppCompatActivity() {
    lateinit var binding: ActivityTelaconfiguracoesBinding
    lateinit var viewModel: TelaConfiguracoesActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telaconfiguracoes)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_telaconfiguracoes)
        viewModel = ViewModelProvider(this).get(TelaConfiguracoesActivityViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.jogo.value = (intent.extras?.getSerializable("jogo") as Jogo)
        viewModel.dificuldade.value = (viewModel.jogo.value!!.getVelocidadeDaCobrinha())
        viewModel.tipoMapa.value= (viewModel.jogo.value!!.getMapaTipo())

        val botaoVoltar : Button = findViewById(R.id.botaovoltar)
        botaoVoltar.setOnClickListener{
            val intent = Intent()
            intent.putExtra("dificuldade", viewModel.jogo.value!!.getVelocidadeDaCobrinha())
            intent.putExtra("tipoMapa", viewModel.jogo.value!!.getMapaTipo())
            intent.putExtra("escolha", 2)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
}
