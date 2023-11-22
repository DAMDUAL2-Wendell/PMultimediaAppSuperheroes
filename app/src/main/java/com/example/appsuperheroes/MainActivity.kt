package com.example.appsuperheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appsuperheroes.data.SuperHeroesRepository
import com.example.appsuperheroes.model.Superheroe
import com.example.appsuperheroes.ui.theme.AppSuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppSuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppSuperheroes()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSuperheroes(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier
    ) { paddingValues ->
        contenido(paddingValues = paddingValues)
    }
}

@Composable
fun contenido(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        content = {
            items(SuperHeroesRepository.superHeroesList) {
                superHeroeItem(
                    heroe = it,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                )
            }
        },
        modifier = modifier.fillMaxSize()
    )
}

@Composable
fun superHeroeItem(
    heroe: Superheroe,
    modifier: Modifier = Modifier
) {

   Card(
       modifier = modifier.fillMaxWidth()
   ) {
       textoHeroe(
           texto = heroe.nome,
           tamanhoLetra = 15
       )
       imaxeHeroe(
           heroe.imaxeId,
           modifier = Modifier
               .align(alignment = Alignment.End)
               .size(100.dp)
       )

       Spacer(modifier = Modifier.height(10.dp))

       textoHeroe(
           texto = R.string.extra
       )

       textoHeroe(
           texto = heroe.about
       )
   }


}

@Composable
fun imaxeHeroe(
    @DrawableRes imaxeId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painterResource(id = imaxeId),
        contentDescription = null,
        modifier = modifier
    )

}

@Composable
fun textoHeroe(
    @StringRes texto: Int,
    tamanhoLetra: Int = 10,
    modifier: Modifier = Modifier
) {

    Text(
        text = stringResource(id = texto),
        fontSize = tamanhoLetra.sp,
        modifier = modifier,
        )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppSuperheroesTheme {
        AppSuperheroes()
    }
}