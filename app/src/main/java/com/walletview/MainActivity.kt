package com.walletview

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter

// Pantalla principal del dashboard. Usa la libreria externa MPAndroidChart
// para dibujar una grafica de pastel y una de barras con los gastos.
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mostrarGraficaPastel(findViewById(R.id.graficaPastel))
        mostrarGraficaBarras(findViewById(R.id.graficaBarras))
    }

    // Grafica de pastel: gastos del mes por categoria.
    private fun mostrarGraficaPastel(pastel: PieChart) {
        // Se convierte cada gasto en una porcion del pastel.
        val porciones = DatosDemo.gastosPorCategoria.map {
            PieEntry(it.monto, it.categoria)
        }

        val conjunto = PieDataSet(porciones, "")
        conjunto.colors = listOf(
            Color.parseColor("#0E7C66"), Color.parseColor("#2E4A7A"),
            Color.parseColor("#D35400"), Color.parseColor("#8E44AD"),
            Color.parseColor("#5B8AD0")
        )
        conjunto.valueTextColor = Color.WHITE
        conjunto.valueTextSize = 12f

        pastel.data = PieData(conjunto)
        pastel.description.isEnabled = false
        pastel.centerText = "Gastos\ndel mes"
        pastel.setEntryLabelColor(Color.WHITE)
        pastel.animateY(1000)   // animacion al mostrarse
        pastel.invalidate()     // redibuja la grafica
    }

    // Grafica de barras: gasto total de los ultimos meses.
    private fun mostrarGraficaBarras(barras: BarChart) {
        val entradas = DatosDemo.gastosPorMes.mapIndexed { i, gasto ->
            BarEntry(i.toFloat(), gasto.monto)
        }
        val meses = DatosDemo.gastosPorMes.map { it.categoria }

        val conjunto = BarDataSet(entradas, "Gasto mensual")
        conjunto.color = Color.parseColor("#0E7C66")
        conjunto.valueTextSize = 11f

        barras.data = BarData(conjunto)
        barras.description.isEnabled = false

        // Se ponen los nombres de los meses en el eje X.
        val ejeX = barras.xAxis
        ejeX.valueFormatter = IndexAxisValueFormatter(meses)
        ejeX.position = XAxis.XAxisPosition.BOTTOM
        ejeX.granularity = 1f
        ejeX.setDrawGridLines(false)

        barras.axisRight.isEnabled = false
        barras.animateY(1000)
        barras.invalidate()
    }
}
