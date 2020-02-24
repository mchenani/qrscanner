package workebase.qrscanner.di

import org.koin.core.context.loadKoinModules

object AppModules {
    fun init() = loadKoinModules(
        listOf(
            repositoryModule,
            viewModel
        )
    )
}
