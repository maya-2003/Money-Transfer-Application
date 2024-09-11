package com.teamj.moneytransferapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maya.moneytransferapp.FavoriteContactsScreen
import com.teamj.moneytransferapp.cards.AddCardScreen
import com.teamj.moneytransferapp.cards.CardAddedScreen
import com.teamj.moneytransferapp.cards.CardSplashScreen
import com.teamj.moneytransferapp.signup.CompleteProfileScreen
import com.teamj.moneytransferapp.cards.OTPScreenBar
import com.teamj.moneytransferapp.corefun.AlertDialog
import com.teamj.moneytransferapp.error.ErrorScreen
import com.teamj.moneytransferapp.home.HomeScreen
import com.teamj.moneytransferapp.more.ChangePasswordScreen
import com.teamj.moneytransferapp.more.EditProfileScreen
import com.teamj.moneytransferapp.more.MoreScreen
import com.teamj.moneytransferapp.more.ProfileInformationScreen
import com.teamj.moneytransferapp.more.ProfileScreen
import com.teamj.moneytransferapp.more.SettingsScreen
import com.teamj.moneytransferapp.nowifi.InternetErrorScreen
import com.teamj.moneytransferapp.onboarding.Onboarding
import com.teamj.moneytransferapp.corefun.rememberConnectivityState
import com.teamj.moneytransferapp.signin.SignInScreen
import com.teamj.moneytransferapp.signup.SignupScreen
import com.teamj.moneytransferapp.splash.SplashScreen
import com.teamj.moneytransferapp.transaction.SuccessfulTransactionScreen
import com.teamj.moneytransferapp.transaction.TransactionsScreen
import com.teamj.moneytransferapp.transfer.TransferAmountScreen
import com.teamj.moneytransferapp.transfer.TransferConfirmationScreen
import com.teamj.moneytransferapp.transfer.TransferPaymentScreen
import kotlinx.coroutines.delay

object  Route{
    const val SIGNUP = "signup"
    const val CONTINUE_SIGNUP = "continue_signup"
    const val PROFILE = "profile"
    const val PROFILE_INFO = "profile_info"
    const val TRANSFER_CONFIRM = "transfer_confirm"
    const val TRANSFER_PAYMENT = "transfer_payment"
    const val MORE = "more"
    const val NOTIFICATIONS = "notifications"
    const val LAST_TRANSACTIONS = "last_transactions"
    const val TRANSACTION = "transaction"
    const val ADD_CARD = "add_card"
    const val CARD_SPLASH = "card_splash"
    const val CARD_OTP = "card_otp"
    const val CARD_ADDED = "card_added"
    const val TRANSFER_PH1 = "transfer_ph1"
    const val SETTINGS = "settings"
    const val CHANGE_PASSWORD = "change_password"
    const val EDIT_PROFILE = "edit_profile"
    const val LOGIN = "login"
    const val FAVORITES = "favorites"
    const val ERROR = "error"
    const val HOME = "home"
    const val NO_WIFI = "no_wifi"
    const val ONBOARDING = "onboarding"
    const val SPLASH = "splash"

}
@Composable
fun AppNavHost(onSendNotification: () -> Unit,modifier: Modifier = Modifier){
    val navController= rememberNavController()
    val isConnected = rememberConnectivityState().value
    var connectionCheck by remember { mutableStateOf(false) }

    AlertDialog(navController = navController)

    LaunchedEffect(isConnected) {

        connectionCheck = true
        delay(2500)
        if (isConnected) {

            navController.navigate(Route.LOGIN)

        } else{

            navController.navigate(Route.NO_WIFI)
        }
    }

    NavHost(navController = navController, startDestination = Route.LAST_TRANSACTIONS) {
        composable(route = Route.ADD_CARD) { AddCardScreen(navController) }
        composable(route = Route.CARD_SPLASH) { CardSplashScreen(navController) }
        composable(route = Route.CARD_OTP) { OTPScreenBar(navController) }
        composable(route = Route.CARD_ADDED) { CardAddedScreen(navController) }
        composable(Route.SIGNUP) { SignupScreen(navController) }
        composable(Route.CONTINUE_SIGNUP) { CompleteProfileScreen(navController) }
        composable(route = Route.TRANSFER_PH1){ TransferAmountScreen(navController) }
        composable(route = Route.TRANSFER_CONFIRM){ TransferConfirmationScreen(navController) }
        composable(route = Route.TRANSFER_PAYMENT){ TransferPaymentScreen(navController) }
        composable(route = Route.LOGIN){ SignInScreen(navController) }
        composable(route = Route.TRANSACTION){ SuccessfulTransactionScreen(navController) }
        composable(route = Route.FAVORITES){ FavoriteContactsScreen(navController) }
        composable(route = Route.LAST_TRANSACTIONS){ TransactionsScreen(navController) }
        composable(route = Route.MORE){ MoreScreen(navController) }
        composable(route = Route.PROFILE){ ProfileScreen(navController) }
        composable(route = Route.PROFILE_INFO){ ProfileInformationScreen(navController) }
        composable(route = Route.SETTINGS){ SettingsScreen(navController) }
        composable(route = Route.EDIT_PROFILE){ EditProfileScreen(navController) }
        composable(route = Route.CHANGE_PASSWORD){ ChangePasswordScreen(navController) }
        composable(route = Route.ERROR){ ErrorScreen() }
        composable(route = Route.HOME){ HomeScreen(navController) }
        composable(route = Route.NO_WIFI){ InternetErrorScreen() }
        composable(route = Route.ONBOARDING){ Onboarding(navController) }
        composable(route = Route.SPLASH){ SplashScreen(navController) }

    }
}