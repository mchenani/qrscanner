package workebase.qrscanner.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import workebase.qrscanner.data.qritem.datasource.local.ScanHistoryDao
import workebase.qrscanner.data.qritem.entity.ScanHistoryItem
import workebase.qrscanner.database.WorkerbaseDatabase.Companion.DB_VERSION


@Database(entities = [ScanHistoryItem::class], version = DB_VERSION,exportSchema = false)
abstract class WorkerbaseDatabase : RoomDatabase() {

    abstract fun scanHistoryDao(): ScanHistoryDao
    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "workerbase_database.db"
        @Volatile
        private var INSTANCE: WorkerbaseDatabase? = null

        fun getInstance(context: Context): WorkerbaseDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: build(context).also { INSTANCE = it }
            }

        private fun build(context: Context) =
            Room.databaseBuilder(context.applicationContext, WorkerbaseDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2)
                .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}