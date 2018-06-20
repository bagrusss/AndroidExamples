package ru.bagrusss.clean_mvvm.provider

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * Created by bagrusss on 20.06.2018
 */
class ResourceProviderImpl(private val context: Context): ResourceProvider {

    override fun provideString(resId: Int): String = context.getString(resId)

    override fun provideColor(resId: Int): Int {
        return ContextCompat.getColor(context, resId)
    }
}