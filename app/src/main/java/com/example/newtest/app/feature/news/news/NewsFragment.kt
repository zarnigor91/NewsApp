package com.example.newtest.app.feature.news.news

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newtest.R
import com.example.newtest.app.feature.news.NewsAdapter
import com.example.newtest.data.model.NewsEntity
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_news.*
import kotlinx.android.synthetic.main.toolbar.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class NewsFragment : MvpAppCompatFragment(), NewsView {

    private var adapter: NewsAdapter? = null

    @Inject
    lateinit var provider: NewsPresenter

    @Inject
    lateinit var controllerNews: RouterCOntroller

    private val presenter by moxyPresenter { provider }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controllerNews.setNavController(findNavController())

        adapter = NewsAdapter(requireContext(), action = { action(it) })
        rv_news_list.layoutManager = LinearLayoutManager(this.context)
        rv_news_list.adapter = adapter
        presenter.getNews()

        sv_text.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter!!.filter.filter(p0)
                return true
            }
        })

        ic_toolbar_refresh.setOnClickListener {
            image_photo.visibility = View.VISIBLE
            image_photo.setImageBitmap(presenter.getBitmapFromView(liner_image))
        }
        image_cancel.setOnClickListener {
            image_photo.visibility = View.GONE
        }
    }

    override fun onNewsSuccess(news: List<NewsEntity>) {
        pb_loading.visibility = View.GONE
        adapter?.updateNews(news)
    }

    override fun onNewsError() {
        pb_loading.visibility = View.GONE
    }

    override fun action(newsItem: NewsEntity) {
        presenter.openDeta(newsItem.title!!, newsItem.multimedia!![0].url!!, newsItem.abstract!!)
    }

    override fun actionTitle(title: String, url: String, decrict: String) {
        TODO("Not yet implemented")
    }



}