package com.example.newtest.app.feature.news.news


import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import com.example.newtest.R
import com.example.newtest.data.datasourse.database.NewsDao
import com.example.newtest.data.model.NewsEntity
import com.example.newtest.data.model.toEntity
import com.example.newtest.data.repository.NewsRepository
import kotlinx.coroutines.launch
import moxy.MvpPresenter
import moxy.presenterScope
import javax.inject.Inject
import kotlin.properties.Delegates

class NewsPresenter @Inject constructor(
    private val newsRepository: NewsRepository,
    private val routerCOntroller: RouterCOntroller
) : MvpPresenter<NewsView>(){

    @SuppressLint("CheckResult")
    fun getNews() {
            newsRepository.getNews()
                .subscribe(
                    {
                        viewState.onNewsSuccess(it)
                        Log.wtf("NewsViewPresenter", "success items = $it")
                    },
                    {
                        viewState.onNewsError()
                        Log.wtf("NewsViewPresenter", "failed = error = $it")
                    }
                )
        }

    fun openDeta(title:String, url:String, decrite: String){
        routerCOntroller.navigateOpenDateils(title, url, decrite)
    }

        fun getBitmapFromView(view: View): Bitmap? {
        val bitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.WHITE)
        view.draw(canvas)
        val prntWidth = 384
        val ratio = prntWidth.toFloat() / view.width
        val prnHeight = (view.height * ratio).toInt()
        return Bitmap.createScaledBitmap(bitmap, prntWidth, prnHeight, true)
    }

}