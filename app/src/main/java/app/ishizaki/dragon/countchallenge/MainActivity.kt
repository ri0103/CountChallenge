package app.ishizaki.dragon.countchallenge

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.ishizaki.dragon.countchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        var countNumber: Int = 0

        binding.countButton.setOnClickListener {
            countNumber += 1
            binding.countText.text = countNumber.toString()

            when (countNumber%2==0) {
                true -> binding.countText.setTextColor(Color.BLUE)
                false -> binding.countText.setTextColor(Color.RED)
            }

        }
    }
}