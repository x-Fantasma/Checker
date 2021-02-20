package co.checker.domain

import co.checker.domain.code.IUseCaseCode
import co.checker.domain.target.IUseCaseTarget

class IUseCaseMainImpl(private val iUseCaseTarget: IUseCaseTarget, private val iUseCaseCode: IUseCaseCode)
    : IUseCaseMain {

    override fun checkTarget(target: String): String = iUseCaseTarget.checkTarget(target)

    override fun getType(target: String): String = iUseCaseTarget.getType(target)

    override fun checkCode(code: String): String = iUseCaseCode.checkCode(code)

    override fun getCountry(code: String): String = iUseCaseCode.getCountry(code)
}