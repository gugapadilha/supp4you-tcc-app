package com.guga.supp4youapp.data.remote.database

data class Space(
   var id: Long,
   var groupName: String,
   var selectDays: String,
   var selectBeginTime: String,
   var selectEndTime: String,
   var timesTamp: Long
)

