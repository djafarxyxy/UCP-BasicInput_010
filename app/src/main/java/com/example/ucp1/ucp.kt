package com.example.ucp1

import android.graphics.drawable.shapes.OvalShape
import android.preference.PreferenceActivity.Header
import android.telecom.Call.Details
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ucp1.R

@Preview(showBackground = true)
@Composable
fun ucp(){

    var memilihjk by remember { mutableStateOf("") }
    val listjk = listOf("laki-laki", "perempuan")
    var Gendersy by remember { mutableStateOf("") }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color.LightGray)
    ) {
        HeaderSection()
        Text(text = "Hallo")
        Text(text = "Farhan Naim Djafar")
        Spacer(modifier = Modifier.size(50.dp))
        DataDiri(
            judul = "Nama",
            isi = "Farhan naim djafar"
        )

        DataDiri(
            judul = "NoTlp",
            isi = "20220140018"
        )
    }
}

fun Image(painter: Painter) {

}

@Composable
fun HeaderSection(){
    Box(modifier = Modifier.fillMaxWidth().background(color = Color.DarkGray).padding(16.dp)){
        Row (modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Column {
                Row (modifier = Modifier.fillMaxWidth()){
                    listjk.forEach{selectedGender ->
                        Row (
                            verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = memilihjk == selectedGender,
                                onClick = { memilihjk = selectedGender
                                }
                            )
                            Text(text = selectedGender)

                        }}
                }

                Button(onClick = {
                    Gendersy = memilihjk
                }) {
                    Text(text = "Simpan")

                }
            }
            Box(
                contentAlignment = Alignment.BottomStart
            ){
                Image(painter = painterResource(id = R.drawable.alan),
                    contentDescription = "King UCL",
                    modifier = Modifier.size(100.dp)
                        .clip(CircleShape)
                )
                Icon(imageVector = Icons.Default.Done,
                    contentDescription = null
                )
            }
        }
    }
}
@Composable
fun DataDiri(
    judul: String, isi: String
){
    Column (
        modifier = Modifier.fillMaxWidth()
    ){
        Row (
            modifier = Modifier.fillMaxWidth().padding(2.dp)
        ){
            Text(text = judul,
                modifier = Modifier.weight(0.8f))
            Text(text = ":",
                modifier = Modifier.weight(0.2f))
            Text(text = isi,
                modifier = Modifier.weight(2f))

        }
    }
}

