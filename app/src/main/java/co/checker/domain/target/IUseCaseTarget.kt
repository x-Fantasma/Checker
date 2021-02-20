package co.checker.domain.target

interface IUseCaseTarget {
    fun checkTarget(target: String): String
    fun getType(target: String): String
}