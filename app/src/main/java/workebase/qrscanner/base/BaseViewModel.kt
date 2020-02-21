package workebase.qrscanner.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    val errorMessageLiveData : MutableLiveData<Any> by lazy { MutableLiveData<Any>() }

    fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                block()
            } catch (throwable: Throwable) {
                throwable.printStackTrace()
            } finally {

            }
        }
    }
}