package com.study.jetnotes.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDate(date: Date) : String = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault()).format(date)