package com.legalist.dinamicbroadcastreciervers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Broadcastingclass :BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
   val toast = Toast.makeText(context,"Battery low",Toast.LENGTH_LONG).show()
    }

}