package com.example.ttss

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MajorEtud : AppCompatActivity() {
    var pref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_major_etud)

        pref = applicationContext.getSharedPreferences("application_preference", MODE_PRIVATE)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.koeEt)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host1) as NavHostFragment?

        setupWithNavController(bottomNavigationView, navHostFragment!!.navController)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.appmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout) {
            pref!!.edit().clear().commit()
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
        return true
    }
}