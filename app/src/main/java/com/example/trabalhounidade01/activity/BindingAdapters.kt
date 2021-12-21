package com.example.trabalhounidade01.activity

import android.graphics.Color
import android.widget.ImageButton
import android.widget.TextView
import androidx.databinding.BindingAdapter
import org.w3c.dom.Text


@BindingAdapter("bt_dificuldade","bt_id")
fun dificuldadeSelecionada(botao : ImageButton, codigo : Int, id: Int){
    when {
        (id == 1)&&(codigo == 1) -> {
            botao.setBackgroundColor(Color.CYAN)
        }
        (id == 2)&&(codigo == 2) -> {
            botao.setBackgroundColor(Color.CYAN)
        }
        (id == 3)&&(codigo == 3) -> {
            botao.setBackgroundColor(Color.CYAN)
        }
        else -> {
            botao.setBackgroundColor(Color.TRANSPARENT)
        }
    }

}

@BindingAdapter("bt_tamanhoMapa","bt_idmap")
fun mudarTamanhoDoMapa(botao: ImageButton, codigo: Int, idmap: Int){
    when {
        (idmap == 1)&&(codigo == 1) -> {
            botao.setBackgroundColor(Color.CYAN)
        }
        (idmap == 2)&&(codigo == 2) -> {
            botao.setBackgroundColor(Color.MAGENTA)
        }
        else -> {
            botao.setBackgroundColor(Color.TRANSPARENT)
        }
    }
}


