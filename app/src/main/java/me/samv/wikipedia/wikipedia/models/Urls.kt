package me.samv.wikipedia.wikipedia.models

/**
 * Created by svillaluz on 2018-02-10.
 */
object Urls {
    val BaseUrl = "https://en.wikipedia.org/w/api.php"

//    static fun that will help create http request
    fun getSearchUrl(term: String, skip: Int, take: Int) : String{
        return BaseUrl + "?action=query" +
                "&formatversion=2" +
                "&generator=prefixsearch" +
                "&gpssearch=$term" +
                "&gpslimit=$take" +
                "&gpsoffset=$skip" +
                "&prop=pageimages|info" +
                "&piprop=thumbnail|url" +
                "&pithumbsize=200" +
                "&pilimit=$take" +
                "&wbptterms=description" +
                "&format=json" +
                "&inprop=url"


    }

//    get set of random articles for explore page
    fun getRandomUrl(take: Int) : String {
        return BaseUrl + "?action=query" +
                "&format=json" +
                "&formatversion=2" +
                "&generator=random" +
                "&grnnamespace=0" +
                "&prop=pageimages|info" +
                "&grnlimit=$take" +
                "&inprop=url" +
                "&pitthumbsize=200"

    }
}