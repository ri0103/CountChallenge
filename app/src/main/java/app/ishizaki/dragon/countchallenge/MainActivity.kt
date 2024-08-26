package app.ishizaki.dragon.countchallenge

import android.content.Context
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

        val sharedPref = getSharedPreferences("COUNT_PREFERENCE", Context.MODE_PRIVATE)

        var countNumber = sharedPref.getInt("COUNT", 0)

        val soundPool = SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        val soundId: Int = soundPool.load(this, R.raw.sound, 1)

        applyCountText(countNumber, soundPool, soundId)

        binding.countButton.setOnClickListener {
            countNumber += 1
            applyCountText(countNumber, soundPool, soundId)
            sharedPref.edit().putInt("COUNT", countNumber).apply()
        }
    }

    fun applyCountText(countNumber: Int, soundPool: SoundPool, soundId: Int){
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