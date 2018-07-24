package com.example.user.Madcow

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import com.example.user.Madcow.Model.Training
import java.util.*

/**
 * Created by User on 2018-05-29.
 */
fun Calendar.setDateToClosestMonday() {

    while (this.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) this.add(Calendar.DATE, 1)
}

fun Long.signum (): Int{
    if(this >0L ) return 1
    if(this == 0L) return 0
    return -1

}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}
fun TextView.toDouble() = this.text.toString().toDouble()
fun Training.getMainExcersizeForTrainig():String{
    val c = Calendar.getInstance()
    c.time = this.date
    when (c.get(Calendar.DAY_OF_WEEK)){
        Calendar.MONDAY ->return "Squat"
        Calendar.TUESDAY ->return "Bench"
        Calendar.THURSDAY -> return "Deadlift"
        Calendar.FRIDAY ->return "Military"
        else ->throw IllegalArgumentException("Wrong day of training")
    }

}