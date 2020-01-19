package at.fh.swengb.pranger

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Review(var reviewValue : Double, var reviewText : String)
