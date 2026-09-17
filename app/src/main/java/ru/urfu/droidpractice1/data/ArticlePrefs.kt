package ru.urfu.droidpractice1.data

import android.content.Context

object ArticlePrefs {

    private const val PREFS_NAME = "articles_prefs"
    private const val KEY_SECOND_ARTICLE_READ = "second_article_read"

    fun isSecondArticleRead(context: Context): Boolean {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getBoolean(KEY_SECOND_ARTICLE_READ, false)
    }

    fun setSecondArticleRead(context: Context, isRead: Boolean) {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(KEY_SECOND_ARTICLE_READ, isRead)
            .apply()
    }
}
