package com.example.billboostapp.Activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.billboostapp.R
import com.example.billboostapp.R.string.close
import com.example.billboostapp.R.string.open
import com.example.billboostapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var navController: NavController
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        actionBarDrawerToggle= ActionBarDrawerToggle(this, binding.dl, open, close)
        binding.dl.addDrawerListener(actionBarDrawerToggle)
        navController = findNavController(R.id.fragmentContainer)
        actionBarDrawerToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navBar.setNavigationItemSelectedListener {
            navController.navigate(R.id.homeFragment)
            when(it.itemId){
                R.id.m_home->{
                    navController.navigate(R.id.homeFragment)
                }

                R.id.m_clients->{

                    navController.navigate(R.id.clientFragment)
                    //replacefragment(ClientFragment())
                }
                R.id.m_company->{

                   // replacefragment(CompanyFragment())
                    navController.navigate(R.id.companyFragment)
                }
            }
            binding.dl.closeDrawer(GravityCompat.START)
            true
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }
}
