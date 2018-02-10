package me.samv.wikipedia.wikipedia.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_explorer.*

import me.samv.wikipedia.R
import me.samv.wikipedia.wikipedia.activities.SearchActivity


/**
 * A simple [Fragment] subclass.
 */
class ExplorerFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_explorer, container, false)

        search_card_view.setOnClickListener{
            val searchIntent = Intent(context, SearchActivity::class.java)
            context.startActivity(searchIntent)
        }
    }

}// Required empty public constructor
