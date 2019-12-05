package at.fh.swengb.pranger

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val movieAdapter = MovieAdapter(){
        val intent = Intent(this, MovieOverviewActivity::class.java)
        intent.putExtra(EXTRA_MOVIE_ID, it.id)
        startActivityForResult(intent, ADD_OR_EDIT_RATING_REQUEST)
    }
    companion object {
        val EXTRA_MOVIE_ID = "MOVIE_ID_EXTRA"
        val ADD_OR_EDIT_RATING_REQUEST = 1
    }

    override fun onActivityResult(requestCode:Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_OR_EDIT_RATING_REQUEST && resultCode == Activity.RESULT_OK) {
            movieAdapter.updateList(MovieRepository.movieList())
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieAdapter.updateList(MovieRepository.movieList())
        movie_recycler_view.layoutManager = LinearLayoutManager(this)
        movie_recycler_view.adapter = movieAdapter

    }
}

