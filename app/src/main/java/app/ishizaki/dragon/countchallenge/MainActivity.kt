package app.ishizaki.dragon.countchallenge

import android.graphics.Color
import android.media.AudioManager
import android.media.SoundPool
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.ishizaki.dragon.countchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).apply { setContentView(this.root) }

        var countNumber: Int = 0

        val soundPool = SoundPool(1, AudioManager.STREAM_MUSIC, 0)

        val soundId: Int = soundPool.load(this, R.raw.sound, 1)


        binding.countButton.setOnClickListener {
            countNumber += 1
            binding.countText.text = countNumber.toString()

            when (countNumber%2==0) {
                true -> binding.countText.setTextColor(Color.BLUE)
                false -> {
                    binding.countText.setTextColor(Color.RED)
                    soundPool.play(soundId, 1.0F, 1.0F, 0, 0, 1.0F)
                }
            }

        }
    }
}