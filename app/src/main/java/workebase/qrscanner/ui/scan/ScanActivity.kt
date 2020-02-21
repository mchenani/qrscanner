package workebase.qrscanner.ui.scan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.SparseArray
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.vision.barcode.Barcode
import info.androidhive.barcode.BarcodeReader
import kotlinx.android.synthetic.main.activity_scan_history.*
import org.koin.android.viewmodel.ext.android.viewModel
import workebase.qrscanner.R
import workebase.qrscanner.data.qritem.entity.ScanHistoryItem
import workebase.qrscanner.ui.history.ScanHistoryActivity


class ScanActivity : AppCompatActivity(),BarcodeReader.BarcodeReaderListener {
    private lateinit var barcodeReader: BarcodeReader
    val viewModel: ScanViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)
        barcodeReader =
            (supportFragmentManager.findFragmentById(R.id.barcode_scanner) as BarcodeReader?)!!

        fab.setOnClickListener {
            startActivity(Intent(this, ScanHistoryActivity::class.java))
        }

    }

    override
    fun onScanned(barcode: Barcode) {
        Log.e(TAG, "onScanned: " + barcode.displayValue)
        barcodeReader.playBeep()
        runOnUiThread {
            Toast.makeText(
                this,
                "Barcode: " + barcode.displayValue,
                Toast.LENGTH_SHORT
            ).show()
            viewModel.insertScanItem(ScanHistoryItem(System.currentTimeMillis(),barcode.displayValue))
        }
    }

    override
    fun onScannedMultiple(barcodes: List<Barcode>) {

    }

    override
    fun onBitmapScanned(sparseArray: SparseArray<Barcode?>?) {
    }

    override
    fun onScanError(errorMessage: String) {
        Log.e(TAG, "onScanError: $errorMessage")
    }

    override
    fun onCameraPermissionDenied() {
        Toast.makeText(this, "Camera permission denied!", Toast.LENGTH_LONG).show()
    }

    companion object {
        private val TAG = ScanActivity::class.java.simpleName
    }
}
