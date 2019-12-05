package at.fh.swengb.pranger

object MovieRepository {
    private val movies: List<Movie>

    init {
        movies = listOf(
            Movie("0",
            "Halloween - The night of horror",
            "1978",
            "On Halloween night 1963, six-year-old Michael Myers kills his 17-year-old sister " +
                    "Judith with a kitchen knife at her home in Haddonfield, Illinois, whereupon he " +
                    "is admitted to Smith's Grove Warren County Sanatorium. There he is taken into " +
                    "the care of the psychiatrist Dr. Sam Loomis. Loomis discovers an enormous " +
                    "amount of anger behind the little boy's staring and calls him \"evil\".",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Nick Castle","."), Person("Donald Pleasence",".")),
                director = Person("John Carpenter",".")
            ),
            Movie("1",
                "Blair Witch Project",
                "1999",
                "The three students Heather Donahue, Josh Leonard and Michael \"Mike\" C. " +
                        "Williams are planning a trip to Burkittsville, Maryland and surroundings " +
                        "to shoot a documentary about the witch of Blair. All the footage the " +
                        "audience sees comes from the three students, who have a video camera and a " +
                        "16mm film camera with them throughout.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("HeatherDonahue","."), Person("Joshua Leonard",".")),
                director = Person("Daniel Myrick",".")
            ),
            Movie("2",
                "Paranormal Activity",
                "2007",
                "The film is about a young couple, Katie and Micah, who are haunted by a " +
                        "demonic presence in their own house. The image of the film consists " +
                        "exclusively of the camera shots of the couple, which were set up to record " +
                        "the ghost activities.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Katie Featherston","."), Person("Micah Sloat",".")),
                director = Person("Oren Peli",".")
            ),
            Movie("3",
                "Carnival of Souls",
                "1962",
                "Mary goes to Salt Lake City, where she has accepted a new position as an " +
                        "organist in a local church. As she drives past an old abandoned fairground " +
                        "on her way there, a man's face appears for the first time in the window of " +
                        "her car. From now on, the appearance of this undead man haunts her again " +
                        "and again with increasing intensity.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Candace Hilligoss","."), Person("FrancesFeist",".")),
                director = Person("Herk Harvey",".")
            ),
            Movie("4",
                "Kill List",
                "2011",
                "Jay is still suffering from an unexplained catastrophic mission in Kiev. " +
                        "Despite pressure from his wife Shel, he hasn't worked since, and they run " +
                        "out of money. Shel hosts a party to which she invites Gal and his new " +
                        "friend Fiona, a human resources manager. During the evening, Gal reveals " +
                        "that he has a new job for her; Shel encourages Jay to accept him.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Neil Maskell","."), Person("MyAnna Buring",".")),
                director = Person("Ben Wheatley",".")
            ),
            Movie("5",
                "Halloween II",
                "1981",
                "The events of the first part are seamlessly followed up. It is the same night " +
                        "and Michael Myers disappeared without a trace after falling out of the " +
                        "window. Dr. Loomis and the Sheriff try to find him while he is murderously " +
                        "on his way to the hospital where the visibly shocked Laurie was admitted.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Nick Castle","."), Person("Donald Pleasence",".")),
                director = Person("John Carpenter",".")
            ),
            Movie("6",
                "Halloween III",
                "1982",
                "The film tells the story of a doctor who uncovers a conspiracy: The toy " +
                        "manufacturer of the company \"Silver Shamrock\" tries to kill thousands of " +
                        "children with remote controlled and prepared Halloween masks.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Tom Atkins","."), Person("Stacey Nelkin",".")),
                director = Person("Tommy Lee Wallace",".")
            ),
            Movie("7",
                "Insidious",
                "2010",
                "Josh Lambert und seine Frau Renai haben für sich und ihre drei Kinder ein " +
                        "Einfamilienhaus bezogen, doch schon bald nach dem Einzug passieren " +
                        "mysteriöse Dinge. Sie hören Schritte auf dem Dachboden und Stimmen aus dem " +
                        "Babyfon. ",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Patrick Wilson","."), Person("Rose Byrne",".")),
                director = Person("James Wan",".")
            ),
            Movie("8",
                "Insidious: Chapter 2",
                "2013",
                "After Josh was able to bring his son Dalton back from the coma, the family " +
                        "now seeks refuge with grandmother Lorraine. Renai and Josh Lambert believe " +
                        "they are safe and try to lead a normal life. Soon, however, they are again " +
                        "haunted by uncanny events. Dalton again seems to be especially receptive " +
                        "to these supernatural phenomena and recognizes the increasing danger.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Patrick Wilson","."),Person("Rose Byrne",".")),
                director = Person("JamesWan",".")
            ),
            Movie("9",
                "Insidious: Chapter 3",
                "2015",
                "In order to cope with the loss of her recently deceased mother, Quinn sets " +
                        "out in search of the clairvoyant Elise, who had actually renounced her " +
                        "gift. Quinn feels sorry for her and tries to get in touch with her mother, " +
                        "which fails because of a demon in the shape of an old woman, who again and " +
                        "again predicted her imminent death at the hands of the demon.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Dermot Mulroney","."), Person("Stefanie Scott",".")),
                director = Person("Leigh Whannell",".")
            ),
            Movie("10",
                "Sharknado",
                "2013",
                "on board a Russian fishing cutter, thousands of live sharks are stashed. " +
                        "A dispute between the captain and an Asian businessman causes the ship to " +
                        "get out of control and the entire crew is killed by the sharks in a storm. " +
                        "The storm turns into a tornado and meets Los Angeles, whirling the sharks " +
                        "and tons of salt water into the city.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Ian Ziering","."), Person("Cassie Scerbo",".")),
                director = Person("Anthony C. Ferrante",".")
            ),
            Movie("11",
                "Sand Sharks",
                "2011",
                "An earthquake off the island of White Sands frees several prehistoric sharks " +
                        "from a submarine crater and heads for the land. Meanwhile, preparations " +
                        "are underway on the island for the Sandman Festival during the Spring Break," +
                        "to be hosted by Jimmy Green, the mayor's son.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Corin Nemec","."), Person("Brooke Hogan",".")),
                director = Person("Mark Atkins",".")
            ),
            Movie("12",
                "Braindead",
                "1992",
                "In 1957 a zoologist discovered a new species, a cross between a monkey and a " +
                        "rat, on an island off the coast of Sumatra called Skull Island. This animal " +
                        "was soon found in the zoo of Wellington, New Zealand. Lionel Cosgrove also " +
                        "lives in the same city, a rather delicately strung mother's boy with whom " +
                        "pretty Paquita falls in love. ",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Timothy Balme","."), Person("Diana Penalver",".")),
                director = Person("Peter Jackson",".")
            ),
            Movie("13",
                "Rubber",
                "2010",
                "A car tire comes to life. He kills smaller animals, first by rolling them over," +
                        " later with a kind of telekinesis that causes the animals to explode. " +
                        "The tire finally comes to a highway on which a young woman is " +
                        "passing by. Using telekinesis, the car tire brings the vehicle to a " +
                        "standstill and approaches the woman, but at the last moment is hit by " +
                        "another careless driver...",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("Stephen Spinella","."), Person("Jack Plotnick",".")),
                director = Person("Quentin Dupieux",".")
            ),
            Movie("14",
                "From Dusk till Dawn",
                "1996",
                "The brothers Richard and Seth Gecko are after a prison break and a bank " +
                        "robbery in which several people died, with three women hostage on the run " +
                        "to Mexico, the FBI and the Texas police close on their heels. While Seth " +
                        "has his emotions under control, Richard shows himself to be a choleric, " +
                        "maladjusted sexual criminal.",
                MovieGenre.HORROR,
                reviews = mutableListOf(),
                actors = listOf( Person("George Clooney","."), Person("Quentin Tarantino",".")),
                director = Person("Robert Rodriguez",".")
            )

        )
    }
    fun movieList(): List<Movie> {
        return movies
    }
    fun movieById(id: String): Movie? {
        return movies.find { it.id == id }
    }
    fun rateMovie(id: String, rating: Review) {
        movieById(id)?.reviews?.add(rating)
    }
}