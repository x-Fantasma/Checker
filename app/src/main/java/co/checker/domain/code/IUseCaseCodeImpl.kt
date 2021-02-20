package co.checker.domain.code

import android.util.Log
import co.checker.core.Countries
import co.checker.core.toInteger
import co.checker.domain.IUseCaseMain
import kotlin.math.abs

class IUseCaseCodeImpl(): IUseCaseCode  {

    var resultTotal = 0
    var resultImpar = 0
    var resultPar = 0

    override fun checkCode(code: String): String {
        resultTotal = 0
        var isValid = "NOT"
        if(code.length == 13 || code.length == 8) {
            setSumaFromImpar(code)
            setSumaFromPar(code)
            if(aproxResult() == code[code.length-1].toInteger()){
                isValid = "YES"
            }
        }
        return isValid
    }

    override fun getCountry(code: String): String {
        var country = ""
        val nroRef = code.substring(0, 3)
        if(nroRef[0].toString() == Countries.EEUU.code){
            country = Countries.EEUU.code
        }else if(nroRef.contains(Countries.INGLATERRA.code)){
            country = Countries.INGLATERRA.code
        }else if(nroRef.contains(Countries.NORUEGA.code)) {
            country = Countries.NORUEGA.code
        }else if (nroRef.contains(Countries.BULGARIA.code)) {
            country = Countries.BULGARIA.code
        }else if(nroRef.contains(Countries.IRLANDA.code)) {
            country = Countries.IRLANDA.code
        }else if(nroRef.contains(Countries.PORTUGAL.code)) {
            country = Countries.PORTUGAL.code
        }else if (nroRef.contains(Countries.VENEZUELA.code)) {
            country = Countries.VENEZUELA.code
        }
        if(nroRef.contains(Countries.CUBA.code)) {
            country = Countries.CUBA.code
        }else if (nroRef.contains(Countries.INDIA.code)) {
            country = Countries.INDIA.code
        }
        Log.d("country", "cumple: ${nroRef.contains(Countries.INGLATERRA.code)}")
        return country
    }

    private fun setSumaFromImpar(code: String) {
        resultImpar = 0
        for (i in 0 .. code.length-3) {
            if(i%2 == 0){
                resultImpar += code[i].toInteger()
            }
        }
    }

    private fun setSumaFromPar(code: String) {
        resultPar = 0
        for (i in 0 .. code.length-2) {
            if(i%2 != 0){
                resultPar += (code[i].toInteger()*3)
            }
        }
        resultTotal = resultPar + resultImpar
    }

    private fun aproxResult() : Int {
        val lastNumber = resultTotal.toString()[resultTotal.toString().length-1].toInteger()
        var aprox = resultTotal
        aprox += (10-lastNumber)
        return abs(aprox-resultTotal)
    }
}