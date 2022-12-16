package com.hydroponicglass.mpandroidchartpiechart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pieChart : PieChart = findViewById(R.id.piechart)

        with(pieChart){
            setUsePercentValues(false)
            description.isEnabled = false
            setExtraOffsets(0f, 0f, 0f, 0f)
            isDrawHoleEnabled = true
            holeRadius = 30f
            setHoleColor(Color.WHITE)
            transparentCircleRadius = 0f
            setDrawEntryLabels(false)
            setDrawCenterText(false)

            val yValues: ArrayList<PieEntry> = ArrayList()
            with(yValues) {
                add(PieEntry(10.0f, "a"))
                add(PieEntry(20.0f, "b"))
                add(PieEntry(30.0f, "c"))
            }

            animateY(1000, Easing.EaseInOutCubic)

            val colors: ArrayList<Int> = ArrayList()

            colors.add(resources.getColor(R.color.purple_200))
            colors.add(resources.getColor(R.color.teal_200))
            colors.add(resources.getColor(R.color.black))

            colors.add(ColorTemplate.getHoloBlue())

            val legend : Legend = getLegend()
            legend.isEnabled = false


            val dataSet: PieDataSet = PieDataSet(yValues, "")
            with(dataSet) {
                setDrawValues(false)
                sliceSpace = 5f
                selectionShift = 5f
                dataSet.colors = colors

//                setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
//                setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
            }

            val pieData: PieData = PieData(dataSet)
            with(pieData) {
                setValueTextSize(10f)
                setValueTextColor(Color.BLACK)

/* description  */
//                val des = Description()
//                des.text = "Test"
//                description = des

            }
            data = pieData
            invalidate() // refresh
        }
    }
}