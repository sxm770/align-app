class HoroscopeRepository {
    val zodiacSign = "gemini"
    val date = "today"
//    private val horoscopeApi = HoroscopeApi.getHoroscope(zodiacSign, date)

//    fun getHoroscope(zodiacSign: String, date: String, onSuccess: (Horoscope) -> Unit, onError: (Throwable) -> Unit) {
//        viewModelScope.launch {
//            try {
//                val horoscope = HoroscopeApi.getHoroscope(zodiacSign, date).await()
//                onSuccess(horoscope)
//            } catch (t: Throwable) {
//                onError(t)
//            }
//        }
//    }
}



//As a convention, it's common to put API calls in a separate file, often referred to as a "repository"
//or "data source", that is responsible for handling data operations, such as making API calls, in your app.
//This separates the concerns of data management from the rest of your app's logic, making your code easier to
//maintain and test.
//
//In Android, it's common to have one repository per feature, or one repository for the entire app, depending
//on the complexity of the app. For example, if you have a feature for displaying a list of articles, you might
//have an ArticleRepository class that is responsible for fetching the articles from the API and returning them
//to the rest of the app.
//
//Here's an example of what a simple repository class might look like in Kotlin:
//
//kotlin
//Copy code
//class ArticleRepository {
//    private val exampleApi = ApiClient.getClient(param1, param2)
//
//    suspend fun getArticles(): List<Article> {
//        return exampleApi.getArticles()
//    }
//}
//In this example, the ArticleRepository class has a private exampleApi field that stores an instance of
//the ExampleApi interface, just like in the previous example. The getArticles method is used to make the API
//call to retrieve a list of articles, and the response is returned to the caller.
//
//By having a separate repository class, you can encapsulate all of the logic for fetching and manipulating
//data in one place, making it easier to maintain and test your code. You can also reuse the repository across
//different parts of your app, such as multiple activities or fragments, without having to duplicate the code for
//making API calls.