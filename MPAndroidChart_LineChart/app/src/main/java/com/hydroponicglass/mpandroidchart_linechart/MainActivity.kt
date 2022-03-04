package com.hydroponicglass.mpandroidchart_linechart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lineChart : LineChart = findViewById(R.id.lineChart)

        val entries = ArrayList<Entry>()

        // x, y coordinate
        entries.add(Entry(1f, 10f))
        entries.add(Entry(2f, 2f))
        entries.add(Entry(3f, 7f))
        entries.add(Entry(4f, 20f))
        entries.add(Entry(5f, 16f))

        var lineData = LineDataSet(entries, "legend")

        lineData.setCircleColor(R.color.purple_200) // circle color
        lineData.setCircleRadius(10f)// circle size
        lineData.setDrawCircleHole(false)
        lineData.setDrawCircles(true)
        lineData.setDrawHighlightIndicators(false) // ??
        lineData.setColor(R.color.purple_200) // line color
        lineData.setDrawValues(true)
        lineData.setDrawFilled(false) // fill below line
        lineData.setFillColor(R.color.purple_200) // color below line
        lineData.lineWidth = 5f
        lineData.setValueTextSize(20f)
        lineData.setValueTextColor(R.color.purple_200)


        lineChart.xAxis.labelRotationAngle = 0f
        lineChart.xAxis.setDrawAxisLine(false)
        lineChart.xAxis.setDrawGridLines(false)
        lineChart.xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // axis location
        lineChart.xAxis.setGranularity(1f) // ?
        lineChart.xAxis.setTextSize(20f)
        lineChart.xAxis.setTextColor(Color.rgb(118, 118, 118))
        lineChart.xAxis.setSpaceMin(0.1f) // left margin
        lineChart.xAxis.setSpaceMax(0.1f) // right margin

        lineChart.axisLeft.setDrawLabels(true   )
        lineChart.axisLeft.setTextColor(Color.rgb(163, 163, 163))
        lineChart.axisLeft.setTextSize(14f);
        lineChart.axisLeft.setDrawAxisLine(false)
        lineChart.axisLeft.setAxisLineWidth(0f)
        lineChart.axisLeft.setAxisMinimum(0f)

        lineChart.axisRight.setDrawLabels(false)
        lineChart.axisRight.setTextColor(Color.rgb(163, 163, 163))
        lineChart.axisRight.setTextSize(14f)
        lineChart.axisRight.setDrawAxisLine(false)
        lineChart.axisRight.setAxisLineWidth(0f)
        lineChart.axisRight.setAxisMinimum(0f)

        lineChart.getLegend().setEnabled(true) // legend hide
        lineChart.legend.setTextSize(13f)
        lineChart.legend.setFormSize(10f)
        lineChart.legend.setTextSize(13f)
        lineChart.legend.setTextColor(Color.parseColor("#A3A3A3"))
        lineChart.legend.setDrawInside(false)
        lineChart.legend.setYEntrySpace(5f)
        lineChart.legend.setWordWrapEnabled(true)
        lineChart.legend.setXOffset(80f)
        lineChart.legend.setYOffset(20f)
        lineChart.legend.getCalculatedLineSizes()

        lineChart.setExtraBottomOffset(15f);
        lineChart.data = LineData(lineData)
        lineChart.setTouchEnabled(true)
        lineChart.setPinchZoom(true)
        lineChart.description.text = "description"
        lineChart.getDescription().setEnabled(false)
        lineChart.setNoDataText("No forex yet!")

    }
}
