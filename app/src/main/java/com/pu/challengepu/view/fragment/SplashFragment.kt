package com.pu.challengepu.view.fragment


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.pu.challengepu.R

/**
 * @author Luan Santiago
 */
class SplashFragment : Fragment() {

    companion object {
        private const val SPLASH_DELAY: Long = 5000
    }

    private var delayHandler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.actionBar?.hide()
        delayHandler = Handler()
        delayHandler!!.postDelayed(runnable, SPLASH_DELAY)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private val runnable: Runnable = Runnable {
        view?.findNavController()?.navigate(R.id.action_splashFragment_to_identificationFragment)
    }

    private fun hideSystemUI() {
        val decorView = activity?.window?.decorView
        decorView?.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    override fun onResume() {
        super.onResume()
        hideSystemUI()
    }

    override fun onDestroy() {
        if (delayHandler != null)
            delayHandler!!.removeCallbacks(runnable)

        super.onDestroy()
    }


}
