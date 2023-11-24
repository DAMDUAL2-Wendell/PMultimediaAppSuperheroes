package com.example.appsuperheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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
        topBar = { heroeTopAppBar(modifier = modifier) }
    ) { paddingValues ->
        contenido(paddingValues = paddingValues)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun heroeTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colorScheme.inversePrimary)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_heroe_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.logo_size))
                        .padding(dimensionResource(id = R.dimen.padding_small))
                )
                Text(
                    text = stringResource(id = R.string.app_name),

                    style = MaterialTheme.typography.displaySmall
                )
            }

        }
    )
}

@Composable
fun contenido(
    paddingValues: PaddingValues
) {
    LazyColumn(
        contentPadding = paddingValues,
        modifier = Modifier
            .padding(top = dimensionResource(id = R.dimen.padding_small))
    ) {
        items(SuperHeroesRepository.superHeroesList) {
            SuperHeroeCard(
                heroe = it,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
            )
        }
    }
}

@Composable
fun SuperHeroeCard(
    heroe: Superheroe,
    modifier: Modifier = Modifier
) {

    var expanded by remember { mutableStateOf(false) }

    val cardBackgroundColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer else
            MaterialTheme.colorScheme.primaryContainer, label = ""
    )

    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioLowBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .background(color = cardBackgroundColor)
                .padding(dimensionResource(id = R.dimen.padding_small))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                infoHeroe(
                    title = heroe.title,
                    description = heroe.description,
                    modifier = Modifier.weight(0.6F)
                )
                //Spacer(modifier.weight(0.05f))
                heroeItemButton(
                    modifier = Modifier.weight(0.1f),
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )

                iconoHeroe(
                    modifier = Modifier.weight(0.3f),
                    imaxeId = heroe.imaxeId
                )
            }
            if (expanded) {
                extraHeroe(extra = heroe.extra, modifier)
            }
        }
    }
}

@Composable
fun heroeItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}


@Composable
fun extraHeroe(
    @StringRes extra: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

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

@Composable
fun iconoHeroe(
    @DrawableRes imaxeId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_medium))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(imaxeId),
        contentDescription = null
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
            .padding(dimensionResource(id = R.dimen.padding_small))
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