package com.teamj.moneytransferapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.teamj.moneytransferapp.ui.screens.AddCardScreen
import com.teamj.moneytransferapp.ui.screens.CardAddedScreen
import com.teamj.moneytransferapp.ui.screens.CardSplashScreen
import com.teamj.moneytransferapp.ui.screens.OTPScreenBar

object  Route{
    const val SIGNUP = "signup"
    const val CONTINUE_SIGNUP = "continue_signup"
    const val PROFILE = "profile"
    const val PROFILE_INFO = "profile_info"
    const val TRANSFER_AMOUNT = "transfer_amount"
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

}
@Composable
fun AppNavHost(onSendNotification: () -> Unit,modifier: Modifier = Modifier){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Route.ADD_CARD) {
        composable(route = Route.ADD_CARD){ AddCardScreen(navController) }
        composable(route = Route.CARD_SPLASH){ CardSplashScreen(navController) }
        composable(route = Route.CARD_OTP){ OTPScreenBar(navController) }
        composable(route = Route.CARD_ADDED){ CardAddedScreen(navController) }
        composable(Route.SIGNUP) {
            SignupScreen(navController)
        }
        composable(Route.CONTINUE_SIGNUP) {
            CompleteProfileScreen(navController)
        }
        composable(route = Route.TRANSFER_PH1){ TransferScreen(navController) }
    }
}