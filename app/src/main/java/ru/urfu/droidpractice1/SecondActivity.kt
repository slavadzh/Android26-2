package ru.urfu.droidpractice1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import coil.load
import ru.urfu.droidpractice1.data.ArticleImages
import ru.urfu.droidpractice1.data.ArticlePrefs
import ru.urfu.droidpractice1.databinding.ActivitySecondBinding

class SecondActivity : ComponentActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener { onBackPressedDispatcher.onBackPressed() }
        binding.articleImage.load(ArticleImages.LEBRON_URL)

        val isRead = ArticlePrefs.isSecondArticleRead(this)
        binding.readSwitch.isChecked = isRead
        setReadResult(isRead)

        binding.readSwitch.setOnCheckedChangeListener { _, isChecked ->
            ArticlePrefs.setSecondArticleRead(this, isChecked)
            setReadResult(isChecked)
        }
    }

    private fun setReadResult(isRead: Boolean) {
        setResult(Activity.RESULT_OK, Intent().putExtra(EXTRA_IS_READ, isRead))
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        private const val TAG = "SecondActivity"
        const val EXTRA_IS_READ = "extra_is_read"
    }
}
