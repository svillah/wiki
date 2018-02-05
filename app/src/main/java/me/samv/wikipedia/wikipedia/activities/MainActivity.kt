package me.samv.wikipedia.wikipedia.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import me.samv.wikipedia.R
import me.samv.wikipedia.wikipedia.fragments.ExplorerFragment
import me.samv.wikipedia.wikipedia.fragments.FavouritesFragment
import me.samv.wikipedia.wikipedia.fragments.HistoryFragment

class
MainActivity : AppCompatActivity() {

//    instances of fragments as properties on activity
    private val exploreFragment: ExplorerFragment
    private val favouritesFragment: FavouritesFragment
    private val historyFragment: HistoryFragment

//    base constructor initialization
    init {
        exploreFragment = ExplorerFragment()
        favouritesFragment = FavouritesFragment()
        historyFragment = HistoryFragment()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out) //fun animations when switching fragments yeehaw

        when(item.itemId){ //Kotlin when = java switch, change container with appropriate fragment
            R.id.navigation_explore -> transaction.replace(R.id.fragment_container, exploreFragment)
            R.id.navigation_favourites -> transaction.replace(R.id.fragment_container, favouritesFragment)
            R.id.navigation_history -> transaction.replace(R.id.fragment_container, historyFragment)
        }

        transaction.commit()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, exploreFragment)
        transaction.commit()
    }
}
