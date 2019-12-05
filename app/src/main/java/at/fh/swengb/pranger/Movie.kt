package at.fh.swengb.pranger

class Movie(val id : String, val title : String, val release : String,
            val plot : String, val genre : MovieGenre, val reviews : MutableList<Review>,
            val actors : List<Person>, val director : Person) {
    fun ratingAverage() : Double {
    var average = reviews.map { it.reviewValue }.average()

    if (average.isNaN()) {
        average = 0.0
    }

    return average
    }
}

