package me.samv.wikipedia.wikipedia.providers

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import me.samv.wikipedia.wikipedia.models.Urls
import me.samv.wikipedia.wikipedia.models.WikiResult
import java.io.Reader

/**
 * Created by svillaluz on 2018-03-04.
 */
class ArticleDataProvider {

//    //set user agent so we dont spam wiki - unresolved reference so i guess fate doesnt want me to respect
//    init{
//        FuelManager.instance.baseHeaders = mapOf(pair "User-Agent" to "Sam Wiki")
//    }

    fun search(term: String, skip: Int, take: Int, responseHandler: (result: WikiResult) -> Unit?){
        Urls.getSearchUrl(term, skip, take).httpGet()
                .responseObject(WikipediaDataDeserializer()){ _, response, result ->

                    if(response.httpStatusCode != 200){
                        throw Exception("Can't get articles ahh")
                    }
                    val(data, _) = result //2 object types: data and error
                    responseHandler.invoke(data as WikiResult)
                }
    }

    fun getRandom(take: Int, responseHandler: (result: WikiResult) -> Unit?){
        Urls.getRandomUrl(take).httpGet()
                .responseObject(WikipediaDataDeserializer()){ _, response, result ->

                    if(response.httpStatusCode != 200){
                        throw Exception("Can't get articles ahh")
                    }
                    val(data, _) = result
                    responseHandler.invoke(data as WikiResult)
                }
    }


    class WikipediaDataDeserializer : ResponseDeserializable<WikiResult> {
        override fun deserialize(reader: Reader) = Gson().fromJson(reader, WikiResult::class.java)
    }
}