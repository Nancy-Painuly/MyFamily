package com.example.myfamily

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bottomBar = findViewById<BottomNavigationView>(R.id.bottom_bar)

        bottomBar.setOnItemSelectedListener {


            if(it.itemId==R.id.nav_guard){  //it is just a variable which this function gives us
                inflateFragment(GuardFragment.newInstance())
            }else if(it.itemId== R.id.nav_home){
                inflateFragment(HomeFragment.newInstance())
            }else if(it.itemId== R.id.nav_profile){
                inflateFragment(ProfileFragment.newInstance())
            }else if(it.itemId== R.id.nav_dashboard){
                inflateFragment(DashboardFragment.newInstance())
            }

            true

        }

    }


    private fun inflateFragment(newInstance: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, newInstance)
        transaction.commit()
    }

}