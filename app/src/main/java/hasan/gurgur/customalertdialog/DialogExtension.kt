package hasan.gurgur.customalertdialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isGone
import com.bumptech.glide.Glide

fun Context.showDialog(
    title: String? = null,
    description: String? = null,
    btn_pos: String? = null,
    btn_neg: String? = null,
    icon: Int? = null
) {


    val dialog = Dialog(this)
    dialog.window?.requestFeature(Window.FEATURE_NO_TITLE)
    dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.setCancelable(false)
    dialog.setContentView(R.layout.custom_dialog_layout)


    val titleTv = dialog.findViewById(R.id.dialog_title) as TextView
    val descriptionTv = dialog.findViewById(R.id.dialog_desc) as TextView
    val iconIv = dialog.findViewById(R.id.dialog_icon) as ImageView
    val buttonPossitive = dialog.findViewById<Button>(R.id.yes_btn)
    val buttonNegative = dialog.findViewById<Button>(R.id.no_btn)

    buttonPossitive.text = btn_pos
    buttonPossitive.isGone = btn_pos.isNullOrEmpty()

    buttonNegative.text = btn_neg
    buttonNegative.isGone = btn_neg.isNullOrEmpty()

    titleTv.text = title
    titleTv.isGone = title.isNullOrEmpty()

    descriptionTv.text = description
    descriptionTv.isGone = description.isNullOrEmpty()

    icon?.let { Glide.with(this).load(it).into(iconIv) } ?: iconIv.makeGone()


    buttonPossitive.setOnClickListener {
        Toast.makeText(this, "clicked  ${buttonPossitive.text}", Toast.LENGTH_SHORT).show()
    }
    buttonNegative.setOnClickListener {
        dialog.dismiss()
    }

    dialog.window?.setLayout(
        WindowManager.LayoutParams.MATCH_PARENT,
        WindowManager.LayoutParams.WRAP_CONTENT
    )
    dialog.window?.setGravity(Gravity.CENTER)
    dialog.show()


}

fun View.makeGone() {
    this.visibility = View.GONE
}