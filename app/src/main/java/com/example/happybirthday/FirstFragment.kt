package com.example.happybirthday

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.happybirthday.databinding.FragmentFirstBinding



/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonNext.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }


        val fireworksView2 = binding.animationViewFireworks2
        val fireworksView3 = binding.animationViewFireworks3

        binding.buttonFirst.setOnClickListener {
            fireworksView2.visibility = View.VISIBLE
            fireworksView2.playAnimation()

            fireworksView3.visibility = View.VISIBLE
            fireworksView3.playAnimation()
        }

        fireworksView2.addAnimatorListener(object : AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                Log.e("Animation:", "start")
            }

            override fun onAnimationEnd(animation: Animator) {
                Log.e("Animation:", "end")
                fireworksView2.visibility = View.GONE
                fireworksView2.clearAnimation()
            }

            override fun onAnimationCancel(animation: Animator) {
                Log.e("Animation:", "cancel")
            }

            override fun onAnimationRepeat(animation: Animator) {
                Log.e("Animation:", "repeat")
            }

        })

        fireworksView3.addAnimatorListener(object : AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                Log.e("Animation:", "start")
            }

            override fun onAnimationEnd(animation: Animator) {
                Log.e("Animation:", "end")
                fireworksView3.visibility = View.GONE
                fireworksView3.clearAnimation()
            }

            override fun onAnimationCancel(animation: Animator) {
                Log.e("Animation:", "cancel")
            }

            override fun onAnimationRepeat(animation: Animator) {
                Log.e("Animation:", "repeat")
            }

        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}