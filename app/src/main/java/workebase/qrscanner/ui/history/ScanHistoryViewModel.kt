package workebase.qrscanner.ui.history

import androidx.lifecycle.MutableLiveData
import workebase.qrscanner.base.BaseViewModel
import workebase.qrscanner.data.qritem.datasource.local.ScanHistoryRepo
import workebase.qrscanner.data.qritem.entity.ScanHistoryItem


class ScanHistoryViewModel(private val scanHistoryRepo: ScanHistoryRepo) : BaseViewModel() {

    val scanHistoryLiveData = MutableLiveData<List<ScanHistoryItem>>()
    init {
        launchDataLoad {
            val result = scanHistoryRepo.getScanList()
            scanHistoryLiveData.value = result.value
        }
    }



}
