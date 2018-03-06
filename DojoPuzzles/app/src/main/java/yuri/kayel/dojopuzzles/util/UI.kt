package yuri.kayel.bookofeulogies.util

/**
 * Created by kayel on 30/10/17.
 */

import android.content.Context
import android.widget.Toast

fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
