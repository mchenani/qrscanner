package workebase.qrscanner.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import workebase.qrscanner.R
import workebase.qrscanner.data.qritem.entity.ScanHistoryItem
import workebase.qrscanner.databinding.ScanHistoryItemBinding

class ScanHistoryAdapter(val data: List<ScanHistoryItem>? = arrayListOf()) :
    RecyclerView.Adapter<ScanHistoryAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data!![position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ScanHistoryItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.scan_history_item, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data!!.size

    class ViewHolder(private var binding: ScanHistoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ScanHistoryItem) {
            binding.scan = data
            binding.executePendingBindings()
        }
    }
}