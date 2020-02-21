package workebase.qrscanner.data.qritem.datasource.local

import androidx.lifecycle.LiveData
import workebase.qrscanner.data.qritem.entity.ScanHistoryItem

interface ScanHistoryRepo{
    suspend fun insert(item: ScanHistoryItem)
    suspend fun getScanList(): LiveData<List<ScanHistoryItem>>

}