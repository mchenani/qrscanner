package workebase.qrscanner.di

import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import workebase.qrscanner.ui.history.ScanHistoryViewModel
import workebase.qrscanner.ui.scan.ScanViewModel

val viewModel = module {
    viewModel { ScanHistoryViewModel(get()) }
    viewModel { ScanViewModel(get()) }
}