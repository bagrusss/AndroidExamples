package com.bagrusss.widgetlistview

import android.content.Intent
import android.widget.RemoteViewsService

/**
 * Created by bagrusss on 28.02.2018
 */
class UpdateService : RemoteViewsService() {

     override fun onGetViewFactory(intent: Intent): RemoteViewsFactory {
        return  Factory(applicationContext, intent)
     }

}