package com.example.newtest.app.feature.news.news

class NewsController {

    private var eventListener: RouteEventListener? = null

    fun setEventListener(eventListener: RouteEventListener?) {
        this.eventListener = eventListener
    }


    fun navigateOpenDateils() {
        eventListener?.onOpenDetails()
    }

    interface RouteEventListener {
        fun onOpenDetails()
    }
}