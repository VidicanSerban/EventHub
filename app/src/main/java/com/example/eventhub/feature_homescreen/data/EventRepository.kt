package com.example.eventhub.feature_homescreen.data

import android.content.Context

class EventRepository(context: Context) {
    var db: EventDao = EventDatabase.getInstance(context)?.eventDao()!!


}