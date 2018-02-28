package com.bagrusss.widgetlistview

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


/**
 * Created by bagrusss on 28.02.2018
 */
class WidgetProvider : AppWidgetProvider() {

    private var sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())


    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager,
                          appWidgetIds: IntArray) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        for (i in appWidgetIds) {
            updateWidget(context, appWidgetManager, i)
        }
    }

    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)

        when (intent.action) {
            ACTION_ON_CLICK -> {
                val itemPos = intent.getIntExtra(ITEM_POSITION, -1)
                if (itemPos != -1) {
                    Toast.makeText(context, "Clicked on item " + itemPos, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun updateWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
        val rv = RemoteViews(context.packageName, R.layout.widget)

        setUpdateTV(rv, context, appWidgetId)

        setList(rv, context, appWidgetId)

        setListClick(rv, context, appWidgetId)

        appWidgetManager.updateAppWidget(appWidgetId, rv)
        appWidgetManager.notifyAppWidgetViewDataChanged(appWidgetId, R.id.lvList)
    }

    private fun setUpdateTV(rv: RemoteViews, context: Context, appWidgetId: Int) {
        rv.setTextViewText(R.id.tvUpdate,
                sdf.format(Date(System.currentTimeMillis())))
        val updIntent = Intent(context, WidgetProvider::class.java)
        updIntent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        updIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS,
                intArrayOf(appWidgetId))
        val updPIntent = PendingIntent.getBroadcast(context,
                appWidgetId, updIntent, 0)
        rv.setOnClickPendingIntent(R.id.tvUpdate, updPIntent)
    }

    private fun setList(rv: RemoteViews, context: Context, appWidgetId: Int) {
        val adapter = Intent(context, UpdateService::class.java)
        adapter.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)

        val data = Uri.parse(adapter.toUri(Intent.URI_INTENT_SCHEME))
        adapter.data = data

        rv.setRemoteAdapter(R.id.lvList, adapter)
    }

    private fun setListClick(rv: RemoteViews, context: Context, appWidgetId: Int) {
        val listClickIntent = Intent(context, WidgetProvider::class.java)
        listClickIntent.action = ACTION_ON_CLICK
        val listClickPIntent = PendingIntent.getBroadcast(context, 0, listClickIntent, 0)
        rv.setPendingIntentTemplate(R.id.lvList, listClickPIntent)
    }

    companion object {
        const val ACTION_ON_CLICK = "com.bagrusss.widgetlistview.ACTION_ON_CLICK"
        const val ITEM_POSITION = "ITEM_POSITION"
    }

}