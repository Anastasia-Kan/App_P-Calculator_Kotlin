package com.example.pressurecalcapp

import java.lang.Math.pow
import kotlin.math.roundToLong

class CalculationMethods {

    companion object{
        fun Mao(B: Double, lambda0: Double, lambda : Double) : Double
        {
            val A = 1904
            val m1 = A / B
            val m2 = lambda / lambda0
            val m3 = pow(m2, B)
            val m4 = m1 * m3
            return (m4 - m1)
        }

        fun Shen(lambda0 : Double, lambda: Double) : Double
        {
            val A = 1870.0
            val B = 5.63
            val deltaLambda = lambda - lambda0
            val sh1 = deltaLambda / lambda0
            val sh2 = A * sh1
            val sh3 = B * sh1
            val sh4 = 1 + sh3
            return  ( sh2 * sh4)
        }

        fun diamondRaman (dia0 : Double, dia : Double) : Double
        {
            val a = -0.00275
            val b = 2.61
            val c = dia0 - dia
            val D = (b * b) - (4 * a * c)
            val routeD = pow(D, 0.5)
            val p = (- b + routeD) / (2 * a)
            val pressure = ((p * 100).roundToLong()) / 100
            return pressure.toDouble()
        }

        fun diamondAnvilRaman (dia0 : Double, dia : Double) : Double
        {
            val diK = 547.0
            val diKp = 3.75
            val rat1 = (dia - dia0) / dia0
            val part1 = diK * rat1
            val part2 = 0.5 * (diKp - 1)
            val part3 = 1 + (part2 * rat1)
            val p = part1 * part3
            val pressure = ((p * 100).roundToLong()) / 100
            return pressure.toDouble()
        }
    }
}