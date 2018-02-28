package com.bagrusss.widgetlistview

import android.widget.RemoteViews
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.widget.RemoteViewsService.RemoteViewsFactory
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by bagrusss on 28.02.2018
 */
class Factory constructor(private var context: Context, intent: Intent) : RemoteViewsFactory {

    internal lateinit var data: ArrayList<String>
    private val sdf: SimpleDateFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    private val widgetID = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
            AppWidgetManager.INVALID_APPWIDGET_ID)


    override fun onCreate() {
        data = ArrayList()
    }

    override fun getCount() = data.size

    override fun getItemId(position: Int) = position.toLong()

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewAt(position: Int): RemoteViews {
        val rView = RemoteViews(context.packageName, R.layout.item)
        rView.setTextViewText(R.id.tvItemText, data[position])

        val clickIntent = Intent()
        clickIntent.putExtra(WidgetProvider.ITEM_POSITION, position)
        rView.setOnClickFillInIntent(R.id.tvItemText, clickIntent)

        return rView
    }

    override fun getViewTypeCount() = 1

    override fun hasStableIds() = true

    override fun onDataSetChanged() {
        data.clear()
        data.add(sdf.format(Date(System.currentTimeMillis())))
        data.add(hashCode().toString())
        data.add(widgetID.toString())
        for (i in 3..14) {
            data.add("Item " + i)
        }
    }

    override fun onDestroy() {

    }

}