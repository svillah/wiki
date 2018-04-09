package me.samv.wikipedia.wikipedia.holders

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import me.samv.wikipedia.R
import me.samv.wikipedia.wikipedia.activities.ArticleDetailActivity
import me.samv.wikipedia.wikipedia.models.WikiPage

/**
 * Created by svillaluz on 2018-02-10.
 */
class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById<ImageView>(R.id.article_image)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.article_title)

    private val currentPage: WikiPage? = null

    //passes pg currently bound to viewholder into intent to start activity
    init{
        itemView.setOnClickListener{ view: View? ->
            var detailPageIntent = Intent(itemView.context, ArticleDetailActivity::class.java)
            var pageJson = Gson().toJson(currentPage)
            detailPageIntent.putExtra("page", pageJson)
            itemView.context.startActivity(detailPageIntent)
        }
    }

    //set current page, update data within the view
    fun updateWithPage(page: WikiPage){
        currentPage = page

        titleTextView.text = page.title

        //use picasso!!!
        if(page.thumbnail != null)
            Picasso.with(itemView.context).load(page.thumbnail!!.source).into(articleImageView)

    }

}