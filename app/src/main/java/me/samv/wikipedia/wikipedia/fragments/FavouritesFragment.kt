package me.samv.wikipedia.wikipedia.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_favourites2.*

import me.samv.wikipedia.R
import me.samv.wikipedia.wikipedia.adapters.ArticleCardRecyclerAdapter


/**
 * A simple [Fragment] subclass.
 */
class FavouritesFragment : Fragment() {

    var favouritesRecycler : RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_favourites2, container, false)

        favouritesRecycler = view.findViewById<RecyclerView>(R.id.favourites_article_recycler)
        favouritesRecycler!!.layoutManager = LinearLayoutManager(context)
        favouritesRecycler!!.adapter = ArticleCardRecyclerAdapter()

        return view;
    }

}// Required empty public constructor
