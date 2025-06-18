import com.example.newsapp.feature_news_page.domain.model.NewsItem

data class NewsResponse (
    val status: String,
    val totalResults: Int,
    val articles: List<NewsItem>
)