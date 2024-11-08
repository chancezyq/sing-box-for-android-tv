package io.nekohasekai.sfa.ui.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.nekohasekai.sfa.R

data class NavItem(
    val id: Int,
    val iconRes: Int,
    val title: String
)

class TVNavigationAdapter(
    private val items: List<NavItem>,
    private val onItemSelected: (Int) -> Unit
) : RecyclerView.Adapter<TVNavigationAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.menu_icon)
        val title: TextView = view.findViewById(R.id.menu_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tv_navigation, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.icon.setImageResource(item.iconRes)
        holder.title.text = item.title
        
        holder.itemView.apply {
            setOnClickListener { onItemSelected(item.id) }
            nextFocusUp = if (position == 0) NO_ID else NO_ID
            nextFocusDown = if (position == itemCount - 1) NO_ID else NO_ID
            nextFocusRight = R.id.content_frame
        }
    }

    override fun getItemCount() = items.size
} 