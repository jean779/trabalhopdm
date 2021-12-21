package com.example.trabalhounidade01.activity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.trabalhounidade01.R;
import com.example.trabalhounidade01.databinding.ActivityTelaresultadoBinding
import com.example.trabalhounidade01.viewmodel.TelaJogoActivityViewModel
import com.example.trabalhounidade01.viewmodel.TelaResultadoActivityViewModel

class TelaResultadoActivity : AppCompatActivity() {
    lateinit var binding: ActivityTelaresultadoBinding
    lateinit var viewModel: TelaResultadoActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telaresultado)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_telaresultado)
        viewModel = ViewModelProvider(this).get(TelaResultadoActivityViewModel::class.java)

     /*   binding.viewmodel = viewModel
        binding.lifecycleOwner = this*/
    }
}
