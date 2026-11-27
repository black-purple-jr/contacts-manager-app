package me.bpxdevjr.contactsmanager

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import me.bpxdevjr.contactsmanager.adapters.ContactAdapter
import me.bpxdevjr.contactsmanager.data.Contact


class MenuActivity : AppCompatActivity() {

    private lateinit var lvMenu: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        lvMenu = findViewById<ListView>(R.id.lvMenu)

        val contacts: MutableList<Contact> = mutableListOf(
            Contact("Abdellah DAKIR ALLAH", "+212 762 500557", R.drawable.ic_user),
            Contact("Abderrahman DAKIR ALLAH", "+212 693 029610", R.drawable.ic_user),
            Contact("Mohamed DAKIR ALLAH", "+212 661 061975", R.drawable.ic_user),
        )

        lvMenu.adapter = ContactAdapter(this, contacts)

        val toolbar = findViewById<MaterialToolbar>(R.id.customPageBar)
        toolbar.setNavigationOnClickListener { finish() }
    }
}