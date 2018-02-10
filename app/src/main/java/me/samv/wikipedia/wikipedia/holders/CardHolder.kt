package me.samv.wikipedia.wikipedia.holders

import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by svillaluz on 2018-02-10.
 */
class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById<ImageView>(R.id.article_image)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.article_title)

}