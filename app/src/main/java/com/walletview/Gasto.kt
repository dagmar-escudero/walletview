package com.walletview

// Modelo sencillo de un gasto: la categoria y el monto gastado.
data class Gasto(
    val categoria: String,
    val monto: Float
)

// Datos de ejemplo del dashboard (en una app real vendrian de una base de datos o API).
object DatosDemo {

    // Gastos del mes por categoria (para la grafica de pastel)
    val gastosPorCategoria = listOf(
        Gasto("Comida", 3200f),
        Gasto("Transporte", 1500f),
        Gasto("Renta", 5000f),
        Gasto("Entretenimiento", 1200f),
        Gasto("Otros", 900f)
    )

    // Gasto total de los ultimos meses (para la grafica de barras)
    val gastosPorMes = listOf(
        Gasto("Jul", 9800f),
        Gasto("Ago", 10400f),
        Gasto("Sep", 8900f),
        Gasto("Oct", 11200f),
        Gasto("Nov", 11800f)
    )
}
