package se.anastasiakantor.pressurecalcapp.helpers

import android.util.Log
import java.lang.Math.pow
import kotlin.math.round

typealias Calibrations = CalculationMethods.rubyCalibrations
typealias Variations = CalculationMethods.diamondVariations


class CalculationMethods {

    companion object{

        fun Shen(lambda0 : Double, lambda: Double) : Double
        {
            val A = 1870.0
            val B = 5.63
            val deltaLambda = lambda - lambda0
            val sh1 = deltaLambda / lambda0
            val sh2 = A * sh1
            val sh3 = B * sh1
            val sh4 = 1 + sh3
            val p = ( sh2 * sh4)
            val pressure = round(p*100)/100
            return pressure
        }

        fun validateNumbersShen(lambda0 : Double, lambda: Double) : Boolean
        {
            return true
        }

        fun Mao(B: Double, lambda0: Double, lambda : Double) : Double
        {
            val A = 1904.0
            val m1 = A / B
            val m2 = lambda / lambda0
            val m3 = pow(m2, B)
            val m4 = m1 * m3
            val p = (m4 - m1)
            val pressure = round(p*100)/100
            return pressure
        }

        fun diamondRaman (dia0 : Double, dia : Double) : Double
        {
            val a = -0.00275
            val b = 2.61
            val c = dia0 - dia
            val D = (b * b) - (4 * a * c)
            val routeD = pow(D, 0.5)
            val p = (- b + routeD) / (2 * a)
            val pressure = round(p*100)/100
            return pressure
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
            val pressure = round(p*100)/100
            return pressure
        }

        fun areNumbersCorrectDiamond (refPeak: Double, gotPeak: Double) : Boolean
        {
            return refPeak in 1200.0..2500.0 && gotPeak in 1200.0..2500.0
        }
    }
    enum class rubyCalibrations {
        SHEN,
        MAO_Hydro,
        MAO_Non_Hydro
    }

    enum class diamondVariations {
        DIAMOND_RAMAN,
        DIAMOND_ANVIL_RAMAN
    }


}

