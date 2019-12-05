package at.fh.swengb.pranger

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_movie_overview.*
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieOverviewActivity : AppCompatActivity() {

    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA"
        val ADD_OR_EDIT_RATING_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_overview)

        open_rating.setOnClickListener {
            val data = intent.getStringExtra(EXTRA_MOVIE_ID)
            val intent = Intent(this, MovieRatingActivity::class.java)
            intent.putExtra("Data", data)
            startActivityForResult(intent, ADD_OR_EDIT_RATING_REQUEST)

        }
        overwriteOverview()
    }

        override fun onActivityResult(requestCode:Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == MainActivity.ADD_OR_EDIT_RATING_REQUEST && resultCode == Activity.RESULT_OK)
            {
                setResult(Activity.RESULT_OK)
                overwriteOverview()
            }
        }
    fun overwriteOverview() {


        val movieId = intent.getStringExtra(EXTRA_MOVIE_ID)


        if (movieId == null) {
            finish()
        } else
        {
            movie_title_header.text = MovieRepository.movieById(movieId)?.title
            movie_director_text.text = MovieRepository.movieById(movieId)?.director?.name
            movie_actors_text.text = MovieRepository.movieById(movieId)?.actors?.joinToString { it.name }
            movie_genre_text.text = MovieRepository.movieById(movieId)?.genre.toString()
            movie_release_text.text = MovieRepository.movieById(movieId)?.release
            movie_plot_text.text = MovieRepository.movieById(movieId)?.plot
            item_movie_avg_rating_bar.rating = MovieRepository.movieById(movieId)?.ratingAverage()!!.toFloat()
            item_movie_avg_rating_value.text = MovieRepository.movieById(movieId)?.ratingAverage().toString()
            item_movie_avg_rating_count.text = MovieRepository.movieById(movieId)?.reviews!!.count().toString()
            


                setResult(Activity.RESULT_OK)
        }
    }

}

