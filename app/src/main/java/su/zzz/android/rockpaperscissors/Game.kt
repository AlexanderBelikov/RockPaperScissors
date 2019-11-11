package su.zzz.android.rockpaperscissors

enum class Option(val dId:Int) {
    ROCK(R.drawable.o_rock){
        override fun beat(other: Option): Boolean = other==SCISSORS
    },
    PAPER(R.drawable.o_paper){
        override fun beat(other: Option): Boolean = other==ROCK
    },
    SCISSORS(R.drawable.o_scissors){
        override fun beat(other: Option): Boolean = other==PAPER
    };
    abstract fun beat(other:Option):Boolean
}

fun getGameChoice():Option = Option.values().random()
