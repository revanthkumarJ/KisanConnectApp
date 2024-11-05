import androidx.compose.foundation.Image
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import com.example.kisanconnect.R
import com.example.kisanconnect.core.utilities.SocialMediaIcon
import com.example.kisanconnect.features.Screens.About.data.AboutUserProfileItem
import com.example.kisanconnect.ui.theme.KisanConnectTheme

@Composable
fun AboutUserCard(item: AboutUserProfileItem) {
    val context = LocalContext.current
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Card(
        modifier = Modifier
            .width(screenWidth * 0.95f) // 90% of screen width
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 20.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Image

            Image(
                painter = painterResource(id = item.image),
                contentDescription = item.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(50))
            )
            // Name and Role
            Text(
                text = item.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 4.dp)
            )
            Text(
                text = item.role,
                fontSize = 15.sp,
                color = MaterialTheme.colorScheme.primary
            )

            // Social Media Icons Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                SocialMediaIcon(
                    url = item.linkdeIn,
                    description = "LinkedIn",
                    context = context,
                    icon = R.drawable.icons8_linkedin
                )
                SocialMediaIcon(
                    url = item.github,
                    description = "GitHub",
                    context = context,
                    icon = R.drawable.icons8_github
                )
                SocialMediaIcon(
                    url = item.instagram,
                    description = "Instagram",
                    context = context,
                    icon = R.drawable.icons8_instagram
                )
                SocialMediaIcon(
                    url = item.facebook,
                    description = "Facebook",
                    context = context,
                    icon = R.drawable.icons8_facebook
                )
            }
        }
    }
}

// Preview of the AboutUserCard
@Composable
@Preview(showBackground = true)
fun AboutUserCardPreview() {
    val item = AboutUserProfileItem(
        name = "Revanth",
        role = "Team Lead",
        instagram = "https://www.instagram.com/yourprofile",
        linkdeIn = "https://www.linkedin.com/in/yourprofile",
        github = "https://github.com/yourprofile",
        facebook = "https://www.facebook.com/yourprofile",
        image = R.drawable.profile
    )
    KisanConnectTheme {
        AboutUserCard(item = item)
    }
}
