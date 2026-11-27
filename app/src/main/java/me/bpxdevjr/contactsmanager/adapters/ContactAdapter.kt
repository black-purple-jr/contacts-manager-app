package me.bpxdevjr.contactsmanager.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import me.bpxdevjr.contactsmanager.R
import me.bpxdevjr.contactsmanager.data.Contact

class ContactAdapter(private val context: Context, private val contacts: List<Contact>) :
    BaseAdapter() {
    override fun getCount(): Int = contacts.size
    override fun getItem(position: Int): Any = contacts[position]
    override fun getItemId(position: Int): Long = position.toLong()

    private class ViewHolder (vue: View) {
        var name: TextView = vue.findViewById(R.id.nom)
        var phoneNumber: TextView = vue.findViewById(R.id.phoneNumber)
        var image: ImageView = vue.findViewById(R.id.image)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vue: View
        var holder: ViewHolder

        if (convertView == null) {
            vue = LayoutInflater.from(context).inflate(R.layout.contact_menu_item, parent, false)
            holder = ViewHolder(vue)
            vue.tag = holder
        } else {
            vue = convertView
            holder = vue.tag as ViewHolder
        }

        val contact = contacts[position]

        holder.image.setImageResource(contact.image)
        holder.name.text = contact.name
        holder.phoneNumber.text = contact.pnoneNumber

        return vue
    }
}