package at.fh.swengb.pranger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movie.view.*

class MovieAdapter(val clickListener: (movie: Movie) -> Unit): RecyclerView.Adapter<MovieViewHolder>() {
    private var movieList = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieItemView = inflater.inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(movieItemView, clickListener)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var movie = movieList[position]
        holder.bindItem(movie)
    }
    fun updateList(newList: List<Movie>) {
        movieList = newList
        notifyDataSetChanged()
    }
}

class MovieViewHolder(itemView: View, val clickListener: (movie: Movie) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun bindItem(movie: Movie) {
        itemView.item_movie_title.text = movie.title
        itemView.item_movie_release.text = movie.release
        itemView.item_movie_director.text = movie.director.name
        itemView.item_movie_actors.text = movie.actors.elementAt(0).name  
        itemView.item_movie_actors2.text = movie.actors.elementAt(1).name
        itemView.item_movie_avg_rating_bar.rating = movie.ratingAverage().toFloat()
        itemView.item_movie_avg_rating_value.text = movie.ratingAverage().toString()
        itemView.item_movie_avg_rating_count.text = movie.reviews.count().toString()

        itemView.setOnClickListener {
            clickListener(movie)
        }
    }

}