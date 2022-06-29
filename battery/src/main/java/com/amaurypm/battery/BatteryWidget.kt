package com.amaurypm.battery

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorRes

class BatteryWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private var ivBattery: ImageView
    private var tvBatteryPercentage: TextView

    init{
        LayoutInflater.from(context).inflate(R.layout.battery, this, true)
        ivBattery = findViewById(R.id.ivBattery)
        tvBatteryPercentage = findViewById(R.id.tvBatteryPercentage)
    }

    fun setBatteryPercentage(percentage: Int) {
        if (percentage <= 100 && percentage > 80) ivBattery.setImageResource(R.drawable.bat5)
        else if (percentage <= 80 && percentage > 60) ivBattery.setImageResource(R.drawable.bat4)
        else if (percentage <= 60 && percentage > 40) ivBattery.setImageResource(R.drawable.bat3)
        else if (percentage <= 40 && percentage > 20) ivBattery.setImageResource(R.drawable.bat2)
        else if (percentage <= 20 && percentage > 0) ivBattery.setImageResource(R.drawable.bat1)
        else ivBattery.setImageResource(R.drawable.bat0)

        if(percentage <= 100 && percentage >= 0) tvBatteryPercentage.text = "$percentage%"
        else tvBatteryPercentage.text = "Error"

    }

    //Para que solamente acepte referencias del color
    fun setTextColor(@ColorRes color: Int) {
        tvBatteryPercentage.setTextColor(resources.getColor(color, null))
    }

    fun setTextSizeSP(percentage: Float) {
        tvBatteryPercentage.setTextSize(TypedValue.COMPLEX_UNIT_SP, percentage)
    }
}