package me.samv.wikipedia.wikipedia.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_article_detail.*
import me.samv.wikipedia.R
import me.samv.wikipedia.wikipedia.models.WikiPage

/**
 * Created by svillaluz on 2018-02-03.
 */
class ArticleDetailActivity : AppCompatActivity() {

    private var currentPage: WikiPage? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)

        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true); //sets back button on LHS next to title

        //get the page from the extras
        val wikiPageJson = intent.getStringExtra("page")
        currentPage = Gson().fromJson<WikiPage>(wikiPageJson, WikiPage::class.java)
        
        article_detail_webview?.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return true
            }
        }
        article_detail_webview.loadUrl(currentPage!!.fullurl)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean { //handles when back button is hit
        if(item!!.itemId == android.R.id.home){
            finish()
        }
        return true;
    }


}