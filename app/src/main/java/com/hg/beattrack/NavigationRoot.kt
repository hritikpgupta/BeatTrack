package com.hg.beattrack

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.hg.auth.presentation.intro.IntroScreenRoot
import com.hg.auth.presentation.login.LoginScreenRoot
import com.hg.auth.presentation.register.RegisterScreenRoot

@Composable
fun NavigationRoot(
    navController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navController,
        startDestination = if (isLoggedIn) "run" else "auth"
    ) {
        authGraph(navController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation(
        startDestination = "intro",
        route = "auth"
    ) {
        composable(route = "intro") {
            IntroScreenRoot(onSignUpClick = {
                navController.navigate("register")
            }, onSignInClick = {
                navController.navigate("login")
            })
        }
        composable(route = "register") {
            RegisterScreenRoot(onSignInClick = {
                navController.navigate("login") {
                    popUpTo("register") {
                        inclusive = true
                        saveState = true
                    }
                    restoreState = true
                }
            }, onSuccessfulRegistration = {
                navController.navigate("login")
            })
        }
        composable(route = "login") {
            LoginScreenRoot(onLoginSuccess = {
                navController.navigate("run") {
                    popUpTo("auth") {
                        inclusive = true
                    }
                }
            }, onSignUpClick = {
                navController.navigate("register") {
                    popUpTo("login") {
                        inclusive = true
                        saveState = true
                    }
                    restoreState = true
                }
            })
        }


    }
}