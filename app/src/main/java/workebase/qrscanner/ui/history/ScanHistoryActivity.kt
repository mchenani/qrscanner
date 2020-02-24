package workebase.qrscanner.ui.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_scan_history.*
import org.koin.android.viewmodel.ext.android.viewModel
import workebase.qrscanner.R
import workebase.qrscanner.ui.history.adapter.ScanHistoryAdapter

class ScanHistoryActivity : AppCompatActivity() {
    val viewModel: ScanHistoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_history)
        viewModel.scanHistoryLiveData.observe(this, Observer {
            if(it!=null) list.adapter = ScanHistoryAdapter(it)
        })

        fab.setOnClickListener {
            onBackPressed()
        }
    }

}
