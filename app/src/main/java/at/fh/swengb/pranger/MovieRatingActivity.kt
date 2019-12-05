package at.fh.swengb.pranger

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_rating.*

class MovieRatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)

        val movieId = intent.getStringExtra("Data")

        if (movieId == null) {
            finish()
        } else {
            movie_rating_header.text = MovieRepository.movieById(movieId)?.title
            rate_movie.setOnClickListener{
                val myRating = movie_rating_bar.rating.toDouble()
                val myFeedback = movie_feedback.text.toString()

                val movieReview = Review(myRating,myFeedback)

                MovieRepository.rateMovie(movieId, movieReview)

                setResult(Activity.RESULT_OK)
                finish()

            }
        }
    }
}
