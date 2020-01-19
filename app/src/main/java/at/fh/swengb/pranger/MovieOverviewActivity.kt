package at.fh.swengb.pranger

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_movie_overview.*
import kotlinx.android.synthetic.main.item_movie.view.*
import java.math.RoundingMode

class MovieOverviewActivity : AppCompatActivity() {

    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA"
        val ADD_OR_EDIT_RATING_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_overview)
        SleepyAsyncTask().execute()

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
            MovieRepository.movieById(
                id = movieId,

                success = {
                    Glide
                        .with(backdrop)
                        .load(it.backdropImagePath)
                        .into(backdrop)
                    Glide
                        .with(imageView3)
                        .load(it.posterImagePath)
                        .into(imageView3)


                    movie_title_header.text = it.title
                    movie_director_text.text = it.director?.name
                    movie_actors_text.text = it.actors?.joinToString { it.name }
                    movie_genre_text.text = it.genres.joinToString{ it }
                    movie_release_text.text = it.release
                    movie_plot_text.text = it.plot
                    item_movie_avg_rating_bar.rating = it.ratingAverage()?.toFloat()
                    item_movie_avg_rating_value.text = it.ratingAverage().toBigDecimal().setScale(2, RoundingMode.CEILING).toString()
                    item_movie_avg_rating_count.text = it.reviews?.count().toString()




                    setResult(Activity.RESULT_OK)
                },
                error = {
                    Log.e("error", it)
                }
            )




        }
    }
    override fun onCreateOptionsMenu(menu2: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu2, menu2)
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

            R.id.share -> consume { Toast.makeText(this, "@string/Share", Toast.LENGTH_SHORT).show() }
            else -> super.onOptionsItemSelected(item)
        }
    }

}

