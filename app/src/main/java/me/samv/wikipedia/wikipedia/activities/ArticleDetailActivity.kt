package me.samv.wikipedia.wikipedia.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_article_detail.*
import me.samv.wikipedia.R

/**
 * Created by svillaluz on 2018-02-03.
 */
class ArticleDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true); //sets back button on LHS next to title
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean { //handles when back button is hit
        if(item!!.itemId == android.R.id.home){
            finish()
        }
        return true;
    }


}