package me.samv.wikipedia.wikipedia.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.samv.wikipedia.R
import me.samv.wikipedia.wikipedia.holders.ListItemHolder

/**
 * Created by svillaluz on 2018-02-10.
 */
class ArticleListRecyclerAdapter() : RecyclerView.Adapter<ListItemHolder>() {

    override fun getItemCount(): Int { //num items recycler view will contain
        return 15
    }

    override fun onBindViewHolder(holder: ListItemHolder?, position: Int) { //how content gets updated on ViewHolder
        //will update view
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListItemHolder {
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_list_item, parent, false)
        return ListItemHolder(cardItem)
    }

}