package workebase.qrscanner.ui.scan

import workebase.qrscanner.base.BaseViewModel
import workebase.qrscanner.data.qritem.datasource.local.ScanHistoryRepo
import workebase.qrscanner.data.qritem.entity.ScanHistoryItem

class ScanViewModel(private val scanHistoryRepo: ScanHistoryRepo) : BaseViewModel() {

    fun insertScanItem(scanItem: ScanHistoryItem){
        launchDataLoad {
            scanHistoryRepo.insert(scanItem)
        }
    }



}