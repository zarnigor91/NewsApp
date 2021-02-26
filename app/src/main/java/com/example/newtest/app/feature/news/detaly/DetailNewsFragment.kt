package com.example.newtest.app.feature.news.detaly

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.newtest.R
import kotlinx.android.synthetic.main.details_layout.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class DetailNewsFragment: MvpAppCompatFragment()  {

     private val args : DetailNewsFragmentArgs by navArgs()
//    @Inject
//    lateinit var provider: DetailPresenter
//
//    private val presenter by moxyPresenter { provider }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            tv_title.text = args.ttitle
        }

        Glide.with(this)
            .load(args.url)
            .centerCrop()
            .error(R.drawable.newss)
            .into(iv_news_main_Image)
        tv_description.text =  args.decript

//         bt_ok.setOnClickListener {
//             save_image.setImageBitmap(presenter.getBitmapFromView(liner_image))
//         }


    }

}