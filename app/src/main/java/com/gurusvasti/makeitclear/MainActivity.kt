package com.gurusvasti.makeitclear

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gurusvasti.makeitclear.fragments.CameraFragment
import com.gurusvasti.makeitclear.fragments.HomeFragment
import com.gurusvasti.makeitclear.fragments.ProfileFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val cameraFragment = CameraFragment()
        val profileFragment = ProfileFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.dashboard -> makeCurrentFragment(homeFragment)
                R.id.camera->makeCurrentFragment(cameraFragment)
                R.id.profile-> makeCurrentFragment((profileFragment))
            }
            true
        }


    }






    private fun makeCurrentFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_wrapper, fragment)
        commit()
    }



}
