package com.example.tablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var x=0;
        toggle = ActionBarDrawerToggle(this, nav_drawer, R.string.start, R.string.stop)
        drawer.inflateMenu(R.menu.drawer_menu)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        fun move_to_another(s: String) {
            val i = Intent(this, frag_activity::class.java)
            i.putExtra("$s", "$s")
            startActivity(i)
        }
        drawer.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.images -> {
                    Toast.makeText(this, "no Images available", Toast.LENGTH_SHORT).show()
                }
                R.id.gallery -> {
                    Toast.makeText(this, "no gallery found", Toast.LENGTH_SHORT).show()
                }
                R.id.video -> {
                    move_to_another("video")
                }
                R.id.audio -> {
                    move_to_another("audio")
                }
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}