package com.example.appsuperheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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

        },
        modifier = modifier
    )

}

@Composable
fun tarxetaSuperheroe() {



}

@Composable
fun imaxe(
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
fun texto(
    @StringRes texto: Int,
    modifier: Modifier = Modifier
) {

    Text(
        text = stringResource(id = texto),
        modifier = modifier
    )

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppSuperheroesTheme {
        AppSuperheroes()
    }
}