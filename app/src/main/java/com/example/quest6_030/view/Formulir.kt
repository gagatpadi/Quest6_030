package com.example.pertemuan6.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions // Tambahan opsional untuk keyboard
import androidx.compose.material3.Button
import androidx.compose.material3.DividerDefaults.Thickness
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue // Import penting untuk 'by'
import androidx.compose.runtime.mutableStateOf // Import penting
import androidx.compose.runtime.remember // Import penting
import androidx.compose.runtime.setValue // Import penting untuk 'by'
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType // Tambahan opsional
import androidx.compose.ui.unit.dp
import com.example.quest6_030.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormIsian(
    jenisK: List<String> = listOf("Laki-Laki", "Perempuan"),
    OnSubmitBtnClick: (List<String>) -> Unit // Update parameter agar bisa mengirim data
) {
    // 1. Deklarasikan State secara terpisah untuk setiap variabel
    var txtNama by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.home), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) { isiRuang ->
        Column(
            modifier = Modifier
                .padding(paddingValues = isiRuang)
                .fillMaxWidth(), // Tambahkan fillMaxWidth agar layout rapi
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Input Nama
            OutlinedTextField(
                value = txtNama, // Hubungkan dengan state txtNama
                singleLine = true,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .width(250.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = { txtNama = it } // Update state saat mengetik
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = Thickness,
                color = Color.Red
            )

            // Input Gender (Radio Button)
            Row {
                jenisK.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = txtGender == item, // Cek apakah item ini yang dipilih
                            onClick = { txtGender = item } // Update state saat diklik
                        )
                        Text(text = item) // Tampilkan label teks di sebelah radio button
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(all = 20.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Red
            )

            // Input Alamat
            OutlinedTextField(
                value = txtAlamat, // Hubungkan dengan state txtAlamat
                singleLine = true,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Alamat") },
                onValueChange = { txtAlamat = it } // Update state saat mengetik
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.8f) // Sesuaikan lebar tombol
                    .padding(all = 25.dp),
                onClick = { OnSubmitBtnClick(listOf(txtNama, txtGender, txtAlamat)) }
            ) {
                Text(text = stringResource(id = R.string.submit))
            }
        }
    }
}