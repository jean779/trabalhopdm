package com.example.trabalhounidade01.activity;
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.trabalhounidade01.R;
import com.example.trabalhounidade01.databinding.ActivityTelajogoBinding
import com.example.trabalhounidade01.model.Jogo
import com.example.trabalhounidade01.viewmodel.TelaJogoActivityViewModel

class TelaJogoActivity : AppCompatActivity() {
    lateinit var binding: ActivityTelajogoBinding
    lateinit var viewModel: TelaJogoActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_telajogo)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_telajogo)
        viewModel = ViewModelProvider(this).get(TelaJogoActivityViewModel::class.java)

       /* binding.viewmodel = viewModel
        binding.lifecycleOwner = this*/
        viewModel.jogo.value = (intent.extras?.getSerializable("jogo") as Jogo)

        val botaoPausar : Button = findViewById(R.id.botaopausar)
        botaoPausar.setOnClickListener{
            val intent = Intent()
             intent.putExtra("jogo", viewModel.jogo.value)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
