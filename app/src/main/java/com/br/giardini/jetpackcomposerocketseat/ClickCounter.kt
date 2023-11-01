package com.br.giardini.jetpackcomposerocketseat

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

@Composable
fun ClickCounter(){
    val state = remember {
        mutableStateOf(0)
    }
    Column {
        ClickText(state)
        ClickButton{//passando a responsabilidade da função onclick do botão para quem o chama.[1/2]
            state.value++
        }
    }
}

@Composable
fun ClickText(state: MutableState<Int>){
    Text(text = "Cliques:${state.value}", fontSize = 30.sp)
}

@Composable
fun ClickButton(onClick: () -> Unit){//passando uma função anônima (lambda) como argumento para o botão.[2/2]
    Button(onClick) {
        Text(text = "Clique aqui")
    }
}

