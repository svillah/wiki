package me.samv.wikipedia.wikipedia.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import me.samv.wikipedia.R
import me.samv.wikipedia.wikipedia.models.WikiPage

/**
 * Created by svillaluz on 2018-02-10.
 */
class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById<ImageView>(R.id.result_icon)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.result_title)
    private val currentPage: WikiPage? = null

    fun updateWithPage(page: WikiPage){
        if(page.thumbnail != null)
            Picasso.with(itemView.context).load(page.thumbnail!!.source).into(articleImageView)

        titleTextView.text = page.title

        currentPage = page
    }

}