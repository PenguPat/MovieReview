package at.fh.swengb.pranger

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_overview.*
import kotlinx.android.synthetic.main.activity_movie_rating.*

class MovieRatingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rating)
        //SleepyAsyncTask().execute()

        val movieId = intent.getStringExtra("Data")


        if (movieId == null) {
            finish()
        } else {
            MovieRepository.movieById(
                id = movieId,
                success = {
                    movie_rating_header.text = it.title

                    rate_movie.setOnClickListener {
                        val myRating = movie_rating_bar.rating.toDouble()
                        val myFeedback = movie_feedback.text.toString()

                        val movieReview = Review(myRating, myFeedback)

                        MovieRepository.rateMovie(movieId, movieReview)

                        setResult(Activity.RESULT_OK)
                        finish()

                    }
                },
                error = {
                    Log.e("Error", it)
                })
                    //movie_title_header.text = MovieRepository.movieById(movieId).title
                    /*rate_movie.setOnClickListener {
                        val myRating = movie_rating_bar.rating.toDouble()
                        val myFeedback = movie_feedback.text.toString()

                        val movieReview = Review(myRating, myFeedback)

                        MovieRepository.rateMovie(movieId, movieReview)

                        setResult(Activity.RESULT_OK)
                        finish()

                    }*/


        }
    }
    override fun onCreateOptionsMenu(menu4: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu4, menu4)
        return true
    }
    inline fun consume(f: () -> Unit): Boolean {
        f()
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.logout -> consume { Toast.makeText(this, getString(R.string.ExitToMain), Toast.LENGTH_SHORT).show()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

            R.id.share -> consume { Toast.makeText(this, getString(R.string.Share), Toast.LENGTH_SHORT).show() }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
