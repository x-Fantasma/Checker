package co.checker.domain

interface IUseCaseMain {

    fun checkTarget(target: String): String
    fun getType(target: String): String
    fun checkCode(code: String): String
    fun getCountry(code: String): String
}