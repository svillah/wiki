package me.samv.wikipedia.wikipedia.activities

import android.app.SearchManager
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_search.*
import me.samv.wikipedia.R
import me.samv.wikipedia.wikipedia.adapters.ArticleListRecyclerAdapter
import me.samv.wikipedia.wikipedia.providers.ArticleDataProvider

class SearchActivity : AppCompatActivity() {

    private val articleProvider : ArticleDataProvider = ArticleDataProvider()
    private var adapter: ArticleListRecyclerAdapter = ArticleListRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        search_results_recycler.layoutManager = LinearLayoutManager(this)
        search_results_recycler.adapter =  adapter
    }

    //when home item is selected, finish activity and go back to previous
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item!!.itemId == android.R.id.home){
            finish()
        }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)

        val searchItem = menu!!.findItem(R.id.action_search)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView = searchItem!!.actionView as SearchView
        searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        searchView.setIconifiedByDefault(false)
        searchView.requestFocus() //item is expanded and focused when activity starts

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //handles submissions
            override fun onQueryTextSubmit(query: String): Boolean {
                //do search and update elements
                articleProvider.search(query, 0, 20, {wikiResult ->
                    adapter.currentResults.clear()
                    adapter.currentResults.addAll(wikiResult.query!!.pages)
                    runOnUiThread { adapter.notifyDataSetChanged() }
                })
                println("search updated!")

                return false
            }

            //handles text changes within search bars
            override fun onQueryTextChange(s: String): Boolean {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                return false
            }
        })


        return super.onCreateOptionsMenu(menu)

    }

}
