package workebase.qrscanner.data.qritem.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "scans")
data class ScanHistoryItem(
    @PrimaryKey
    var id: Long,
    val data: String
)