package workebase.qrscanner.di

import android.app.Application
import org.koin.dsl.module
import workebase.qrscanner.data.qritem.datasource.local.ScanHistoryDao
import workebase.qrscanner.data.qritem.datasource.local.ScanHistoryRepo
import workebase.qrscanner.data.qritem.datasource.local.ScanHistoryRepoImpl
import workebase.qrscanner.database.WorkerbaseDatabase

val repositoryModule = module {

    fun provideScanHistoryRepository(
        scanHistoryDao: ScanHistoryDao
    ): ScanHistoryRepo {
        return ScanHistoryRepoImpl(scanHistoryDao)
    }
    single { provideScanHistoryRepository(get()) }

    fun provideScanHistoryDao(context: Application): ScanHistoryDao {
        return WorkerbaseDatabase.getInstance(context).scanHistoryDao()
    }

    single { provideScanHistoryDao(get()) }
}