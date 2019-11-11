package su.zzz.android.rockpaperscissors

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        val vId = v?.id
        var userChoose = when (vId) {
            R.id.iv_rock -> Option.ROCK
            R.id.iv_scissors -> Option.SCISSORS
            R.id.iv_paper -> Option.PAPER
            else -> throw Exception("Unknown Option")
        }
        var gameChoice = getGameChoice()
        ivGameChoose.setImageDrawable(resources.getDrawable(gameChoice.dId))

        if (userChoose!=gameChoice)
            if (userChoose.beat(gameChoice))
                ivState.setImageDrawable(resources.getDrawable(R.drawable.r_win))
            else
                ivState.setImageDrawable(resources.getDrawable(R.drawable.r_lose))
        else
            ivState.setImageDrawable(resources.getDrawable(R.drawable.a_choose))
    }

    private val TAG : String = MainActivity::class.java.simpleName
    private lateinit var ivState : ImageView
    private lateinit var ivGameChoose : ImageView
    private lateinit var ivRock : ImageView
    private lateinit var ivScissors : ImageView
    private lateinit var ivPaper : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivState = findViewById(R.id.iv_state)
        ivGameChoose = findViewById(R.id.iv_game_choose)
        ivRock = findViewById(R.id.iv_rock)
        ivScissors = findViewById(R.id.iv_scissors)
        ivPaper = findViewById(R.id.iv_paper)

        ivRock.setOnClickListener(this)
        ivScissors.setOnClickListener(this)
        ivPaper.setOnClickListener(this)
    }


    override fun onStart() {
        super.onStart()
    }
}
