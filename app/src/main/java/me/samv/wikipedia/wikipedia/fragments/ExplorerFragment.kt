package me.samv.wikipedia.wikipedia.fragments


import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.CardView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_explorer.*

import me.samv.wikipedia.R
import me.samv.wikipedia.wikipedia.activities.SearchActivity
import me.samv.wikipedia.wikipedia.adapters.ArticleCardRecyclerAdapter
import me.samv.wikipedia.wikipedia.models.WikiResult
import me.samv.wikipedia.wikipedia.providers.ArticleDataProvider


/**
 * A simple [Fragment] subclass.
 */
class ExplorerFragment : Fragment() {

    private val articleProvider: ArticleDataProvider = ArticleDataProvider()
    var searchCardView: CardView? = null
    var exploreRecycler: RecyclerView? = null
    var refresher: SwipeRefreshLayout? = null
    var adapter: ArticleCardRecyclerAdapter = ArticleCardRecyclerAdapter()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_explorer, container, false)

        searchCardView = view.findViewById<CardView>(R.id.search_card_view)
        exploreRecycler = view.findViewById<RecyclerView>(R.id.explore_article_recycler)
        refresher = view.findViewById<SwipeRefreshLayout>(R.id.refresher)
        searchCardView!!.setOnClickListener{
            val searchIntent = Intent(context, SearchActivity::class.java)
            context.startActivity(searchIntent)
        }

        exploreRecycler!!.layoutManager = LinearLayoutManager(context)
        exploreRecycler!!.adapter = adapter

        refresher?.setOnRefreshListener{
            getRandomArticles()
        }

        getRandomArticles()

        return view;
    }

    //luv pull 2 refresh
    private fun getRandomArticles() {
        refresher?.isRefreshing = true


        try {
            articleProvider.getRandom(15, { wikiResult ->
                adapter.currentResults.clear()
                adapter.currentResults.addAll(wikiResult.query!!.pages)
                activity.runOnUiThread {
                    adapter.notifyDataSetChanged()
                    refresher?.isRefreshing = false
                }
            })
        }
        catch (ex: Exception){
            //show alrt
            val builder = AlertDialog.Builder(activity)
            builder.setMessage(ex.message).setTitle("Oh no!")
            val dialog = builder.create()
            dialog.show()
        }
    }

}// Required empty public constructor
