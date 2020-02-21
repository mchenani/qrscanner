package workebase.qrscanner.data.qritem.datasource.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import workebase.qrscanner.data.qritem.entity.ScanHistoryItem

@Dao
interface ScanHistoryDao{
    @Query("SELECT * FROM scans order by id asc")
    fun getAllScans(): LiveData<List<ScanHistoryItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(trip: ScanHistoryItem)
}