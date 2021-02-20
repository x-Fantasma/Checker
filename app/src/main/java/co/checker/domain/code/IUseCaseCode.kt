package co.checker.domain.code

interface IUseCaseCode {
    fun checkCode(code: String): String
    fun getCountry(code: String): String
}