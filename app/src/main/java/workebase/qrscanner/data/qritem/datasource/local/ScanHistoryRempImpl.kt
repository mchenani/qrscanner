package workebase.qrscanner.data.qritem.datasource.local

import androidx.lifecycle.LiveData
import workebase.qrscanner.data.qritem.entity.ScanHistoryItem


class ScanHistoryRepoImpl(private val scanHistoryDao: ScanHistoryDao):ScanHistoryRepo{
    override suspend fun insert(item: ScanHistoryItem) {
        scanHistoryDao.insert(item)
    }

    override suspend fun getScanList(): LiveData<List<ScanHistoryItem>> = scanHistoryDao.getAllScans()
}