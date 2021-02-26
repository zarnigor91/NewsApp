package com.example.newtest.app.feature.news.news

import androidx.navigation.NavController
import com.example.newtest.R

class RouterCOntroller {
    private var navController: NavController? = null

    fun setNavController(navController: NavController?) {
        this.navController =navController
    }

    fun navigateOpenDateils(title:String, url:String, decrite: String) {
        val action = NewsFragmentDirections.actionNewsFragmentToDetalyNewsFragment(title, url, decrite)
        navController?.navigate(action)
    }

}