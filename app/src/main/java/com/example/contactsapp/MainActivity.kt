package  com.example.contactsapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                                IconButton(
                                    onClick = {
                                        val mynumber = "0266544"
                                        val i = Intent(Intent.ACTION_DIAL).apply {
                                            data = Uri.parse("tel:$mynumber")
                                        }
                                        startActivity(i)
                                    }
                                ) {
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
// duplicated elements to test the gridScroll (:))
                    val contacts = listOf(
                        Contact("Aunt", "+02012345678", R.drawable.auntie),
                        Contact("Brother", "+02098765432", R.drawable.brother),
                        Contact("Daughter", "+02045678901", R.drawable.daughter),
                        Contact("Son", "01001273664", R.drawable.son),
                        Contact("Friend1", "01001273664", R.drawable.friend_1),
                        Contact("Friend1", "01001273664", R.drawable.friend_2),
                        Contact("GrandPa", "01001273664", R.drawable.grandfather),
                        Contact("GrandMa", "01001273664", R.drawable.granny),
                        Contact("Neighbour", "01001273664", R.drawable.neigbour),
                        Contact("Sister", "01001273664", R.drawable.sister),
                        Contact("Uncle", "01001273664", R.drawable.uncle),
                        Contact("Aunt", "+02012345678", R.drawable.auntie),
                        Contact("Brother", "+02098765432", R.drawable.brother),
                        Contact("Daughter", "+02045678901", R.drawable.daughter),
                        Contact("Son", "01001273664", R.drawable.son),
                        Contact("Friend1", "01001273664", R.drawable.friend_1),
                        Contact("Friend1", "01001273664", R.drawable.friend_2),
                        Contact("GrandPa", "01001273664", R.drawable.grandfather),
                        Contact("GrandMa", "01001273664", R.drawable.granny),
                        Contact("Neighbour", "01001273664", R.drawable.neigbour),
                        Contact("Sister", "01001273664", R.drawable.sister),
                        Contact("Uncle", "01001273664", R.drawable.uncle),


                        )

                    ContactsGrid(contacts, modifier = Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun ContactsItem(contact: Contact, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Card(
        onClick = {
            val phone = contact.phoneNumber
            val i = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:$phone")
            }
            context.startActivity(i)
        },
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize(),
        shape = RoundedCornerShape(8.dp)
    ) {

        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(contact.image),
                contentDescription = "",
                modifier = modifier
                    .size(88.dp)
            )
            Text(
                modifier = modifier
                    .padding(top = 8.dp),
                text = contact.name,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )

            SelectionContainer {

                Text(
                    text = contact.phoneNumber,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .selectable(
                            selected = true,
                            onClick = {}
                        )
                )
            }


        }

    }

}

@Composable
fun ContactsGrid(contacts: List<Contact>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        modifier = modifier
    ) {
        items(contacts.size) { index ->
            val contact = contacts[index]
            ContactsItem(contact)
        }
    }
}


//@Preview
//@Composable
// fun ContactListPreview() {
//
//}