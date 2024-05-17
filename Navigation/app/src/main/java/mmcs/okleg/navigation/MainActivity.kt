package mmcs.okleg.navigation

import android.annotation.SuppressLint
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import mmcs.okleg.navigation.databinding.ActivityMainBinding
import mmcs.okleg.navigation.ui.home.HomeViewModel
import mmcs.okleg.navigation.ui.home.list.CustomAdapter
import mmcs.okleg.navigation.ui.home.list.Task

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_details, R.id.navigation_new_item
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()


    }
}