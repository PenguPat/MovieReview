package at.fh.swengb.pranger

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class MovieDetail(val plot : String, val genres : List<String>,
                       val actors : List<Person>, val director : Person, id: String, title: String,
                       release: String, posterImagePath: String, backdropImagePath: String,
                       reviews: MutableList<Review>) : Movie(id, title, release, posterImagePath, backdropImagePath, reviews)

