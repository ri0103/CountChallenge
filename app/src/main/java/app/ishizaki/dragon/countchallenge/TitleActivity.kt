package app.ishizaki.dragon.countchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import app.ishizaki.dragon.countchallenge.databinding.ActivityTitleBinding

class TitleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTitleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTitleBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        binding.startButton.setOnClickListener {
            val mainIntent = Intent(this, MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
}