package co.checker.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.checker.domain.IUseCaseMain

class MainViewModel(private val IUseCase: IUseCaseMain) : ViewModel() {

    fun checkTarget(target: String) = IUseCase.checkTarget(target)
    fun getType(target: String) = IUseCase.getType(target)
    fun checkCode(code: String) = IUseCase.checkCode(code)
    fun getCountry(code: String) = IUseCase.getCountry(code)
}

class MainViewModelFactory(val IUseCase: IUseCaseMain): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IUseCaseMain::class.java).newInstance(IUseCase)
    }
}