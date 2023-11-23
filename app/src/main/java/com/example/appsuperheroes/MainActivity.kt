package com.example.appsuperheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
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
        modifier = modifier
            .fillMaxSize()
    ) {
        items(SuperHeroesRepository.superHeroesList) {
            SuperHeroeCard(heroe = it)
        }
    }
}

@Composable
fun SuperHeroeCard(heroe: Superheroe) {

    var expanded by remember { mutableStateOf(false) }

    val caracterArriba: String = "˄"
    val caracterAbajo: String = "˅"

    var iconoBoton  = caracterAbajo

    if(expanded) iconoBoton = caracterArriba ?: caracterAbajo

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(color = if(expanded) Color.Magenta else Color.Cyan)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)

        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp)
            ) {
                infoHeroe(
                    title = heroe.title,
                    description = heroe.description
                )
            }

            Button(
                colors = ButtonDefaults.buttonColors(Color.Transparent),
                onClick = { expanded = !expanded },
                enabled = true
            ) {

            Text(
                text = iconoBoton,
                color = Color.Black,
                fontSize = 40.sp
            )
            }

            iconoHeroe(imaxeId = heroe.imaxeId)

        }
        if (expanded) {
            extraHeroe(extra = heroe.extra)
        }


    }
}

@Composable
fun extraHeroe(
    @StringRes extra: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column (
        ){
            Text(
                text = "About:",
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.Default,
                fontSize = 15.sp
            )
            Text(
                text = stringResource(id = extra)
            )
        }

    }

}

@Composable
fun iconoHeroe(
    @DrawableRes imaxeId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = imaxeId),
        contentDescription = null,
        modifier = modifier
            .size(80.dp, 80.dp)
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun infoHeroe(
    @StringRes title: Int,
    @StringRes description: Int,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = description),
            style = MaterialTheme.typography.titleMedium
        )
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppSuperheroesTheme {
        AppSuperheroes()
    }
}