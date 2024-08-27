package  com.example.contactsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.contactsapp.ui.theme.ContactsAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactsAppTheme {
                Scaffold(

                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            actions = {
                                IconButton(onClick = {}) {
                                    Icon(
                                        painter = painterResource(
                                            id = R.drawable.home
                                        ),
                                        contentDescription = "Icon"
                                    )

                                }
                            },
                            colors = topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer,
                                titleContentColor = Color.Black,
                            ),
                            title = {
                                Text(
                                    text = "Contacts App",
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                                    )
                                )

                            }
                        )
                    }
                ) { innerPadding ->
                    ContactList()
                }
            }
        }
    }
}

@Composable
fun ContactList(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns =
    ) {

    }
}

@Preview
@Composable
 fun ContactListPreview() {

}