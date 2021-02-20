package co.checker.domain.target

import co.checker.core.Types
import co.checker.core.toInteger

class IUseCaseTargetImpl(): IUseCaseTarget {

    var suma: Int = 0

    override fun checkTarget(target: String): String {
        suma = 0
        var isValid = "NOT"
        if(target.length == 16) {
            for (i in 0..target.length-2){
                val nro = target[i].toInteger()
                if(i%2 == 0){
                    operateNumber(nro)
                }else {
                    suma += nro
                }
            }
            if(target[15].toInteger() == getNroCheck()){
                isValid = validPan(getNroCheck())
            }
        }
        return isValid
    }

    private fun getNroCheck(): Int {
        return suma % 10
    }

    private fun validPan(nroCheck: Int) :  String {
        suma += nroCheck
        return if(suma%10 == 0) "YES"
        else "NOT"
    }

    override fun getType(target: String): String {
        var type = ""
        when(target[0]) {
            '3' -> type = Types.AMERICAN_EXPRESS.toString()
            '4', '0', '2' -> type = Types.VISA.toString()
            '5' -> type = Types.MASTERCARD.toString()
            else -> type = Types.DEFAULT.toString()
        }
        return type
    }

    private fun operateNumber(nro: Int){
        val nroMath = nro*2
        if(nroMath >= 10) {
            for(number: Char in nroMath.toString()){
                suma += number.toInteger()
            }
        }else {
            suma += nroMath
        }

    }
}